/**
 * 
 */
package org.fedy2.weather.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Information about wind.
 * @author fedy2
 */
@XmlRootElement
public class Wind {

	/**
	 * Wind chill in degrees.
	 */
	@XmlAttribute
	protected int chill;
	
	/**
	 * Wind direction, in degrees.
	 */
	@XmlAttribute
	protected int direction;
	
	/**
	 * Wind speed, in the units specified in the speed attribute of the wind speed, 
	 * in the units specified in the speed attribute of the units field of {@link Channel} class. 
	 */
	@XmlAttribute
	protected float speed;

	public Wind()
	{}
	
	/**
	 * @param chill
	 * @param direction
	 * @param speed
	 */
	public Wind(int chill, int direction, float speed) {
		this.chill = chill;
		this.direction = direction;
		this.speed = speed;
	}

	/**
	 * @return the chill
	 */
	public int getChill() {
		return chill;
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
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
