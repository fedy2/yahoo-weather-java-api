/**
 * 
 */
package com.github.fedy2.weather.binding.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fedy2.weather.data.unit.WeekDay;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class WeekDayAdapter extends XmlAdapter<String, WeekDay> {
	
	private Logger logger = LoggerFactory.getLogger(WeekDayAdapter.class);

	@Override
	public WeekDay unmarshal(String v) throws Exception {
		try {
			return WeekDay.valueOf(v.toUpperCase());
		} catch (Exception e)
		{
			logger.warn("Unknow week day \"{}\"", v);
		}
		return null;
	}

	@Override
	public String marshal(WeekDay v) throws Exception {
		return v!=null?v.toString():null;
	}

}
