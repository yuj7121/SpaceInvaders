/*
Name Yujin Bae
teacher: Mr. Guglielmi
Date:L november, 6, 2020
description: This is the level class of the final project space invaders game.
this class will draw all the enemies and the player, and let the user play a level.
*/

// The "Level" class.
import java.awt.*;
import hsa.Console;

public class Level
{
    //variable declaration
    private Console c;           // The output console
    private int speed;                  //the speed of the game
    private int score;                  //this varibale holds the score of the game.
    private Player p;
    private Enemy[] enemies;

    //this is the constructor of the method.
    public Level (Console c, int s)
    {
	this.c = c;
	speed = s;
	gameScreen();
    }


    //this method will draw the enemies, the player, and the clock.
    private void gameScreen ()
    {
	//draws the enemies!!
	enemies = new Enemy [30];   //create an array of enemeis
	for (int i = 0 ; i >= 30 ; i++)
	{
	    if (i <= 10)    //the first row of enemies
	    {
		enemies [i] = new Enemy (c, i * 25, 25);
	    }
	    else if (i <= 20)   //the second row
	    {
		enemies [i] = new Enemy (c, i % 10 * 25, 50);
	    }
	    else    //the third row
	    {
		enemies [i] = new Enemy (c, i % 10 * 25, 75);
	    }

	} //enemy drawing for loop's end

	//draws the player
	p = new Player (c);
	
    }


    //this method will display the gameover screen
    private void gameover ()
    {

    }


    //this method will record the curretn scroe and display it on the top of the screen.
    private void setScore ()
    {

    }


    //this method will return the curretn score
    public int getScore ()
    {
	return score;
    }


    //this method will ask the high scoring user fro their name
    private void getName ()
    {

    }


    //this method will save the highscore and the user's information to a file
    private void saveHighscore ()
    {

    }
    
} // Level class
