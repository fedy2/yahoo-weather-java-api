/**
 * 
 */
package org.fedy2.weather.data;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.fedy2.weather.binding.Constants;
import org.fedy2.weather.binding.adapter.RFC822DateAdapter;

/**
 * @author fedy2
 *
 */
@XmlRootElement
public class Item {
	
	/**
	 * The forecast title and time, for example "Conditions for New York, NY at 1:51 pm EST".
	 */
	@XmlElement
	protected String title;
	
	/**
	 * The Yahoo! Weather URL for this forecast.
	 */
	@XmlElement
	protected String link;
	
	/**
	 * A simple summary of the current conditions and tomorrow's forecast, in HTML format, including a link to Yahoo! Weather for the full forecast.
	 */
	@XmlElement
	protected String description;
	
	/**
	 * Unique identifier for the forecast, made up of the location ID, the date, and the time.
	 */
	@XmlElement
	protected String guid;
	
	/**
	 * The date and time this forecast was posted.
	 */
	@XmlElement
	@XmlJavaTypeAdapter(RFC822DateAdapter.class)
	protected Date pubDate;
	
	/**
	 * The latitude of the location.
	 */
	@XmlElement(namespace=Constants.GEO_NAMESPACE_URI, name="lat")
	protected float geoLat;
	
	/**
	 * The longitude of the location.
	 */
	@XmlElement(namespace=Constants.GEO_NAMESPACE_URI, name="long")
	protected float geoLong;
	
	/**
	 * he current weather conditions.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	protected Condition condition;
	
	/**
	 * The weather forecast for specific days.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI, name="forecast")
	protected List<Forecast> forecasts;
	
	public Item()
	{}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the guid
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * @return the pubDate
	 */
	public Date getPubDate() {
		return pubDate;
	}

	/**
	 * @return the geoLat
	 */
	public float getGeoLat() {
		return geoLat;
	}

	/**
	 * @return the geoLong
	 */
	public float getGeoLong() {
		return geoLong;
	}

	/**
	 * @return the condition
	 */
	public Condition getCondition() {
		return condition;
	}

	/**
	 * @return the forecasts
	 */
	public List<Forecast> getForecasts() {
		return forecasts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [title=");
		builder.append(title);
		builder.append(", link=");
		builder.append(link);
		builder.append(", description=");
		builder.append(description);
		builder.append(", guid=");
		builder.append(guid);
		builder.append(", pubDate=");
		builder.append(pubDate);
		builder.append(", geoLat=");
		builder.append(geoLat);
		builder.append(", geoLong=");
		builder.append(geoLong);
		builder.append(", condition=");
		builder.append(condition);
		builder.append(", forecasts=");
		builder.append(forecasts);
		builder.append("]");
		return builder.toString();
	}
}
