/**
 * 
 */
package org.fedy2.weather.binding.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.fedy2.weather.data.unit.WeekDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fedy2
 *
 */
public class WeekDayAdapter extends XmlAdapter<String, WeekDay> {
	
	protected Logger logger = LoggerFactory.getLogger(WeekDayAdapter.class);

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
