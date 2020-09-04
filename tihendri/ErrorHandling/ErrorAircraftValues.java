package tihendri.ErrorHandling;

import tihendri.ErrorHandling.Exceptions.CustomException;

public class ErrorAircraftValues {
    public static void AircraftAttributesArePositive(String[] arr) {
        int i = 2;
        while (i < arr.length) {
            int attributeInArray;
            try {
                attributeInArray = Integer.parseInt(arr[i]);
            } catch (Exception e) {
                throw new CustomException((char)27 + "[031mError: You have given the wrong format for an attribute: " + arr[i] + (char)27 + "[0m");
            }

            if (attributeInArray < 0) {
                if (i == 2) {
                    throw new CustomException((char)27 + "[031mError: The Longitude cannot be a negative value for " + arr[0] + "#" + arr[1] + (char)27 + "[0m");
                } else {
                    if (i == 3) {
                        throw new CustomException((char)27 + "[031mError: The Latitude cannot be a negative value for " + arr[0] + "#" + arr[1] + (char)27 + "[0m");
                    } else if (i == 4) {
                        throw new CustomException((char)27 + "[031mError: The Height cannot be a negative value for " + arr[0] + "#" + arr[1] + (char)27 + "[0m");
                    }
                }
            }
            i++;
        }
    }

    public static void AircraftAttributesAmount(String[] arr) {
        if (arr.length != 5) {
            throw new CustomException((char)27 + "[031mError: There must only be 5 attributes for each aircraft. Your problem is: " +
                    arr[0] + "#" + arr[1] + (char)27 + "[0m");
        }
    }

    public static void AircraftName(String[] arr){
        if (arr[0].charAt(0) != arr[1].charAt(0)) {
            throw new CustomException((char)27 + "[031mError: The Aircrafts Name does not start with the first letter of the Aircraft type: " +
                    arr[0] + "#" + arr[1] + (char)27 + "[0m");
        }
    }
}
