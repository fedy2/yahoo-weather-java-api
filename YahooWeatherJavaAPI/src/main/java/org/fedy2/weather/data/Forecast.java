/**
 * 
 */
package org.fedy2.weather.data;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.fedy2.weather.binding.adapter.DateAdapter;
import org.fedy2.weather.binding.adapter.WeekDayAdapter;
import org.fedy2.weather.data.unit.WeekDay;

/**
 * The weather forecast for a specific day.
 * @author fedy2
 */
@XmlRootElement
public class Forecast {
	
	/**
	 * Day of the week to which this forecast applies.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(WeekDayAdapter.class)
	protected WeekDay day;
	
	/**
	 * The date to which this forecast applies.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(DateAdapter.class)
	protected Date date;
	
	/**
	 * The forecasted low temperature for this day, in the units specified by the unit field in the {@link Channel} class.
	 */
	@XmlAttribute
	protected int low;
	
	/**
	 * The forecasted high temperature for this day, in the units specified by the unit field in the {@link Channel} class.
	 */
	@XmlAttribute
	protected int high;
	
	/**
	 * A textual description of conditions, for example, "Partly Cloudy"
	 */
	@XmlAttribute
	protected String text;
	
	/**
	 * The condition code for this forecast.
	 */
	@XmlAttribute
	protected int code;
	
	public Forecast(){}
	
	/**
	 * @param day
	 * @param date
	 * @param low
	 * @param high
	 * @param text
	 * @param code
	 */
	public Forecast(WeekDay day, Date date, int low, int high,
			String text, int code) {
		this.day = day;
		this.date = date;
		this.low = low;
		this.high = high;
		this.text = text;
		this.code = code;
	}

	/**
	 * @return the day
	 */
	public WeekDay getDay() {
		return day;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the low
	 */
	public int getLow() {
		return low;
	}

	/**
	 * @return the high
	 */
	public int getHigh() {
		return high;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Forecast [day=");
		builder.append(day);
		builder.append(", date=");
		builder.append(date);
		builder.append(", low=");
		builder.append(low);
		builder.append(", high=");
		builder.append(high);
		builder.append(", text=");
		builder.append(text);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}
}
