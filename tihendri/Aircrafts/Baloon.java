package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;
import tihendri.Interface.Flyable;
import tihendri.Simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    Baloon(String type, Coordinates coordinates) {
        super(type, coordinates);
    }

    private final WeatherTower weatherTower = new WeatherTower();

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        updateCoordinates(this,weather,weatherTower);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public String getName() {
        return "Baloon";
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
