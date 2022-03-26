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
    private Player p;           //the player to check collision for.

    //this method will construct the bomb object
    //console c for parameter passing, int ex and ey for the enemie's x and y coordinates
    public Bomb (Console c, int x, int y, Player p)
    {
	this.c = c;         //parameter's console c passed to this class's console c
	this.x = x + 8;     //parameter passing. 8 added to make the missile fire from the center of the enemy.
	this.y = y + 20;    //parameter passing. 20 added so the missile is fired from the enemy's bottom.
	this.p = p;         //parameter passing.
    }


    //this method will draw the graphics of the bomb
    private void drawBomb ()
    {

	for (int i = 0 ; i < 500 ; i++)
	{
	    if (!playerHit)
	    {
		c.setColor (Color.black);
		c.fillRect (x, y - 4, 4, 4);
		c.setColor (Color.white);
		c.fillRect (x, y, 4, 20);
		y++;        //moves the bomb donw by 1 pixel
		setPlayerHit ();   //checks for collision

		try
		{
		    sleep (10);
		}
		catch (Exception e)
		{
		}
	    } //if end
	} //for loop's end
    }


    //this method will check if the bomb has hit a player or not
    //takes a player object as an input to
    private void setPlayerHit ()
    {
	int px = p.getPlayerX ();
	if ((px <= x && x <= px + 50) && (y >= 450 && y <= 500)||p.getPlayerHit())
	{
	    playerHit = true;
	    p.end ();
	}
	else
	{
	    playerHit = false;
	}
    }


    //this method will run the thread
    public void run ()
    {
	drawBomb ();
    }
} // Bomb class


