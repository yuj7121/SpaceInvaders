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

public class Bomb
{
    //variable declaration
    private Console c;          // The output console
    private int x;              //this variable will hold the x coordinate pof the bomb
    private int y;              //this variable hoolds the y coordinate of the bomb
    private boolean playerHit;  //this varibale indicates wether the bomb has hit a player or not

    //this method will construct the bomb object
    //The console is passes to display output
    public Bomb (Console c, int ex, int ey)
    {
	this.c = c;
	ex = x;
	ey = y;
	drawBomb ();

    }


    //this method will draw the graphics of the bomb
    private void drawBomb ()
    {
	c.setColor (Color.yellow);
	c.fillRect (x + 17, y, 5, 20);
    }


    //this method will check if the bomb has hit a player or not
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
    public boolean getPlayerHit ()
    {
	return playerHit;
    }



} // Bomb class
