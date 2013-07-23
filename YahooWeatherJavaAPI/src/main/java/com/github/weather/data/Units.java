/**
 * 
 */
package com.github.weather.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.weather.binding.adapter.DegreeUnitAdapter;
import com.github.weather.binding.adapter.DistanceUnitAdapter;
import com.github.weather.binding.adapter.PressureUnitAdapter;
import com.github.weather.binding.adapter.SpeedUnitAdapter;
import com.github.weather.data.unit.DegreeUnit;
import com.github.weather.data.unit.DistanceUnit;
import com.github.weather.data.unit.PressureUnit;
import com.github.weather.data.unit.SpeedUnit;

/**
 * Units for various aspects of the forecast.
 * @author "Federico De Faveri defaveri@gmail.com"
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
