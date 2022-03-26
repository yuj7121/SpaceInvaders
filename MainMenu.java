// The "MainMenu" class.
import java.awt.*;
import hsa.Console;

public class MainMenu
{
    //variable declaration section
    static Console c;           // The output console

    //this method will create the main menu
    private MainMenu ()
    {
	c = new Console (24, 60);

    }


    //the main method o fthe whole program
    public static void main (String[] args)
    {
	MainMenu m = new MainMenu ();

	Level lev1 = new Level (c, 1);
	// Place your program here.  'c' is the output console
    } // main method
} // MainMenu class
