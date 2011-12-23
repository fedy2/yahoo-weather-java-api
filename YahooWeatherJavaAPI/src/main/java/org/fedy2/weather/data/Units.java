/**
 * 
 */
package org.fedy2.weather.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.fedy2.weather.binding.adapter.DegreeUnitAdapter;
import org.fedy2.weather.binding.adapter.DistanceUnitAdapter;
import org.fedy2.weather.binding.adapter.PressureUnitAdapter;
import org.fedy2.weather.binding.adapter.SpeedUnitAdapter;
import org.fedy2.weather.data.unit.DegreeUnit;
import org.fedy2.weather.data.unit.DistanceUnit;
import org.fedy2.weather.data.unit.PressureUnit;
import org.fedy2.weather.data.unit.SpeedUnit;

/**
 * Units for various aspects of the forecast.
 * @author fedy2
 */
@XmlRootElement
public class Units {
	
	/**
	 * Temperature unit.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(DegreeUnitAdapter.class)
	protected DegreeUnit temperature;
	
	/**
	 * Distance unit.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(DistanceUnitAdapter.class)
	protected DistanceUnit distance;
	
	/**
	 * Units of barometric pressure.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(PressureUnitAdapter.class)
	protected PressureUnit pressure;
	
	/**
	 * Units of speed.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(SpeedUnitAdapter.class)
	protected SpeedUnit speed;
	
	public Units(){}

	/**
	 * @param temperature
	 * @param distance
	 * @param pressure
	 * @param speed
	 */
	public Units(DegreeUnit temperature, DistanceUnit distance,
			PressureUnit pressure, SpeedUnit speed) {
		this.temperature = temperature;
		this.distance = distance;
		this.pressure = pressure;
		this.speed = speed;
	}

	/**
	 * @return the temperature
	 */
	public DegreeUnit getTemperature() {
		return temperature;
	}

	/**
	 * @return the distance
	 */
	public DistanceUnit getDistance() {
		return distance;
	}

	/**
	 * @return the pressure
	 */
	public PressureUnit getPressure() {
		return pressure;
	}

	/**
	 * @return the speed
	 */
	public SpeedUnit getSpeed() {
		return speed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Units [temperature=");
		builder.append(temperature);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", pressure=");
		builder.append(pressure);
		builder.append(", speed=");
		builder.append(speed);
		builder.append("]");
		return builder.toString();
	}
}
