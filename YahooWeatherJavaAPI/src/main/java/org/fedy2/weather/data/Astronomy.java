/**
 * 
 */
package org.fedy2.weather.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.fedy2.weather.binding.adapter.TimeAdapter;
import org.fedy2.weather.data.unit.Time;

/**
 * Information about astronomical conditions.
 * @author fedy2
 */
@XmlRootElement
public class Astronomy {

	/**
	 * Today's sunrise time.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(TimeAdapter.class)
	protected Time sunrise;
	
	/**
	 * Today's sunset time.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(TimeAdapter.class)
	protected Time sunset;
	
	public Astronomy()
	{}
	
	/**
	 * @param sunrise
	 * @param sunset
	 */
	public Astronomy(Time sunrise, Time sunset) {
		this.sunrise = sunrise;
		this.sunset = sunset;
	}

	/**
	 * @return the sunrise
	 */
	public Time getSunrise() {
		return sunrise;
	}

	/**
	 * @return the sunset
	 */
	public Time getSunset() {
		return sunset;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Astronomy [sunrise=");
		builder.append(sunrise);
		builder.append(", sunset=");
		builder.append(sunset);
		builder.append("]");
		return builder.toString();
	}	
}
