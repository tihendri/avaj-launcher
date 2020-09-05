package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;
import tihendri.ErrorHandling.Exceptions.CustomException;
import tihendri.Interface.Flyable;
import tihendri.Simulator.WeatherTower;

public class Aircraft
{
    protected String name;
    protected long id;
    protected Coordinates coordinates;

    private static long idCounter;

    private long nextId()
    {
        idCounter += 1;
        return (idCounter);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        if (coordinates.getHeight() > 0) {
            id = nextId();
        }
    }

    public String getType() {
        return name;
    }

    public String getId() {

        try {
            return String.valueOf(id);
        } catch (Exception e) {
            System.out.println("There was an error when converting integer to String");
            System.exit(0);
            return null;
        }
    }

    private void sunWeather(String aircraftType) {
        switch (aircraftType) {
            case "Baloon":
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                break;
            case "Helicopter":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                break;
            case "JetPlane":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                break;
        }
    }

    private void rainWeather(String aircraftType) {
        switch (aircraftType) {
            case "Baloon":
                coordinates.setHeight(coordinates.getHeight() - 5);
                break;
            case "Helicopter":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case "JetPlane":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                break;
        }
    }

    private void fogWeather(String aircraftType) {
        switch (aircraftType) {
            case "Baloon":
                coordinates.setHeight(coordinates.getHeight() - 3);
                break;
            case "Helicopter":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            case "JetPlane":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                break;
        }
    }

    private void snowWeather(String aircraftType) {
        switch (aircraftType) {
            case "Baloon":
                coordinates.setHeight(coordinates.getHeight() - 15);
                break;
            case "Helicopter":
                coordinates.setHeight(coordinates.getHeight() - 12);
                break;
            case "JetPlane":
                coordinates.setHeight(coordinates.getHeight() - 7);
                break;
        }
    }

    public void updateCoordinates(Flyable flyable, String weather, WeatherTower weatherTower) {
        String aircraftType = flyable.getType();
        String aircraftName = flyable.getName();
        String airId = flyable.getId();

        switch (weather) {
            case "RAIN":
                rainWeather(aircraftName);
                System.out.println(aircraftName + "#" + aircraftType + '(' + airId + "): Hallelujah it's a raining man!");
                break;
            case "SNOW":
                snowWeather(aircraftName);
                System.out.println(aircraftName + "#" + aircraftType + '(' + airId + "): SJW: This snow has white privilege... xD");
                break;
            case "SUN":
                sunWeather(aircraftName);
                System.out.println(aircraftName + "#" + aircraftType + '(' + airId + "): Sun's out, guns out. But don't shoot me please... :[");
                break;
            case "FOG":
                fogWeather(aircraftName);
                System.out.println(aircraftName + "#" + aircraftType + '(' + airId + "): For fog sake! I can't see anything");
                break;
            default:
                throw new CustomException((char) 27 + "[33mError: Big oof!" + (char) 27 + "[0m");
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(flyable);
        }

    }
}
