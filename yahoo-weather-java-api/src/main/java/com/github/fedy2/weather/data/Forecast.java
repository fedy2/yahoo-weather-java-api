/**
 * 
 */
package com.github.fedy2.weather.data;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.weather.binding.adapter.DateAdapter;
import com.github.fedy2.weather.binding.adapter.WeekDayAdapter;
import com.github.fedy2.weather.data.unit.WeekDay;

/**
 * The weather forecast for a specific day.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
@XmlRootElement
public class Forecast {
	
	/**
	 * Day of the week to which this forecast applies.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(WeekDayAdapter.class)
	private WeekDay day;
	
	/**
	 * The date to which this forecast applies.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;
	
	/**
	 * The forecasted low temperature for this day, in the units specified by the unit field in the {@link Channel} class.
	 */
	@XmlAttribute
	private int low;
	
	/**
	 * The forecasted high temperature for this day, in the units specified by the unit field in the {@link Channel} class.
	 */
	@XmlAttribute
	private int high;
	
	/**
	 * A textual description of conditions, for example, "Partly Cloudy"
	 */
	@XmlAttribute
	private String text;
	
	/**
	 * The condition code for this forecast.
	 */
	@XmlAttribute
	private int code;
	
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
	 * Returns the day of the week to which this forecast applies.
	 * @return the day
	 */
	public WeekDay getDay() {
		return day;
	}

	/**
	 * Returns the date to which this forecast applies.
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the forecasted low temperature for this day, in the units specified by the unit field in the {@link Channel} class.
	 * @return the low
	 */
	public int getLow() {
		return low;
	}

	/**
	 * Returns the forecasted high temperature for this day, in the units specified by the unit field in the {@link Channel} class.
	 * @return the high
	 */
	public int getHigh() {
		return high;
	}

	/**
	 * Returns a textual description of conditions, for example, "Partly Cloudy"
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns the condition code for this forecast.
	 * The code are listed here: http://developer.yahoo.com/weather/#codes
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
