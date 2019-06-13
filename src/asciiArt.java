

import java.util.*;
import java.io.*;
import java.math.*;


public class asciiArt {

	public static void main(String[] args) {	
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine().toUpperCase();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            String output = "";
                        
        	for (int j = 0; j < T.length(); j++) {     
        		int ch = (int) T.toCharArray()[j];
                //System.out.println(T.toCharArray());
                if ( ch >= ((int) 'A') && ch <= ((int) 'Z') ) 
                	ch = ch - ((int) 'A');
                else 
                	ch = 26;
                output = output.concat(ROW.substring(L*ch, L*(ch+1)));
            }
        	System.out.println(output);
        }     
	}
}
