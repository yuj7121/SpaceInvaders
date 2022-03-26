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
    private Console c;          // The output console
    private Enemy[] enemies;    //an array of enemies declared
    private boolean enemyHit[] = new boolean [30];  //boolean for holding enemy hit
    private boolean go = true;  //the loops should continue or not
    private int s;              //the speed at which the enemies will move
    private int x = 0;          //for horizontal movement of enemies
    private int y = 0;          //for vertical movements of enemeis
    boolean right = true;       //whether enemies should move right or not
    int down = 0;               //for the downwards movement of the enemies
    private Player p;           //for the bomc to collision check
    private int score;          //the score of the game
    private int enemiesLeft = 30;   //the number of enemies left on screen

    //this is the constructor method
    //console c for parameter passing
    //int s for the speed of the enemies
    //player p for collision checking of that player's missile
    public AnimateEnemies (Console c, int s, Player p)
    {
	this.c = c;                 //parameter passing.
	this.s = s;                 //parameter passing.
	this.p = p;                 //parameter passing.
    }


    //this method will chnage manipulate the variables x and y to change the movements of the enemies
    private void directions ()
    {
	if (right)
	{
	    x += 2;
	    if (x == 250)
	    {
		right = false;
		down = 0;
	    }
	}
	else
	{
	    x -= 2;
	    if (x == 0)
	    {
		right = true;
		down = 0;
	    }
	}
	if (down < s * 2)
	{
	    y += 2;
	    down++;
	}
    }


    //this method will make the enemy randomly shoot a bomb.
    private void dropBomb (int x, int y)
    {
	double ran;    //this variable decides wether to shoot a bomb or not
	ran = Math.random ();
	if (ran < (0.0015 - s*0.0001))    //the bomb is fired randomly
	{
	    Bomb b = new Bomb (c, x, y, p);    //new bomb object created
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
	while (go)
	{
	    //prints out the current score
	    c.print (' ',10);
	    c.print ("Score: ");
	    c.print (score);

	    //draws the enemies!!
	    enemies = new Enemy [30];   //create an array of enemeis
	    for (int i = 0 ; i < 30 ; i++)
	    {
		if (!enemyHit [i])  //the enemy will not be drawn if it was hit
		{
		    if (i < 10)    //the first row of enemies
		    {
			enemies [i] = new Enemy (c, i * 25 + x, 25 + y);
			setEnemyHit (i);
			dropBomb (i * 25 + x, 25 + y);
		    }
		    else if (i < 20)   //the second row
		    {
			enemies [i] = new Enemy (c, i % 10 * 25 + x, 50 + y);
			setEnemyHit (i);
			dropBomb (i % 10 * 25 + x, 25 + y);
		    }
		    else    //the third row
		    {
			enemies [i] = new Enemy (c, i % 10 * 25 + x, 75 + y);
			setEnemyHit (i);
			dropBomb (i % 10 * 25 + x, 25 + y);
		    }
		}
	    } //enemy drawing for loop's end
	    directions ();
	    hitBottom ();

	    try
	    {
		sleep (101 - s * 10);
	    }
	    catch (Exception e)
	    {
	    }

	} //end of while loop
    } //end of the draw enemies method


    //this method checks if the enemy has been hit by player missile
    private void setEnemyHit (int i)
    {
	//initializes the enemy nad the missile's coordinates
	int ex = enemies [i].getEnemyX ();  //enemy x cooridnate
	int ey = enemies [i].getEnemyY ();  //enemy y coordinate
	int mx = p.getMissile ().getMissileX ();     //missile x coordinate
	int my = p.getMissile ().getMissileY ();     //missile y coordinate
	//if there is a collision
	if ((ex <= mx + 4 && mx <= ex + 20) && (ey <= my && my <= ey + 20))
	{
	    //the enemy is erased from the screen
	    c.setColor (Color.black);
	    c.fillRect (enemies [i].getEnemyX (), enemies [i].getEnemyY (), 20, 20);
	    enemyHit [i] = true;    //updates the array that the enemy is hit
	    for (int e = 100 ; e > 0 ; e--)
	    {   //to prevent the error of the missile not disappearing
		p.getMissile ().end (); //stops the misisile from going any further
	    }
	    score += 10;
	    enemiesLeft--;
	}
    }


    //this method will take in an integer and set that as the score
    public void setScore (int i)
    {
	score = i;
    }


    //this method wull return the curretnt score
    public int getScore ()
    {
	return score;
    }


    //this method will return the number of enemies left alive
    public int getEnemiesLeft ()
    {
	return enemiesLeft;
    }


    //this method will end the thread if the enemies have reached the bottom of the screen
    public boolean hitBottom ()
    {
	if (y >= 500)
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }


    //thismethod ends the thread
    public void end ()
    {
	go = false;
    }


    //this method runs the thread
    public void run ()
    {
	drawEnemies ();
    }
} // AnimateEnemies class


