/*
Name Yujin Bae
teacher: Mr. Guglielmi
Date: november, 6, 2020
description: This is the missile class of the final project space invaders game.
this class create the missile object to be shot by the player.
*/

// The "Missile" class.
import java.awt.*;
import hsa.Console;

public class Missile extends Thread
{
    //variable declaration
    private Console c;          // The output console
    private int x = 0;              //the x coordinate of the missile
    private int y;        //the y coordinate of the missile
    private boolean go = true;      //whether the missile should continue or not
    private boolean load = true;       //whether a missile is loaded or not
    
    //this is the constructor of the missile class
    public Missile (Console c)
    {
	this.c = c;
    }


    //this method will draw a missile's graphics
    private void drawMissile ()
    {
	y = 450;
	//the missile is fired!
	while (go)
	{
	    c.setColor (Color.white);
	    c.fillRect (x, y, 4, 20);
	    c.setColor (Color.black);
	    c.fillRect (x, y + 20, 4, 2);
	    //if the missile does not hit as enemy or goes off screen, it continues ascending
	    if (y >= -20 )
	    {
		y--;
		load = false;
	    }
	    else
	    {
		load = true;
		//go = false;
	    }

	    try
	    {
		sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	} //while(go) loop end
    } //drawMissile method end


    //this method sets the missile's x coordinate.
    //takes in the player's x coordinate as an input
    public void setMissileX (int x)
    {
	this.x = x + 23;    //+23 to make the missile com form the missile of the cannon
    }


    //this method will return the x location of the missile
    public int getMissileX ()
    {
	return x;
    }


    //this method will return the y location of the missile
    public int getMissileY ()
    {
	return y;
    }
    

    //this method will return the load information of the missile
    public boolean getLoad ()
    {
	return load;
    }


    //this method runs the animation of the missile
    public void run ()
    {
	drawMissile ();
    }
} // Missile class
