/**
 * 
 */
package org.fedy2.weather.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.fedy2.weather.data.Rss;

/**
 * @author fedy2
 *
 */
public class TestJaxB {

	/**
	 * @param args
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		Logger.getLogger("org.fedy2").addAppender(new ConsoleAppender(new SimpleLayout()));
		JAXBContext context = JAXBContext.newInstance(Rss.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Rss rss = (Rss)unmarshaller.unmarshal(new FileReader("src/test/resources/xml/sample.xml"));
		

		System.out.println(rss.getChannel());
		
	}

}
