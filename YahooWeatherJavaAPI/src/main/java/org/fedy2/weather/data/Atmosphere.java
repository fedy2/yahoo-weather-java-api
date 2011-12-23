/**
 * 
 */
package org.fedy2.weather.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.fedy2.weather.binding.adapter.BarometricPressureStateAdapter;
import org.fedy2.weather.data.unit.BarometricPressureState;

/**
 * Information about atmospheric pressure, humidity, and visibility.
 * @author fedy2
 */
@XmlRootElement
public class Atmosphere {

	/**
	 * Humidity, in percent.
	 */
	@XmlAttribute
	protected int humidity;
	
	/**
	 * Visibility, in the units specified by the distance attribute of the units field in the {@link Channel} class. 
	 * Note that the visibility is specified as the actual value * 100. 
	 * For example, a visibility of 16.5 miles will be specified as 1650. A visibility of 14 kilometers will appear as 1400.
	 */
	@XmlAttribute
	protected float visibility;
	
	/**
	 * Barometric pressure, in the units specified by the pressure attribute of the units field in the {@link Channel} class.
	 */
	@XmlAttribute
	protected float pressure;
	
	/**
	 * state of the barometric pressure
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(BarometricPressureStateAdapter.class)
	protected BarometricPressureState rising;

	public Atmosphere()
	{}
	
	/**
	 * @param humidity
	 * @param visibility
	 * @param pressure
	 * @param rising
	 */
	public Atmosphere(int humidity, int visibility, float pressure,
			BarometricPressureState rising) {
		this.humidity = humidity;
		this.visibility = visibility;
		this.pressure = pressure;
		this.rising = rising;
	}

	/**
	 * @return the humidity
	 */
	public int getHumidity() {
		return humidity;
	}

	/**
	 * @return the visibility
	 */
	public float getVisibility() {
		return visibility;
	}

	/**
	 * @return the pressure
	 */
	public float getPressure() {
		return pressure;
	}

	/**
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
