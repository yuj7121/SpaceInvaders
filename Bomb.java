/*
name: Yujin Bae
teacher: Mr. Guglielmi
Date: November 6, 2020
Describtion: This is the bomb class of the final project game space invaders.
This class will create bomb objects that are dropped by the enemies.
*/

// The "Bomb" class.
import java.awt.*;
import hsa.Console;

public class Bomb extends Thread
{
    //variable declaration
    private Console c;          // The output console
    private int x;              //this variable will hold the x coordinate pof the bomb
    private int y;              //this variable hoolds the y coordinate of the bomb
    private boolean playerHit;  //this varibale indicates wether the bomb has hit a player or not

    //this method will construct the bomb object
    //console c for parameter passing, int ex and ey for the enemie's x and y coordinates
    public Bomb (Console c, int x, int y)
    {
	//The parameter's console c is passed to this class's console c to display output
	this.c = c;
	this.x = x;
	this.y = y;

    }


    //this method will draw the graphics of the bomb
    private void drawBomb ()
    {
	for (int i = 0 ; i < 500 ; i++)
	{
	    c.setColor (Color.black);
	    c.fillRect (x + 8, y + 16, 4, 2);
	    c.setColor (Color.white);
	    c.fillRect (x + 8, y + 18, 4, 20);
	    y++;
	    try
	    {
		sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}

    }


    //this method will check if the bomb has hit a player or not
    //takes a player object as an input to
    private void setPlayerHit (Player p)
    {
	int px = p.getPlayerX ();
	if ((px <= x && x <= px + 50) && (y >= 450 && y <= 475))
	{
	    playerHit = true;
	}


	else
	{
	    playerHit = false;
	}
    }


    //this method wil;l return wether the bomb has hit a player or not
    public boolean getPlayerHit (Player p)
    {
	setPlayerHit (p);
	return playerHit;
    }


    public void run ()
    {
	drawBomb ();
    }
} // Bomb class


