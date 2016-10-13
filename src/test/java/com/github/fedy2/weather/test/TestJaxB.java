/**
 * 
 */
package com.github.fedy2.weather.test;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class TestJaxB {

	/**
	 * @param args
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Rss.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Rss rss = (Rss)unmarshaller.unmarshal(new FileReader("src/test/resources/xml/sample.xml"));
		
		System.out.println(rss.getResult());
		
		rss = (Rss)unmarshaller.unmarshal(new FileReader("src/test/resources/xml/sample-time-parsing.xml"));
		for (Object o : rss.getResult()) {
			Channel channel = (Channel) o;
			System.out.println("Sunrise: " + channel.getAstronomy().getSunrise());
			System.out.println("Sunset: " + channel.getAstronomy().getSunset());
		}
	}

}
