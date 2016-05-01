/**
 * 
 */
package com.github.fedy2.weather.binding.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fedy2.weather.data.unit.SpeedUnit;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class SpeedUnitAdapter extends XmlAdapter<String, SpeedUnit> {
	
	/**
	 * Official documentation says kph but the service returns km/h.
	 */
	private static final String KMH = "km/h";
	private static final String MPH = "mph";
	private Logger logger = LoggerFactory.getLogger(SpeedUnitAdapter.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SpeedUnit unmarshal(String v) throws Exception {
		if (MPH.equalsIgnoreCase(v)) return SpeedUnit.MPH;
		if (KMH.equalsIgnoreCase(v)) return SpeedUnit.KMH;
		logger.warn("Unknown speed unit \"{}\"", v);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(SpeedUnit v) throws Exception {
		switch (v) {
			case KMH: return KMH;
			case MPH: return MPH;
			default: return "";
		}
	}

}
