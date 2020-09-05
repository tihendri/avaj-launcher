package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;
import tihendri.Interface.Flyable;
import tihendri.Simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private final WeatherTower weatherTower = new WeatherTower();

    JetPlane(String type, Coordinates coordinates) {
        super(type, coordinates);
    }

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
        return "JetPlane";
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
