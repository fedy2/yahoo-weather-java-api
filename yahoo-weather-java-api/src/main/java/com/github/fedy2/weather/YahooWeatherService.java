/**
 * 
 */
package com.github.fedy2.weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

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
	
	public static final String WEATHER_SERVICE_BASE_URL = "http://weather.yahooapis.com/forecastrss";
	public static final String WOEID_PARAMETER_NAME = "w";
	public static final String DEGREES_PARAMETER_NAME = "u";
	
    protected static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

	protected Logger logger = LoggerFactory.getLogger(YahooWeatherService.class);
	protected RSSParser parser;
	
	public YahooWeatherService() throws JAXBException
	{
		parser = new RSSParser();
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
		logger.trace("getForecast woeid: {} unit: {}", woeid, unit.toString());
		String url = composeUrl(woeid, unit);
		logger.trace("url: {}",url);
		String xml = retrieveRSS(url);
		logger.trace("xml: {}", xml);
		Rss rss = parser.parse(xml);
		return rss.getChannel();
	}
	
	/**
	 * Composes the URL with the specified parameters.
	 * @param woeid the WOEID.
	 * @param unit the unit.
	 * @return the composed URL.
	 */
	protected String composeUrl(String woeid, DegreeUnit unit)
	{
		StringBuilder url = new StringBuilder(WEATHER_SERVICE_BASE_URL);
		url.append('?').append(WOEID_PARAMETER_NAME).append('=').append(woeid);
		url.append('&').append(DEGREES_PARAMETER_NAME).append('=');
		switch (unit) {
			case CELSIUS: url.append('c'); break;
			case FAHRENHEIT: url.append('f'); break;
		}
		return url.toString();		
	}
	
	/**
	 * Open the connection to the service and retrieves the data.
	 * @param serviceUrl the service URL.
	 * @return the service response.
	 * @throws IOException if an error occurs during the connection.
	 */
	protected String retrieveRSS(String serviceUrl) throws IOException
	{
		URL url = new URL(serviceUrl);
		URLConnection connection = url.openConnection();
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
	protected static long copy(Reader input, Writer output) throws IOException {
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
