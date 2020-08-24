package tihendri.Weather;

import tihendri.Coordinates.Coordinates;
import tihendri.Tower.Tower;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}