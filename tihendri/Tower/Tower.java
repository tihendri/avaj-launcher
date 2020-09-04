package tihendri.Tower;

import tihendri.Interface.Flyable;

import java.util.ArrayList;

public class Tower {
    protected final ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (flyable.getCoordinates().getHeight() > 0) {
            observers.add(flyable);
            System.out.println("Tower says: " + flyable.getName() + "#" + flyable.getType() + '(' + flyable.getId() + ") has registered to the weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        System.out.println(flyable.getName() + "#" + flyable.getType() + "(" + flyable.getId() + ")" + " is landing...");
        System.out.println("Tower says: " + flyable.getName() + "#" + flyable.getType() + "(" + flyable.getId() + ") has unregistered from weather tower.");
        System.out.println(flyable.getName() + "#" + flyable.getType() + "(" + flyable.getId() + ") Coordinates(Longitude = " + flyable.getCoordinates().getLongitude() + " and Latitude = " + flyable.getCoordinates().getLatitude() + ")");
    }

    protected void conditionsChanged() {
        for (int counter = 0; counter < observers.size(); counter++) {
            observers.get(counter).updateConditions();
            if (observers.get(counter).getCoordinates().getHeight() <= 0) {
                observers.remove(counter);
                counter--;
            }
        }
        if (observers.isEmpty()) {
            System.out.println();
            System.out.println("All aircrafts have landed. The simulation is complete.");
            System.exit(0);
        }
    }
}