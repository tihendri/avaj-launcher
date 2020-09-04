package tihendri.ErrorHandling;

import tihendri.ErrorHandling.Exceptions.CustomException;

import java.util.Scanner;

public class ErrorSimulationNumber {
    public static int SimulationIsNumber(Scanner fileReader) {
        int sim;
        try{
            sim = Integer.parseInt(fileReader.nextLine());
        } catch (Exception e) {
            throw new CustomException((char) 27 + "[031mError: Either your scenario file did not specify the amount of simulations, or your simulations number is not a number." + (char) 27 + "[0m");
        }
        return sim;
    }

    public static void SimulationIsPositive(int simulations) {
        if (simulations <= 0) {
            throw new CustomException((char) 27 + "[031mError: The amount of simulations cannot be NEGATIVE or ZERO." + (char) 27 + "[0m");
        }
    }
}
