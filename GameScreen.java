/*
Name Yujin Bae
teacher: Mr. Guglielmi
Date:L november, 10, 2020
description: This is the gamescreen class of the final project space invaders game.
this class will load levels, let the user play, die, and input their high score.
*/

// The "GameScreen" class.
import java.awt.*;
import hsa.Console;

public class GameScreen
{

    //variable declaration
    private Console c;           // The output console
    private int score;                  //this varibale holds the score of the game.
    private Enemy[] enemies;            //an array of enemies declared
    private boolean levelEnd = false;   //this boolean holds wether the level is finished or not

    //this is the constructor the method.
    public GameScreen (Console c)
    {
	this.c = c;
	levels ();
    }


    //this method will draw the enemies, the player, and the clock.
    private void levels ()
    {
	Level lev = new Level (c, 1, false);
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


    //this method will ask the high scoring user for their name
    private void inputName ()
    {

    }


    //this method will save the highscore and the user's information to a file
    private void saveHighscore ()
    {

    }
} // GameScreen class


