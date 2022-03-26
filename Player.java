/*
name: Yujin Bae
teacher: Mr. Guglielmi
Date: November 6, 2020
Describtion: This is the player class of the final project game space invaders.
This class will create a player that can move left and right with keypress*/

// The "Player" class.
import java.awt.*;
import hsa.Console;

public class Player
{
    //variable declaration section
    private Console c;           // The output console
    private int x;               //the x coordinate of the player

    //this is the constrcutor method that will create a player object
    //The console is passes to display output
    public Player (Console c)
    {
	this.c = c;
	drawPlayer ();
	input ();

    }


    //this method draws the graphics of the player
    private void drawPlayer ()
    {
	c.setColor (new Color (4, 245, 4)); //sets the colour to green
	c.fillRect (x + 23, 450, 4, 3);     //the top small square
	c.fillRect (x + 21, 453, 8, 5);     //the top middle square
	c.fillRect (x + 4, 458, 42, 4);     //the third layer rectangle
	c.fillRect (x, 462, 50, 12);        //the bottom huge reectangle
    }


    //this method will take input from the user
    private void input ()
    {
	char wasd;      //this char wll hold the user's input
	while (true)
	{
	    wasd = c.getChar ();
	    if (wasd == 'a')
	    {
		x -= 2;
	    }
	    else if (wasd == 'd')
	    {
		x += 2;
	    }
	    else if (wasd == 'w' || wasd == 's')
	    {

	    }
	}
    }


    //this method will return the player's x cooordinate
    public int getPlayerX ()
    {
	return x;
    }
} // Player class
