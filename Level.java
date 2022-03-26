/*
Name Yujin Bae
teacher: Mr. Guglielmi
Date: november, 6, 2020
description: This is the level class of the final project space invaders game.
this class will draw all the enemies and the player, and let the user play a level.
*/

// The "Level" class.
import java.awt.*;
import hsa.Console;
import java.lang.*;

public class Level
{
    //variable declaration
    private Console c;                  // The output console
    private boolean mul;                //whether the game will be multiplayer or not
    private int s;                      //the speed of the enemies
    private Player p1;                  //first player object declared
    private Player p2;                  //second player object declared
    private boolean levelEnd = false;   //this boolean holds whether the level is finished or not

    //this is the constructor of the method.
    public Level (Console c, int s, boolean mul)
    {
	this.c = c;
	this.s = s;
	this.mul = mul;
	joining ();
    }


    //this method will draw the players with the player number provided by the parameter
    private void drawPlayers ()
    {
	if (mul == true)
	{
	    p1 = new Player (c, true);
	    p1.start ();

	    p2 = new Player (c, false);
	    p2.start ();
	}
	else
	{
	    p1 = new Player (c, true);
	    p1.start ();
	}
    }


    public void joining ()
    {
	//draws the black background
	c.setColor (Color.black);
	c.fillRect (0, 0, 500, 500);

	drawPlayers ();

	if (mul)
	{
	    AnimateEnemies a = new AnimateEnemies (c, s, p1, p2);
	    a.start ();
	}
	else
	{
	    AnimateEnemies a = new AnimateEnemies (c, s, p1);
	    a.start ();
	}
    }
} // Level class


