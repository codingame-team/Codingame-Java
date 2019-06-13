

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Temperature {

    public static void main(String args[]) {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt(); // the number of temperatures to analyse
            ArrayList<Integer> tabTemp = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
                tabTemp.add(t);
            }
            //System.out.println(n + tabTemp.toString());
            
            int minT = tabTemp.get(0);
            for (int t: tabTemp)
                if ( Math.abs(t) < Math.abs(minT) )
                    minT = t;
                else if (Math.abs(t) == Math.abs(minT) && t > 0)
                    minT = t;

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

            System.out.println(minT);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(0);
        }
    }
}