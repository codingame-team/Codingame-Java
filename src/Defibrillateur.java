

import java.util.*;
import java.io.*;
import java.math.*;



/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Defibrillateur {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        double longA = (Math.PI/180) * Double.parseDouble(LON.replace(',','.'));
        double latA = (Math.PI/180) * Double.parseDouble(LAT.replace(',','.'));
        double DMIN = 999999;
        String nomDEFIB = "";
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {            
            String DEFIB = in.nextLine();
            String[] csvLine = DEFIB.split(";");
            //System.out.println(DEFIB);
            //System.out.println(csvLine[1]);
            double longB = (Math.PI/180) * Double.parseDouble(csvLine[4].replace(',','.'));
            double latB = (Math.PI/180) * Double.parseDouble(csvLine[5].replace(',','.'));
            double X = (longB - longA)*Math.cos(((latA+latB)/2));
            double Y = latB - latA;
            double D = Math.sqrt(X*X+Y*Y)*6371;
            if (D < DMIN) {
                DMIN = D;
                nomDEFIB = csvLine[1];
            }
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    	System.out.println(nomDEFIB);
    }
}