/**
 * 
 */
package org.fedy2.weather.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author fedy2
 *
 */
@XmlRootElement
public class Rss {

	@XmlElement
	protected Channel channel;
	
	public Rss()
	{}

	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
	
}
