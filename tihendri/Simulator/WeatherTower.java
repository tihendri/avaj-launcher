package tihendri.Simulator;

import tihendri.Coordinates.Coordinates;
import tihendri.Tower.Tower;
import tihendri.Weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather()
    {
        conditionsChanged();
    }
}