/**
 * 
 */
package com.github.fedy2.weather.data;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.weather.binding.Constants;
import com.github.fedy2.weather.binding.adapter.RFC822DateAdapter;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement
public class Channel {
	
	/**
	 * The title of the feed, which includes the location city. For example "Yahoo! Weather - Sunnyvale, CA"
	 */
	@XmlElement
	private String title;
	
	/**
	 * The URL for the Weather page of the forecast for this location. For example http://us.rd.yahoo.com/dailynews/rss/weather/ Sunnyvale__CA/ *http://weather.yahoo.com/ forecast/USCA1116_f.html
	 */
	@XmlElement
	private String link;

	/**
	 * The language of the weather forecast, for example, en-us for US English.
	 */
	@XmlElement
	private String language;
	
	/**
	 * The overall description of the feed including the location, for example "Yahoo! Weather for Sunnyvale, CA"
	 */
	@XmlElement
	private String description;
	
	/**
	 * The last time the feed was updated. The format is in the date format defined by RFC822 Section 5, for example Mon, 256 Sep 17:25:18 -0700.
	 */
	@XmlElement
	@XmlJavaTypeAdapter(RFC822DateAdapter.class)
	private Date lastBuildDate;

	/**
	 * Time to Live; how long in minutes this feed should be cached.
	 */
	@XmlElement
	private long ttl;
	
	/**
	 * The location of this forecast.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	private Location location;
	
	/**
	 * Units for various aspects of the forecast.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	private Units units;
	
	/**
	 * Forecast information about wind.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	private Wind wind;
	
	/**
	 * Forecast information about current atmospheric pressure, humidity, and visibility.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	private Atmosphere atmosphere;
	
	/**
	 * Forecast information about current astronomical conditions.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	private Astronomy astronomy;
	
	/**
	 * The image used to identify this feed.
	 */
	@XmlElement
	private Image image;
	
	/**
	 *
	 * The local weather conditions and forecast for a specific location.
	 */
	@XmlElement
	private Item item;
	
	public Channel()
	{}

	/**
	 * Returns the title of the feed, which includes the location city. For example "Yahoo! Weather - Sunnyvale, CA"
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the URL for the Weather page of the forecast for this location. For example http://us.rd.yahoo.com/dailynews/rss/weather/ Sunnyvale__CA/ *http://weather.yahoo.com/ forecast/USCA1116_f.html
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Returns the language of the weather forecast, for example, en-us for US English.
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Returns the overall description of the feed including the location, for example "Yahoo! Weather for Sunnyvale, CA".
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the last time the feed was updated. The format is in the date format defined by RFC822 Section 5, for example Mon, 256 Sep 17:25:18 -0700.
	 * @return the lastBuildDate
	 */
	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	/**
	 * Returns the time to Live; how long in minutes this feed should be cached.
	 * @return the ttl
	 */
	public long getTtl() {
		return ttl;
	}

	/**
	 * Returns the location of this forecast.
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Returns the units for various aspects of the forecast.
	 * @return the units
	 */
	public Units getUnits() {
		return units;
	}

	/**
	 * Returns the forecast information about wind.
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}

	/**
	 * Returns the forecast information about current atmospheric pressure, humidity, and visibility.
	 * @return the atmosphere
	 */
	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	/**
	 * Returns the forecast information about current astronomical conditions.
	 * @return the astronomy
	 */
	public Astronomy getAstronomy() {
		return astronomy;
	}

	/**
	 * Returns the image used to identify this feed.
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Returns the local weather conditions and forecast for a specific location.
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Channel [title=");
		builder.append(title);
		builder.append(", link=");
		builder.append(link);
		builder.append(", language=");
		builder.append(language);
		builder.append(", description=");
		builder.append(description);
		builder.append(", lastBuildDate=");
		builder.append(lastBuildDate);
		builder.append(", ttl=");
		builder.append(ttl);
		builder.append(", location=");
		builder.append(location);
		builder.append(", units=");
		builder.append(units);
		builder.append(", wind=");
		builder.append(wind);
		builder.append(", atmosphere=");
		builder.append(atmosphere);
		builder.append(", astronomy=");
		builder.append(astronomy);
		builder.append(", image=");
		builder.append(image);
		builder.append(", item=");
		builder.append(item);
		builder.append("]");
		return builder.toString();
	}
}
