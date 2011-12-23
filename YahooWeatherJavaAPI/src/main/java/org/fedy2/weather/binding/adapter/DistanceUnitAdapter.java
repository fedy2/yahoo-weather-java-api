/**
 * 
 */
package org.fedy2.weather.binding.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.fedy2.weather.data.unit.DistanceUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Units for distance adapter, mi for miles or km for kilometers.
 * @author fedy2
 */
public class DistanceUnitAdapter extends XmlAdapter<String, DistanceUnit> {

	protected static final String MI = "mi";
	protected static final String KM = "km";
	protected Logger logger = LoggerFactory.getLogger(DistanceUnitAdapter.class);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DistanceUnit unmarshal(String v) throws Exception {
		if (MI.equalsIgnoreCase(v)) return DistanceUnit.MI;
		if (KM.equalsIgnoreCase(v)) return DistanceUnit.KM;
		logger.warn("Unknown distance unit \"{}\"", v);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(DistanceUnit v) throws Exception {
		switch (v) {
			case KM: return KM;
			case MI: return MI;
			default: return "";
		}
	}

}
