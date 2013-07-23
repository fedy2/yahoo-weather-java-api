/**
 * 
 */
package com.github.weather.binding.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.weather.data.unit.PressureUnit;

/**
 * Units of barometric pressure adapter, in for pounds per square inch or mb for millibars.
 * @author fedy2
 *
 */
public class PressureUnitAdapter extends XmlAdapter<String, PressureUnit> {

	protected static final String MB = "mb";
	protected static final String IN = "in";
	
	protected Logger logger = LoggerFactory.getLogger(PressureUnitAdapter.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PressureUnit unmarshal(String v) throws Exception {
		if (IN.equalsIgnoreCase(v)) return PressureUnit.IN;
		if (MB.equalsIgnoreCase(v)) return PressureUnit.MB;
		logger.warn("Unknown pressure unit \"{}\"", v);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(PressureUnit v) throws Exception {
		switch (v) {
			case IN: return IN;
			case MB: return MB;
			default: return "";
		}
	}

}
