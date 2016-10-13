/**
 * 
 */
package com.github.fedy2.weather.data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement(name="query")
@XmlSeeAlso({Channel.class, Place.class})
public class Rss<T> {
	
	@XmlElement
	private Wrapper<T> results;

	public Rss()
	{}

	/**
	 * Returns the channel.
	 * @return the channel
	 */
	public List<T> getResult() {
		return results.getItems();
	}
}
