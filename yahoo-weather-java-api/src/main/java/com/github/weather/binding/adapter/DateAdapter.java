/**
 * 
 */
package com.github.weather.binding.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class DateAdapter extends XmlAdapter<String, Date> {

	protected Logger logger = LoggerFactory.getLogger(DateAdapter.class);

	protected SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(Date v) throws Exception {
		return dateFormat.format(v);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date unmarshal(String v) throws Exception {

		try {
			return dateFormat.parse(v);
		} catch(Exception e) {
			logger.warn("Unknow date format \"{}\"",v);
			return null;
		}
	}

}
