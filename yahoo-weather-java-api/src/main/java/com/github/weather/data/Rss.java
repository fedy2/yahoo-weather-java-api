/**
 * 
 */
package com.github.weather.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlRootElement
public class Rss {

	@XmlElement
	protected Channel channel;
	
	public Rss()
	{}

	/**
	 * Returns the channel.
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
	
}
