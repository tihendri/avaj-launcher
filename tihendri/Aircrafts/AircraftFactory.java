package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;
import tihendri.ErrorHandling.Exceptions.CustomException;
import tihendri.Interface.Flyable;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates;
        coordinates = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "Baloon":
                return new Baloon(name, coordinates);
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            default:
                throw new CustomException((char)27 + "[34mError(Code blue): UFO detected! They're here! The aliens are coming!!!" + (char)27 + "[0m");
        }
    }
}
