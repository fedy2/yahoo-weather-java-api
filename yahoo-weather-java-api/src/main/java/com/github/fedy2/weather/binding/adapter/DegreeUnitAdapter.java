/**
 * 
 */
package com.github.fedy2.weather.binding.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fedy2.weather.data.unit.DegreeUnit;

/**
 * Degree unit adapter: f for Fahrenheit or c for Celsius (character)
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class DegreeUnitAdapter extends XmlAdapter<String, DegreeUnit> {

	private static final String CELSIUS = "c";
	private static final String FAHRENHEIT = "f";
	
	private Logger logger = LoggerFactory.getLogger(DegreeUnitAdapter.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DegreeUnit unmarshal(String v) throws Exception {
		if (FAHRENHEIT.equalsIgnoreCase(v)) return DegreeUnit.FAHRENHEIT;
		if (CELSIUS.equalsIgnoreCase(v)) return DegreeUnit.CELSIUS;
		logger.warn("Unknown degree unit \"{}\"", v);		
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(DegreeUnit v) throws Exception {
		switch (v) {
			case CELSIUS: return CELSIUS;
			case FAHRENHEIT: return FAHRENHEIT;
			default: return "";
		}
	}

}
