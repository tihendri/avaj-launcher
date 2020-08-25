package tihendri.Tower;

import tihendri.Interface.Flyable;

import java.util.ArrayList;

public class Tower {
//    private ArrayList<Flyable> unsubscribe = new ArrayList<>();
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (flyable.getCoordinates().getHeight() > 0) {
            observers.add(flyable);
            System.out.println("Tower says: " + flyable.getType() + "#" + flyable.getName() + '(' + flyable.getId() + ") registered to the weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        System.out.println(flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ")" + " landing.");
        System.out.println("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ") unregistered from weather tower.");
        System.out.println(flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ") Coordinates(Longitude = " + flyable.getCoordinates().getLongitude() + " and Latitude = " + flyable.getCoordinates().getLatitude() + ")");
    }

    protected void conditionsChanged() {
        for (int count = 0; count < observers.size(); count++) {
            observers.get(count).updateConditions();

            if (observers.get(count).getCoordinates().getHeight() <= 0) {
                observers.remove(count);
                count--;
            }
        }
    }
}