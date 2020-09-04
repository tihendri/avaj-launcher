package tihendri.Weather;

import tihendri.Coordinates.Coordinates;

import java.util.Random;

/*
** Four states of weather accounted for and passed into string array.
** Then they are randomized in a series of ternary statements.
*/

public class WeatherProvider {

    // private properties
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    // public methods
    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randWeather = new Random().nextInt(weather.length);
        randWeather = coordinates.getHeight() > 23 ? ++randWeather : --randWeather;
        if (randWeather < 0) {
            randWeather = 3;
        }
        else if (randWeather > 3) {
            randWeather = 0;
        }
        return weather[randWeather];
    }
}