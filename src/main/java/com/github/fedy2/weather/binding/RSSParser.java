/**
 * 
 */
package com.github.fedy2.weather.binding;

import com.github.fedy2.weather.data.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class RSSParser {

	private Unmarshaller unmarshaller;

	public RSSParser() throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(Rss.class);
		unmarshaller = context.createUnmarshaller();
	}

	public <T> Rss<T> parse(String xml) throws JAXBException
	{
		return (Rss<T>)unmarshaller.unmarshal(new StringReader(xml));
	}
	
}
