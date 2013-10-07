yahoo-weather-java-api
======================

A Java library for the yahoo weather RSS feed service

The library is a lightweight wrapper for the Yahoo Weather API (http://developer.yahoo.com/weather/).

The only required dependency is the slf4j-api library.

Usage example:

    YahooWeatherService service = new YahooWeatherService();
    Channel channel = service.getForecast("2502265", DegreeUnit.CELSIUS);
    System.out.println(channel.getDescription());

Dependency declaration:

    <dependency>
         <groupId>com.github.fedy2</groupId>
         <artifactId>yahoo-weather-java-api</artifactId>
         <version>1.0.1</version>
    </dependency>
