package tihendri.Aircrafts;

import tihendri.Coordinates.Coordinates;

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
}
