package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;
import tihendri.Interface.Flyable;
import tihendri.Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    protected Helicopter(String type, Coordinates coordinates) {
        super(type, coordinates);
    }

    private WeatherTower weatherTower = new WeatherTower();

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        updateCoordinates(this, weather, weatherTower);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
