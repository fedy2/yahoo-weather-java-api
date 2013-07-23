yahoo-weather-java-api
======================

A Java API for the yahoo weather RSS feed service

The library is a lightweight wrapper for the Yahoo Weather API (http://developer.yahoo.com/weather/).

The only required dependency is the slf4j-api library.

Usage example:

    YahooWeatherService service = new YahooWeatherService();
    Channel channel = service.getForecast("2502265", DegreeUnit.CELSIUS);
    System.out.println(channel.getDescription());
