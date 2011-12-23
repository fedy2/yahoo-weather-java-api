/**
 * 
 */
package org.fedy2.weather.data.unit;

/**
 * @author fedy2
 *
 */
public class Time {
	
	protected int hours;
	protected int minutes;
	protected TimeConvention convention;
	
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
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
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
