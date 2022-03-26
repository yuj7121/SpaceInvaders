/*
name: Yujin Bae
teacher: Mr. Guglielmi
Date: November 6, 2020
Describtion: This is the enemy class of the final project game space invaders.
This class will create indivisual enemies.
*/

// The "Enemy" class.
import java.awt.*;
import hsa.Console;

public class Enemy
{ //declaration section
    private Console c;          // The output console
    private int x;              //the x coordinate of the enemy
    private int y;              //the y coordinate of the enemy
    private boolean enemyHit = false; //whether the neemy is hit or not
    boolean right = true;       //whether enemies should move right or not
    boolean down = false;       //whether enemies should move down or not

    //this is the constructor method.
    //console c for the console the enemy will be drawn in
    //int x and y for the coordinates of the enemy
    public Enemy (Console c, int x, int y)
    {
	//The console is passes to display output
	this.c = c;
	this.x = x;
	this.y = y;
	drawEnemy ();
    }


    //this method will draw the graphics of an enemy
    //int s fo rthe speed of the enemy
    private void drawEnemy ()
    {
	c.setColor (Color.black);           //sets colour to black
	c.fillRect (x - 5, y - 5, 30, 30);  //the black square that will erase any previous tracks of animation
	c.setColor (Color.white);           //sets the colour to green
	c.fillRect (x + 4, y + 2, 2, 2);    //left ear top
	c.fillRect (x + 6, y + 4, 2, 2);    //left ear bottom
	c.fillRect (x + 14, y + 2, 2, 2);   //right ear top
	c.fillRect (x + 12, y + 4, 2, 2);   //rigght ear bottom
	c.fillRect (x + 4, y + 6, 12, 2);   //forehead
	c.fillRect (x + 2, y + 8, 16, 6);   //main head
	c.fillRect (x, y + 12, 2, 6);       //left arm
	c.fillRect (x + 18, y + 12, 2, 6);  //rigth arm
	c.fillRect (x + 4, y + 14, 12, 2);  //chin
	c.fillRect (x + 4, y + 16, 2, 2);   //left middle jaw
	c.fillRect (x + 14, y + 16, 2, 2);  //right middle jaw
	c.fillRect (x + 4, y + 18, 4, 2);   //left bottom jaw
	c.fillRect (x + 12, y + 18, 4, 2);  //right bottom jaw
	c.setColor (Color.black);           //sets the colour to black
	c.fillRect (x + 6, y + 10, 2, 2);   //left eye
	c.fillRect (x + 12, y + 10, 2, 2);  //left eye
    }


    //this method check if enemy is hit by player missile
    private void setEnemyHit (Player p)
    {
	int mx = p.getMissileX ();
	int my = p.getMissileY ();

	if ((x <= mx && mx <= x + 20) && (y <= my && my <= y + 20))
	{
	    enemyHit = true;
	}
	else
	{
	    enemyHit = false;
	}
    }

    public int getEnemyX ()
    {
	return x;
    }


    public int getEnemyY ()
    {
	return y;
    }
} // Enemy class


