/**
 * 
 */
package com.github.fedy2.weather.test;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;

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
		for (int i = 2154617; i<2154717; i++) {
			System.out.print("Testing "+i+" ");
		Channel channel = service.getForecast(String.valueOf(i), DegreeUnit.CELSIUS);
		System.out.println(channel.getDescription());
		}

	}

}
