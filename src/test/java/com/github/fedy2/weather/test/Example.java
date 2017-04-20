/**
 * 
 */
package com.github.fedy2.weather.test;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Place;
import com.github.fedy2.weather.data.unit.DegreeUnit;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

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
		Channel result = service.getForecast("670807", DegreeUnit.CELSIUS);
		System.out.println(result.getDescription());
		System.out.println(result.getTitle());
		
		List<Channel> channels = service.getForecastForLocation("Oristano", DegreeUnit.CELSIUS).first(3);
		for (Channel channel:channels) System.out.println(channel.getTitle());

		List<Place> places = service.getPlaces("Hamburg");
		for (Place place : places) System.out.println(place);
	}

}
