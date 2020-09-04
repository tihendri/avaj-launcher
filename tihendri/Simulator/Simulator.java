package tihendri.Simulator;

import tihendri.Aircrafts.AircraftFactory;
import tihendri.ErrorHandling.ErrorAircraftValues;
import tihendri.ErrorHandling.ErrorSimulationNumber;
import tihendri.ErrorHandling.Exceptions.CustomException;
import tihendri.Interface.Flyable;
import tihendri.Weather.WeatherTower;

import java.io.*;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Simulator {
    public static WeatherTower weatherTower = new WeatherTower();

    public static void main(String[] argv) throws FileNotFoundException {
        PrintStream fileWriter = new PrintStream("simulation.txt");
        System.setOut(fileWriter);
        int simulations;
        if (argv.length == 0) {
            throw new CustomException((char)27 + "[031mError: No scenario file specified. Where am I supposed to get my input data? Stop messing around please..." + (char)27 + "[0m");
        } else {
            File file = new File(argv[0]);
            Scanner fileReader = new Scanner(file);
            if (!fileReader.hasNext()) {
                throw new CustomException((char)27 + "[031mError: That file was empty. Nothing to work with there..." + (char)27 + "[0m");
            }
            simulations = ErrorSimulationNumber.SimulationIsNumber(fileReader);
            ErrorSimulationNumber.SimulationIsPositive(simulations);
            if (!fileReader.hasNext()) {
                throw new CustomException((char)27 + "[031mError: That scenario file was incomplete. Please finish it or specify another." + (char)27 + "[0m");
            }
            if (fileReader.hasNextLine()) {
                do {
                    String fileContent = fileReader.nextLine();
                    if (fileContent != null) {
                        if (fileContent.equals("")) {
                            throw new CustomException((char)27 + "[031mError: That scenario file is not formatted correctly. Fix it or specify another file." + (char)27 + "[0m");
                        }
                        String[] attributes = fileContent.split(" ");
                        if (attributes.length != 5) {
                            throw new CustomException((char)27 + "[031mError: That scenario file is not formatted correctly. Fix it or specify another file." + (char)27 + "[0m");
                        }
                        ErrorAircraftValues.AircraftName(attributes);
                        ErrorAircraftValues.AircraftAttributesArePositive(attributes);
                        ErrorAircraftValues.AircraftAttributesAmount(attributes);
                        Flyable aircraft = AircraftFactory.newAircraft(attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]));
                        aircraft.registerTower(weatherTower);
                    }
                } while (fileReader.hasNextLine());
            }
            IntStream.rangeClosed(1, simulations).forEach(i -> {
                out.println();
                out.println("Simulation " + i);
                weatherTower.changeWeather();
            });
            out.println();
            out.println("All " + simulations + " simulations are complete.");
            fileReader.close();
            fileWriter.close();
        }
    }
}
