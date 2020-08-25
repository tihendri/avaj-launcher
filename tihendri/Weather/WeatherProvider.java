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
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    // private constructor
    private WeatherProvider() {
    }

    // public methods
    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randWeather = new Random().nextInt(weather.length);
        if (coordinates.getHeight() > 20)
            randWeather++;
        else
            randWeather--;
        if (randWeather < 0)
            randWeather = 3;
        if (randWeather > 3)
            randWeather = 0;
//        randWeather = (coordinates.getHeight() > 20) ? randWeather++ : randWeather--;
//        randWeather = (randWeather < 0) ? 3 : randWeather;
//        randWeather = (randWeather > 3) ? 0 : randWeather;
        return weather[randWeather];
    }



}