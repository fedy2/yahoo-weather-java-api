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
         <version>1.1.0</version>
    </dependency>

Changelog:

    * 1.2.0 YahooWeatherService constructor now accepts a Proxy to be used during service connections
    * 1.1.0 Updated data model: Atmosphere and Wind numeric values have been replaced by corresponding Classes (int to Integer and float to Float) in order to support "missing" values in Weather system response.
    * 1.0.1 fixed issues on Date parsing and local settings
    * 1.0.0 first release
