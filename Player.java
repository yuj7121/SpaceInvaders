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
    private Missile m;            //declares a new missile  object
    private boolean hit;          //whether the player has been hit by a bomb

    //this is the constrcutor method that will create a player object
    //The console is passes to display output
    public Player (Console c)
    {
	this.c = c;                 //parameter passing
	m = new Missile (c);   //initialize a missile for ? player
    }


    //this method will take input from the user and move the cannon or shooot a missile
    private void input ()
    {
	char input;      //this char wll hold the user's input
	input = c.getChar ();
	if (input == 'a')
	{
	    if (x > 5)
		x -= 4;
	}
	else if (input == 'd')
	{
	    if (x < 445)
		x += 4;
	}
	else if (input == ' ')
	{

	    if (m.getLoad ())
	    {
		m = new Missile (c);
		m.setMissileX (x);
		m.start ();
	    }
	}
    }


    //this method draws the graphics of the player
    private void drawPlayer ()
    {
	while (!hit)
	{
	    c.setColor (Color.black);
	    c.fillRect (x - 4, 448, 58, 29);
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


    //this emthod returns a missile object
    public Missile getMissile ()
    {
	return m;
    }


    //this method ends the player loop
    public void end ()
    {
	hit = true;
	m.end();
    }
    
    //this method will return whether the player has been hit or not
    public boolean getPlayerHit(){
	return hit;
    }

    //this method is from thread class. it runs the player's animation
    public void run ()
    {
	drawPlayer ();
    }
} // Player class


