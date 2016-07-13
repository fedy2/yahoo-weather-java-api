yahoo-weather-java-api [![Build Status](https://travis-ci.org/fedy2/yahoo-weather-java-api.svg)](https://travis-ci.org/fedy2/yahoo-weather-java-api)
======================

A Java library for the yahoo weather RSS feed service.

[![Issue Stats](http://issuestats.com/github/fedy2/yahoo-weather-java-api/badge/pr)](http://issuestats.com/github/fedy2/yahoo-weather-java-api)
[![Issue Stats](http://issuestats.com/github/fedy2/yahoo-weather-java-api/badge/issue)](http://issuestats.com/github/fedy2/yahoo-weather-java-api)

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
         <version>2.0.2</version>
    </dependency>

Changelog:

    * 2.0.2 Fixes time parsing when minutes are not padded.
    * 2.0.1 Fixes RFC822 date parsing. Fixed lastBuildDate field parsing.
    * 2.0.0 Changed whole implementation to use YQL for querying
    * 1.2.0 YahooWeatherService constructor now accepts a Proxy to be used during service connections
    * 1.1.0 Updated data model: Atmosphere and Wind numeric values have been replaced by corresponding Classes (int to Integer and float to Float) in order to support "missing" values in Weather system response.
    * 1.0.1 fixed issues on Date parsing and local settings
    * 1.0.0 first release
