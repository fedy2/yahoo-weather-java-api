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
public class Image {
	
	/**
	 * The title of the image, for example "Yahoo! Weather".
	 */
	@XmlElement
	protected String title;
	
	/**
	 * The URL of Yahoo! Weather.
	 */
	@XmlElement
	protected String link;
	
	/**
	 * The URL of the image.
	 */
	@XmlElement
	protected String url;
	
	/**
	 * The width of the image, in pixels.
	 */
	@XmlElement
	protected int width;
	
	/**
	 * The height of the image, in pixels.
	 */
	@XmlElement
	protected int height;

	public Image()
	{}
	
	/**
	 * @param title
	 * @param link
	 * @param url
	 * @param width
	 * @param height
	 */
	public Image(String title, String link, String url, int width,
			int height) {
		this.title = title;
		this.link = link;
		this.url = url;
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Image [title=");
		builder.append(title);
		builder.append(", link=");
		builder.append(link);
		builder.append(", url=");
		builder.append(url);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}
}
