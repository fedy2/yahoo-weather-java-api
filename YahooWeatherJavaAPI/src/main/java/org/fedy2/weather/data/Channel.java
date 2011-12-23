/**
 * 
 */
package org.fedy2.weather.data;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.fedy2.weather.binding.Constants;

/**
 * @author fedy2
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement
public class Channel {
	
	/**
	 * The title of the feed, which includes the location city. For example "Yahoo! Weather - Sunnyvale, CA"
	 */
	@XmlElement
	public String title;
	
	/**
	 * The URL for the Weather page of the forecast for this location. For example http://us.rd.yahoo.com/dailynews/rss/weather/ Sunnyvale__CA/ *http://weather.yahoo.com/ forecast/USCA1116_f.html
	 */
	@XmlElement
	public String link;

	/**
	 * The language of the weather forecast, for example, en-us for US English.
	 */
	@XmlElement
	public String language;
	
	/**
	 * The overall description of the feed including the location, for example "Yahoo! Weather for Sunnyvale, CA"
	 */
	@XmlElement
	public String description;
	
	/**
	 * The last time the feed was updated. The format is in the date format defined by RFC822 Section 5, for example Mon, 256 Sep 17:25:18 -0700.
	 */
	@XmlElement
	public Date lastBuildDate;

	/**
	 * Time to Live; how long in minutes this feed should be cached.
	 */
	@XmlElement
	public long ttl;
	
	/**
	 * The location of this forecast.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	public Location location;
	
	/**
	 * Units for various aspects of the forecast.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	public Units units;
	
	/**
	 * Forecast information about wind.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	public Wind wind;
	
	/**
	 * Forecast information about current atmospheric pressure, humidity, and visibility.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	public Atmosphere atmosphere;
	
	/**
	 * Forecast information about current astronomical conditions.
	 */
	@XmlElement(namespace=Constants.YWEATHER_NAMESPACE_URI)
	public Astronomy astronomy;
	
	/**
	 * The image used to identify this feed.
	 */
	@XmlElement
	public Image image;
	
	/**
	 *
	 * The local weather conditions and forecast for a specific location.
	 */
	@XmlElement
	public Item item;
	
	public Channel()
	{}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the lastBuildDate
	 */
	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	/**
	 * @param lastBuildDate the lastBuildDate to set
	 */
	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	/**
	 * @return the ttl
	 */
	public long getTtl() {
		return ttl;
	}

	/**
	 * @param ttl the ttl to set
	 */
	public void setTtl(long ttl) {
		this.ttl = ttl;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the units
	 */
	public Units getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(Units units) {
		this.units = units;
	}

	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}

	/**
	 * @param wind the wind to set
	 */
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	/**
	 * @return the atmosphere
	 */
	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	/**
	 * @param atmosphere the atmosphere to set
	 */
	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}

	/**
	 * @return the astronomy
	 */
	public Astronomy getAstronomy() {
		return astronomy;
	}

	/**
	 * @param astronomy the astronomy to set
	 */
	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
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
