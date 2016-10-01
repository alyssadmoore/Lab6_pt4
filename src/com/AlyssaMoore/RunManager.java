package com.AlyssaMoore;

public class RunManager {

    public static void main(String[] args) {

        /* main simply calls addTime and findMinTime methods, final result
           being the fastest run times displayed for the user. This could be
           expanded into a text-based GUI for other runLog functions */
        runLog.addTime();
        runLog.findMinTime();

    }
}