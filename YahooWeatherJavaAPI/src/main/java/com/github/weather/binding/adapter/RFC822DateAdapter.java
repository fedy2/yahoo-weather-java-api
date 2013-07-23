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
 * @author fedy2
 *
 */
public class RFC822DateAdapter extends XmlAdapter<String, Date> {

	public static final SimpleDateFormat rfc822DateFormats[] = new SimpleDateFormat[] {
		new SimpleDateFormat("EEE, d MMM yy HH:mm:ss z"),
		new SimpleDateFormat("EEE, d MMM yy HH:mm z"),
		new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z"),
		new SimpleDateFormat("EEE, d MMM yyyy HH:mm z"),
		new SimpleDateFormat("d MMM yy HH:mm z"),
		new SimpleDateFormat("d MMM yy HH:mm:ss z"),
		new SimpleDateFormat("d MMM yyyy HH:mm z"),
		new SimpleDateFormat("d MMM yyyy HH:mm:ss z"),
		//exception to RFC 822 format used by Yahoo "Thu, 22 Dec 2011 1:50 pm CET"
		new SimpleDateFormat("EEE, d MMM yyyy HH:mm a z")}; 

	protected Logger logger = LoggerFactory.getLogger(RFC822DateAdapter.class);
	
	protected SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yy HH:mm:ss z");

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

		for (SimpleDateFormat format:rfc822DateFormats) {
			try {
				return format.parse(v);
			} catch(Exception e)
			{}//skipping exception
		}
		logger.warn("Unknow date format \"{}\"",v);
		return null;
	}

}
