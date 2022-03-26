/*
name: Yujin Bae
teacher: Mr. Guglielmi
Date: November 6, 2020
Describtion: This is the player class of the final project game space invaders.
This class will create a player that can move left and right with keypress*/

// The "Player" class.
import java.awt.*;
import hsa.Console;

public class Player extends Thread
{
    //variable declaration section
    private Console c;            // The output console
    private int x = 225;          //the x coordinate of the player
    private Missile m1;           //declares a new missile 1 object
    private Missile m2;           //declares a new missile 2 object
    private boolean p1;           //whether this is player one or player two
    boolean go = false;           //whether the missile should go or not

    //this is the constrcutor method that will create a player object
    //The console is passes to display output
    public Player (Console c, boolean p1)
    {
	this.c = c;             //parameter passing
	this.p1 = p1;           //parameter passing

	m1 = new Missile (c);   //initialize a missile for player 1
	m2 = new Missile (c);   //initialize a mmissile for player 2
    }


    //this method will take input from the user and move the cannon or shooot a missile
    private void input ()
    {
	if (p1)
	{
	    char wasd;      //this char wll hold the user's input
	    wasd = c.getChar ();
	    if (wasd == 'a')
	    {
		if (x > 5)
		    x -= 2;
	    }
	    else if (wasd == 'd')
	    {
		if (x < 445)
		    x += 2;
	    }
	    else if (wasd == 'w' || wasd == 's')
	    {

		if (m1.getLoad ())
		{
		    m1.setMissileX (x);
		    m1.start ();
		}
	    }
	}
	if (!p1)
	{
	    char ijkl;                 //this char wll hold the user's input
	    ijkl = c.getChar ();
	    if (ijkl == 'j')
	    {
		if (x > 5)

		    x -= 2;
	    }
	    else if (ijkl == 'l')
	    {
		if (x < 445)

		    x += 2;
	    }
	    else if ((ijkl == 'i' || ijkl == 'k'))
	    {
		if (m2.getLoad ())
		{
		    m2.setMissileX (x);
		    m2.start ();
		}
	    }
	}
    }


    //this method draws the graphics of the player
    private void drawPlayer ()
    {
	while (true)
	{

	    c.setColor (Color.black);
	    c.fillRect (x - 2, 448, 54, 29);
	    c.setColor (new Color (4, 245, 4)); //sets the colour to green
	    c.fillRect (x + 23, 450, 4, 3);     //the top small square
	    c.fillRect (x + 21, 453, 8, 5);     //the top middle square
	    c.fillRect (x + 4, 458, 42, 4);     //the third layer rectangle
	    c.fillRect (x, 462, 50, 12);        //the bottom huge reectangle
	    input ();
	}
    }


    //this method will return the player's x cooordinate
    public int getPlayerX ()
    {
	return x;
    }


    //this method will set the missile's x coordinate
    private int setMissileX ()
    {
	if (p1)
	{
	    if (m1 != null)
	    {
		return m1.getMissileX ();
	    }
	    else
	    {
		return 0;
	    }
	}
	else
	{
	    if (m2 != null)
	    {
		return m2.getMissileX ();
	    }
	    else
	    {
		return 0;
	    }
	}
    }


    //this method will return the x coordinate of player's missile
    public int getMissileX ()
    {
	return setMissileX ();
    }


    //this method will set the y coordinate of the player's misssile
    private int setMissileY ()
    {
	if (p1)
	{
	    if (m1 != null)
	    {
		return m1.getMissileY ();
	    }
	    else
	    {
		return 0;
	    }
	}
	else
	{
	    if (m2 != null)
	    {
		return m2.getMissileY ();
	    }
	    else
	    {
		return 0;
	    }
	}
    }


    //this method returns the y coordinate of player's missile
    public int getMissileY ()
    {
	return setMissileY ();
    }


    //this method will set whether the missile should continue to go or not
    public void setEnemyHit (boolean go)
    {
	this.go = go;
    }


    //this method will return whether the missile has hit an enemy or not
    public boolean getEnemyHit ()
    {
	if (go == true)
	{
	    return go;
	}
	else
	{
	    return false;
	}
    }


    //this method is from thread class. it runs the player's animation
    public void run ()
    {
	drawPlayer ();
    }
} // Player class


