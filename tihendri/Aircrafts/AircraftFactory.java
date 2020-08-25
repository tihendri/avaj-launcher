package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;
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
                System.out.println((char)27 + "[33mError: UFO detected! We're DOOMED!!!" + (char)27 + "[0m");
                System.exit(1);
                return null;
        }
    }
}
