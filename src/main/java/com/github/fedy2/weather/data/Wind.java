/**
 * 
 */
package com.github.fedy2.weather.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.weather.binding.adapter.FloatAdapter;
import com.github.fedy2.weather.binding.adapter.IntegerAdapter;

/**
 * Information about wind.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
@XmlRootElement
public class Wind {

	/**
	 * Wind chill in degrees.
	 */
	@XmlAttribute(required=false)
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	private Integer chill;
	
	/**
	 * Wind direction, in degrees.
	 */
	@XmlAttribute(required=false)
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	private Integer direction;
	
	/**
	 * Wind speed, in the units specified in the speed attribute of the wind speed, 
	 * in the units specified in the speed attribute of the units field of {@link Channel} class. 
	 */
	@XmlAttribute(required=false)
	@XmlJavaTypeAdapter(FloatAdapter.class)
	private Float speed;

	public Wind()
	{}
	
	/**
	 * @param chill
	 * @param direction
	 * @param speed
	 */
	public Wind(Integer chill, Integer direction, Float speed) {
		this.chill = chill;
		this.direction = direction;
		this.speed = speed;
	}

	/**
	 * Returns the wind chill in degrees.
	 * @return the chill
	 */
	public Integer getChill() {
		return chill;
	}

	/**
	 * Returns the wind direction, in degrees.
	 * @return the direction
	 */
	public Integer getDirection() {
		return direction;
	}

	/**
	 * Returns the wind speed, in the units specified in the speed attribute of the wind speed, 
	 * in the units specified in the speed attribute of the units field of {@link Channel} class. 
	 * @return the speed
	 */
	public Float getSpeed() {
		return speed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wind [chill=");
		builder.append(chill);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", speed=");
		builder.append(speed);
		builder.append("]");
		return builder.toString();
	}
}
