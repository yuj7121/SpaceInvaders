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
	c = new Console (25, 63);
    }


    //the main method of the whole program
    public static void main (String[] args)
    {
	MainMenu m = new MainMenu ();
	GameScreen g = new GameScreen (c);
 
    } // main method
} // MainMenu class
