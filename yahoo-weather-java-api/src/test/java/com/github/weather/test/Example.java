/**
 * 
 */
package com.github.weather.test;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.github.weather.YahooWeatherService;
import com.github.weather.data.Channel;
import com.github.weather.data.unit.DegreeUnit;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class Example {

	/**
	 * @param args
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JAXBException, IOException {
		YahooWeatherService service = new YahooWeatherService();
		Channel channel = service.getForecast("2502265", DegreeUnit.CELSIUS);
		System.out.println(channel.getDescription());

	}

}
