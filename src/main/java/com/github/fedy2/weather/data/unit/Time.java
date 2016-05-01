/**
 * 
 */
package com.github.fedy2.weather.data.unit;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class Time {
	
	private int hours;
	private int minutes;
	private TimeConvention convention;
	
	/**
	 * @param hours
	 * @param minutes
	 * @param convention
	 */
	public Time(int hours, int minutes, TimeConvention convention) {
		this.hours = hours;
		this.minutes = minutes;
		this.convention = convention;
	}

	/**
	 * Returns the hours.
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * Returns the minutes.
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * Returns the time convention.
	 * @return the convention
	 */
	public TimeConvention getConvention() {
		return convention;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Time [hours=");
		builder.append(hours);
		builder.append(", minutes=");
		builder.append(minutes);
		builder.append(", convention=");
		builder.append(convention);
		builder.append("]");
		return builder.toString();
	}
}
