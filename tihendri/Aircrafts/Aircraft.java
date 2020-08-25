package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;
import tihendri.Interface.Flyable;
import tihendri.Weather.WeatherTower;

public class Aircraft
{
    protected String type;
    protected long aircraftId;
    protected Coordinates coordinates;

    private long counter = 0;

    private long nextId()
    {
        this.counter++;
        return (counter);
    }

    protected Aircraft(String type, Coordinates coordinates)
    {
        this.type = type;
        this.coordinates = coordinates;
        this.aircraftId = nextId();
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getType() {
        return this.type;
    }

    public String getId() {

        try {
            return String.valueOf(this.aircraftId);
        } catch (Exception e) {
            System.out.println("There was an error when converting integer to String");
            System.exit(0);
            return null;
        }
    }

    private void sunWeather(String type) {

        switch (type) {
            case "Baloon" -> {
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
            }
            case "Helicopter" -> {
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
            }
            case "JetPlane" -> {
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
            }
        }
    }

    private void rainWeather(String type) {
        switch (type) {
            case "Baloon" -> coordinates.setHeight(coordinates.getHeight() - 5);
            case "Helicopter" -> coordinates.setLongitude(coordinates.getLongitude() + 5);
            case "JetPlane" -> coordinates.setLatitude(coordinates.getLatitude() + 5);
        }
    }

    private void fogWeather(String type) {
        switch (type) {
            case "Baloon" -> coordinates.setHeight(coordinates.getHeight() - 3);
            case "Helicopter" -> coordinates.setLongitude(coordinates.getLongitude() + 1);
            case "JetPlane" -> coordinates.setLatitude(coordinates.getLatitude() + 1);
        }
    }

    private void snowWeather(String type) {
        switch (type) {
            case "Baloon" -> coordinates.setHeight(coordinates.getHeight() - 15);
            case "Helicopter" -> coordinates.setHeight(coordinates.getHeight() - 12);
            case "JetPlane" -> coordinates.setHeight(coordinates.getHeight() - 7);
        }
    }

    public void updateCoordinates(Flyable flyable, String weather, WeatherTower weatherTower) {
        String aircraftType = flyable.getType();
        String aircraftName = flyable.getName();
        String aircraftId = flyable.getId();

        switch (weather) {
            case "RAIN" -> {
                rainWeather(aircraftType);
                System.out.println(aircraftType + "#" + aircraftName + '(' + aircraftId + "): Hallelujah it's a raining man!");
            }
            case "SNOW" -> {
                snowWeather(aircraftType);
                System.out.println(aircraftType + "#" + aircraftName + '(' + aircraftId + "): SJW: This snow has some serious privilege... xD ");
            }
            case "SUN" -> {
                sunWeather(aircraftType);
                System.out.println(aircraftType + "#" + aircraftName + '(' + aircraftId + "): Sun's out, guns out. But I don't have any... :[ ");
            }
            case "FOG" -> {
                fogWeather(aircraftType);
                System.out.println(aircraftType + "#" + aircraftName + '(' + aircraftId + "): Fog off!");
            }
            default -> {
                System.out.println((char) 27 + "[33mError: Big oof!" + (char) 27 + "[0m");
                System.exit(1);
            }
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(flyable);
        }

    }
}
