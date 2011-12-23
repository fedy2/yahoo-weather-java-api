/**
 * 
 */
package org.fedy2.weather.data;

import javax.xml.bind.annotation.*;

/**
 * Weather location.
 * @author fedy2
 */
@XmlRootElement
public class Location {
	
	/**
	 * City name.
	 */
	@XmlAttribute
	protected String city;
	
	/**
	 * State, territory, or region, if given
	 */
	@XmlAttribute
	protected String region;
	
	/**
	 * Two-character country code.
	 */
	@XmlAttribute
	protected String country;

	public Location(){}
	
	/**
	 * @param city the city name.
	 * @param region the state, territory, or region.
	 * @param country the two-character country code.
	 */
	public Location(String city, String region, String country) {
		this.city = city;
		this.region = region;
		this.country = country;
	}

	/**
	 * Returns the city name.
	 * @return the city name.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Location [city=");
		builder.append(city);
		builder.append(", region=");
		builder.append(region);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}
}
