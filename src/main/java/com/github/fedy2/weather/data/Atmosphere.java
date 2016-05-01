/**
 * 
 */
package com.github.fedy2.weather.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.weather.binding.adapter.BarometricPressureStateAdapter;
import com.github.fedy2.weather.binding.adapter.FloatAdapter;
import com.github.fedy2.weather.binding.adapter.IntegerAdapter;
import com.github.fedy2.weather.data.unit.BarometricPressureState;

/**
 * Information about atmospheric pressure, humidity, and visibility.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
@XmlRootElement
public class Atmosphere {

	/**
	 * Humidity, in percent.
	 */
	@XmlAttribute(required=false)
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	private Integer humidity;
	
	/**
	 * Visibility, in the units specified by the distance attribute of the units field in the {@link Channel} class. 
	 * Note that the visibility is specified as the actual value * 100. 
	 * For example, a visibility of 16.5 miles will be specified as 1650. A visibility of 14 kilometers will appear as 1400.
	 */
	@XmlAttribute(required=false)
	@XmlJavaTypeAdapter(FloatAdapter.class)
	private Float visibility;
	
	/**
	 * Barometric pressure, in the units specified by the pressure attribute of the units field in the {@link Channel} class.
	 */
	@XmlAttribute(required=false)
	@XmlJavaTypeAdapter(FloatAdapter.class)
	private Float pressure;
	
	/**
	 * state of the barometric pressure
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(BarometricPressureStateAdapter.class)
	private BarometricPressureState rising;

	public Atmosphere()
	{}
	
	/**
	 * @param humidity
	 * @param visibility
	 * @param pressure
	 * @param rising
	 */
	public Atmosphere(Integer humidity, Float visibility, Float pressure,
			BarometricPressureState rising) {
		this.humidity = humidity;
		this.visibility = visibility;
		this.pressure = pressure;
		this.rising = rising;
	}

	/**
	 * Returns the humidity, in percent.
	 * @return the humidity
	 */
	public Integer getHumidity() {
		return humidity;
	}

	/**
	 * Returns the visibility, in the units specified by the distance attribute of the units field in the {@link Channel} class. 
	 * Note that the visibility is specified as the actual value * 100. 
	 * For example, a visibility of 16.5 miles will be specified as 1650. A visibility of 14 kilometers will appear as 1400.
	 * @return the visibility
	 */
	public Float getVisibility() {
		return visibility;
	}

	/**
	 * Returns the barometric pressure, in the units specified by the pressure attribute of the units field in the {@link Channel} class.
	 * @return the pressure
	 */
	public Float getPressure() {
		return pressure;
	}

	/**
	 * Returns the state of the barometric pressure.
	 * @return the rising
	 */
	public BarometricPressureState getRising() {
		return rising;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atmosphere [humidity=");
		builder.append(humidity);
		builder.append(", visibility=");
		builder.append(visibility);
		builder.append(", pressure=");
		builder.append(pressure);
		builder.append(", rising=");
		builder.append(rising);
		builder.append("]");
		return builder.toString();
	}
}
