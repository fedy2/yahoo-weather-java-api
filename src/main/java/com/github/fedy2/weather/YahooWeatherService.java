/**
 * 
 */
package com.github.fedy2.weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fedy2.weather.binding.RSSParser;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Rss;
import com.github.fedy2.weather.data.unit.DegreeUnit;

/**
 * Main access point for the Yahoo weather service.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class YahooWeatherService {

	private static final String WEATHER_SERVICE_BASE_URL = "https://query.yahooapis.com/v1/public/yql";

	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

	public interface LimitDeclaration {

		/**
		 * Limits results to first <code>count</code> {@link Channel}s.
		 * @param count the limit of the number of results.
		 * @return the results.
		 * @throws JAXBException if an error occurs parsing the response.
		 * @throws IOException if an error occurs communicating with the service.
		 */
		List<Channel> first(int count) throws JAXBException, IOException;
		
		/**
		 * Limits results to last <code>count</code> {@link Channel}s.
		 * @param count the limit of the number of results.
		 * @return the results.
		 * @throws JAXBException if an error occurs parsing the response.
		 * @throws IOException if an error occurs communicating with the service.
		 */
		List<Channel> last(int count) throws JAXBException, IOException;
		
		/**
		 * Returns all the results with no limits.
		 * @return the results.
		 * @throws JAXBException if an error occurs parsing the response.
		 * @throws IOException if an error occurs communicating with the service.
		 */
		List<Channel> all() throws JAXBException, IOException;
	}

	private Logger logger = LoggerFactory.getLogger(YahooWeatherService.class);
	private RSSParser parser;
	private Proxy proxy;

	public YahooWeatherService() throws JAXBException
	{
		this.parser = new RSSParser();
		this.proxy = Proxy.NO_PROXY;
	}

	public YahooWeatherService(Proxy proxy) throws JAXBException
	{
		this.parser = new RSSParser();
		this.proxy = proxy;
	}

	/**
	 * Gets the Weather RSS feed.
	 * @param woeid the location WOEID.
	 * @param unit the degrees units.
	 * @return the retrieved Channel.
	 * @throws JAXBException if an error occurs parsing the response.
	 * @throws IOException if an error occurs communicating with the service.
	 */
	public Channel getForecast(String woeid, DegreeUnit unit) throws JAXBException, IOException
	{
		QueryBuilder query = new QueryBuilder();
		query.woeid(woeid).unit(unit);
		List<Channel> channels = execute(query.build());
		if (channels.isEmpty()) throw new IllegalStateException("No results from the service.");
		return channels.get(0);
	}

	/**
	 * Gets the Weather RSS feed for the specified location.
	 * @param location the location to search.
	 * @param unit the degrees units.
	 * @return the limit declaration.
	 */
	public LimitDeclaration getForecastForLocation(String location, DegreeUnit unit)
	{
		final QueryBuilder query = new QueryBuilder();
		query.location(location).unit(unit);

		return new LimitDeclaration() {

			@Override
			public List<Channel> last(int count) throws JAXBException, IOException {
				query.last(count);
				return execute(query.build());
			}

			@Override
			public List<Channel> first(int count) throws JAXBException, IOException {
				query.first(count);
				return execute(query.build());
			}

			@Override
			public List<Channel> all() throws JAXBException, IOException {
				return execute(query.build());
			}
		};
	}

	/**
	 * Composes the URL with the specified query.
	 * @param query the query to submit.
	 * @return the composed URL.
	 */
	private String composeUrl(String query)
	{
		logger.trace("query: {}", query);
		StringBuilder url = new StringBuilder(WEATHER_SERVICE_BASE_URL);
		try {
			url.append("?q=").append(URLEncoder.encode(query, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Url encoding failed", e);
		}
		return url.toString();
	}

	private List<Channel> execute(String query) throws IOException, JAXBException {
		String url = composeUrl(query);
		String xml = retrieveRSS(url);
		Rss rss = parser.parse(xml);
		return rss.getChannels();
	}

	/**
	 * Open the connection to the service and retrieves the data.
	 * @param serviceUrl the service URL.
	 * @return the service response.
	 * @throws IOException if an error occurs during the connection.
	 */
	private String retrieveRSS(String serviceUrl) throws IOException
	{
		URL url = new URL(serviceUrl);
		URLConnection connection = url.openConnection(proxy);
		InputStream is = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(is);
		StringWriter writer = new StringWriter();
		copy(reader, writer);
		reader.close();
		is.close();

		return writer.toString();
	}

	/**
	 * Copy the input reader into the output writer.
	 * @param input the input reader.
	 * @param output the output writer.
	 * @return the number of char copied.
	 * @throws IOException if an error occurs during the copy.
	 */
	private static long copy(Reader input, Writer output) throws IOException {
		char[] buffer = new char[DEFAULT_BUFFER_SIZE];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}
}
