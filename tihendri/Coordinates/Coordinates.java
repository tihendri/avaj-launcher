package tihendri.Coordinates;

/*
** All coordinates that will be used in the simulation. Coordinates will be the same for each aircraft, but
** will change according to the four weather conditions.
*/

public class Coordinates {
    
    // private properties
    private int height;
    private int latitude;
    private int longitude;

    // default constructor
    Coordinates(int longitude, int latitude, int height) {
        if (height > 100)
            this.height = 100;

        else
            this.height = Math.max(height, 0);
        
        if (latitude < 0)
            latitude = 0;
        
        if (longitude < 0)
            longitude = 0;

        this.longitude = longitude;
        this.latitude = latitude;
    }

    // getters
    public int getHeight() {
        return this.height;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

}