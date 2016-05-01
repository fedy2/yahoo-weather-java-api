/**
 * 
 */
package com.github.fedy2.weather.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement(name="query")
@XmlSeeAlso({Channel.class})
public class Rss {
	
	@XmlElement
	private Wrapper<Channel> results;
	
	public Rss()
	{}

	/**
	 * Returns the channel.
	 * @return the channel
	 */
	public List<Channel> getChannels() {
		return results.getItems();
	}
}
