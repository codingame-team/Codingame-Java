package codpkg;

import java.util.*;
import java.io.*;
import java.math.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Diff2Horses {

    int Horse1;
    int Horse2;
    int Difference;

    public Diff2Horses(int h1, int h2, int d) {
        this.Horse1 = h1;
        this.Horse2 = h2;
        this.Difference = d;
    }
}

public class CourseChevaux {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] liste_pi = new int[N];
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            liste_pi[i] = pi;
        }
        
        Arrays.sort(liste_pi);

    	ArrayList<Diff2Horses> diffsList = new ArrayList<Diff2Horses>();
        Diff2Horses best = new Diff2Horses(0,0,0);

        for (int i = 0; i < N-1; i++) {
        	Diff2Horses diff = new Diff2Horses(i, i+1, liste_pi[i+1]-liste_pi[i]);
        	diffsList.add(diff);
            if (i == 0  || best.Difference > diff.Difference) {
            	best.Difference = diff.Difference;
            }
        }
        
        System.out.println(best.Difference);

    }

}