/*
Name Yujin Bae
teacher: Mr. Guglielmi
Date:November, 10, 2020
description: This is the animate enemies class of the final project space invaders game.
this class will draw all the enemies and animatye them to move left, right and then down.
*/

// The "AnimateEnemies" class.
import java.awt.*;
import hsa.Console;

public class AnimateEnemies extends Thread
{
    //varuiable declaration section
    private Console c;           // The output console
    private Enemy[] enemies;            //an array of enemies declared
    private int s;              //the speed at which the enemies will move
    private int x = 0;          //for horizontal movement of enemies
    private int y = 0;          //for vertical movements of enemeis
    boolean right = true;       //whether enemies should move right or not
    boolean down = false;       //whether enemies should move down or not
    private Player p1;           //the player 1 to check collision
    private Player p2 = null;           //the player 2 to check collision
    private boolean enemyHit[] = new boolean [30];  //boolean for holding enemy hit

    //this is the constructor method
    //console c for parameter passing
    //int s for the speed of the enemies
    //player p for collision checking of that player's missile
    public AnimateEnemies (Console c, int s, Player p1)
    {
	this.p1 = p1;
	this.c = c;
	this.s = s;
    }


    //this is the constructor method with overload parameter
    //console c for parameter passing
    //int s for the speed of the enemies
    public AnimateEnemies (Console c, int s, Player p1, Player p2)
    {
	this.p1 = p1;
	this.p2 = p2;
	this.c = c;
	this.s = s;
    }


    //this method will chnage manipulate the variables x and y to change the movements of the enemies
    private void directions ()
    {
	if (right)
	{
	    x++;
	    if (x == 250)
	    {
		right = false;
		down = true;
	    }
	}
	else
	{
	    x--;
	    if (x == 0)
	    {
		right = true;
		down = true;
	    }
	}
	if (down)
	{
	    y += 5;
	    down = false;
	}
    }



    //this method will make the enemy randomly shoot a bomb.
    private void dropBomb (int x, int y)
    {
	double ran;    //this variable decides wether to shoot a bomb or not
	ran = Math.random ();
	if (ran < 0.005)
	{
	    Bomb b = new Bomb (c, x, y);
	    try
	    {
		b.start ();
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    //this method will draw the enemies.
    private void drawEnemies ()
    {
	while (true)
	{
	    //draws the enemies!!
	    enemies = new Enemy [30];   //create an array of enemeis
	    for (int i = 0 ; i < 30 ; i++)
	    {
		if (!enemyHit [i])  //the enemy will not be drawn if it was hit
		{
		    if (i < 10)    //the first row of enemies
		    {
			enemies [i] = new Enemy (c, i * 25 + x, 25 + y);
			dropBomb (i * 25 + x, 25 + y);
			if (p2 == null)
			{
			    collision (p1, i);
			}
			else
			{
			    collision (p1, i);
			    collision (p2, i);
			}
		    }
		    else if (i < 20)   //the second row
		    {
			enemies [i] = new Enemy (c, i % 10 * 25 + x, 50 + y);
			if (p2 == null)
			{
			    collision (p1, i);
			}
			else
			{
			    collision (p1, i);
			    collision (p2, i);
			}
		    }
		    else    //the third row
		    {
			enemies [i] = new Enemy (c, i % 10 * 25 + x, 75 + y);
			if (p2 == null)
			{
			    collision (p1, i);
			}
			else
			{
			    collision (p1, i);
			    collision (p2, i);
			}
		    }
		}
	    } //enemy drawing for loop's end\
	    directions ();
	    try
	    {
		sleep (80 - s * 10);
	    }
	    catch (Exception e)
	    {
	    }
	} //end of while loop
    } //end of the draw enemies method



    private void collision (Player p, int i)
    {
	int ex = enemies [i].getEnemyX ();  //enemy x cooridnate
	int ey = enemies [i].getEnemyY ();  //enemy y coordinate
	int mx = p.getMissileX ();          //missile x coordinate
	int my = p.getMissileY ();          //missile y coordinate
	
	//if there is a collision
	if ((ex <= mx && mx <= ex + 20) && (ey <= my && my <= ey + 20))
	{
	    c.setColor (Color.black);
	    c.fillRect (enemies [i].getEnemyX (), enemies [i].getEnemyY (), 20, 20);
	    enemyHit [i] = true;
	    p.setEnemyHit(true);
	}
    }


    public boolean[] getEnemyHit ()
    {
	return enemyHit;
    }


    public void run ()
    {
	drawEnemies ();

    }
} // AnimateEnemies class


