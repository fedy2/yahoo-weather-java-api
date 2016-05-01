/**
 * 
 */
package com.github.fedy2.weather.data;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.weather.binding.adapter.RFC822DateAdapter;

/**
 * Weather conditions.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
@XmlRootElement
public class Condition {
	
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
	
	/**
	 * The current temperature, in the units specified by the units field of {@link Channel} class.
	 */
	@XmlAttribute
	private int temp;
	
	/**
	 * The current date and time for which this forecast applies.
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(RFC822DateAdapter.class)
	private Date date;

	public Condition()
	{}
	
	/**
	 * @param text
	 * @param code
	 * @param temp
	 * @param date
	 */
	public Condition(String text, int code, int temp, Date date) {
		this.text = text;
		this.code = code;
		this.temp = temp;
		this.date = date;
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
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Returns the current temperature, in the units specified by the units field of {@link Channel} class.
	 * @return the temp
	 */
	public int getTemp() {
		return temp;
	}

	/**
	 * Returns the current date and time for which this forecast applies.
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Condition [text=");
		builder.append(text);
		builder.append(", code=");
		builder.append(code);
		builder.append(", temp=");
		builder.append(temp);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
}
