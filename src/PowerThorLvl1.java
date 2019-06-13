

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement. --- Hint: You can use the debug stream to
 * print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class PowerThorLvl1 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int lightX = in.nextInt(); // the X position of the light of power
		int lightY = in.nextInt(); // the Y position of the light of power
		int initialTX = in.nextInt(); // Thor's starting X position
		int initialTY = in.nextInt(); // Thor's starting Y position

		int TX = initialTX;
		int TY = initialTY;
		
		long timeElapsed = 0;
		String direction = "SE";

		// game loop
		while (true && timeElapsed <= 100) {
			long debut = System.currentTimeMillis();
			int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
			timeElapsed = System.currentTimeMillis() - debut;
			
			// Position 1
			if ( TX < lightX && TY < lightY ) {
			    direction = "SE";
			    TX += 1;
			    TY += 1;
			}
			// Position 2
			else if ( TX == lightX && TY < lightY ) {
			    direction = "S";
			    TY += 1;
			}
			// Position 3
			else if ( TX > lightX && TY < lightY ) {
			    direction = "SW";
			    TX -= 1;
			    TY += 1;
			}
			// Position 4
			else if ( TX > lightX && TY == lightY ) {
			    direction = "W";
			    TX -= 1;
			}
			// Position 5
			else if ( TX > lightX && TY > lightY ) {
			    direction = "NW";
			    TX -= 1;
			    TY -= 1;
			}
			// Position 6
			else if ( TX == lightX && TY > lightY ) {
			    direction = "N";
			    TY -= 1;
			}
			// Position 7
			else if ( TX < lightX && TY > lightY ) {
			    direction = "NE";
			    TX += 1;
			    TY -= 1;
			}
			// Position 8
			else if ( TX < lightX && TY == lightY ) {
			    direction = "E";
			    TX += 1;
			}
			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");
			// A single line providing the move to be made: N NE E SE S SW W or NW
			System.out.println(direction + timeElapsed);
		}
	}
}