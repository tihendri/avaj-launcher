package tihendri.Interface;

import tihendri.Coordinates.Coordinates;
import tihendri.Simulator.WeatherTower;

public interface Flyable
{
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    Coordinates getCoordinates();

    String getType();
    String getName();
    String getId();

}
