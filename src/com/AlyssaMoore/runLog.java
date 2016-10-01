package com.AlyssaMoore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class runLog {

    // new Scanners, ArrayList and HashMap
    static Scanner numberScanner = new Scanner(System.in);
    static Scanner stringScanner = new Scanner(System.in);
    static ArrayList<runLog> runObjects = new ArrayList();
    static HashMap fastestTimes = new HashMap();

    // Creating variables lakeName and runTime
    protected String lakeName;
    protected Double runTime;

    // runLog objects store the lake name and run time
    runLog(String lake, Double time) {
        lakeName = lake;
        runTime = time;
    }

    // lake name getter
    String getLake() {
        return lakeName;
    }

    // run time getter
    Double getTime() {
        return runTime;
    }

    /* addTime method loops over number of runs to be entered, asking user for lake name
       and run time, then creates an object for each run, which is stored in an ArrayList */
    static void addTime() {
        System.out.println("How many runs would you like to add?");
        int numRuns = numberScanner.nextInt();
        for (int x = 0; x < numRuns; x++) {
            System.out.println("Enter lake name for run " + (x + 1));
            String lake = stringScanner.nextLine();
            System.out.println("Enter your run time, with a period separating minutes/seconds: ");
            Double time = numberScanner.nextDouble();
            runObjects.add(new runLog(lake, time));
        }
    }

    /* findMinTime method loops over each runLog object in the ArrayList, getting the lake name. If the
       lake name is in the HashMap, it compares the corresponding time with the runLog time and replaces
       the minTime as necessary, then prints the HashMap of fastest times*/
    static void findMinTime() {
        for (runLog log : runObjects) {
            String lake = log.getLake();
            if (fastestTimes.containsKey(lake)) {
                Double newMinTime = 0.0;
                Double time = log.getTime();
                Double minTime = (Double) fastestTimes.get(lake);
                if (time < minTime) {
                    newMinTime = time;
                }
                fastestTimes.replace(lake, minTime, newMinTime);
            } else {
                Double time = log.getTime();
                fastestTimes.put(lake, time);
            }
        }
        System.out.println("Fastest times: " + fastestTimes);
    }
}