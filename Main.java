/*
Name Yujin Bae
teacher: Mr. Guglielmi
Date:L november, 16, 2020//draws the black background
	c.setColor (Color.black);
	c.fillRect (0, 20, 500, 480);
description: This is the main class of the final project space invaders game.
This is for the main method where the gamescreen calss will be run
*/

// The "Main" class.
import java.awt.*;
import hsa.Console;

public class Main
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console (25, 63);
	GameScreen g = new GameScreen (c);
    } // main method
} // Main class
