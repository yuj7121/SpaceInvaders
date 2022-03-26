/*
Name Yujin Bae
teacher: Mr. Guglielmi
Date:L november, 13, 2020
description: This is the clock class of the final project space invaders game.
this class will draw the little clock at the top of the screen.
The clock will keep record of the playtime
*/

// The "Clock" class.
import java.awt.*;
import hsa.Console;

public class Clock extends Thread
{
    private Console c;              // The output console
    private int[] t = new int [2];  //the time, formatted minute, second, millisecond
    private boolean go = true;      //whther the clock should continue or not

    public Clock (Console c, int[] t)
    {
	this.c = c;
	this.t = t;
    }


    private void drawClock ()
    {
	while (go)
	{
	    c.setCursor (1, 12);
	    c.print("Time: ");
	    c.print (t [0]);
	    c.print (" : ");
	    c.print (t [1]);
	    c.print (" : ");
	    c.print (t [2]);
	    t [2]++;
	    //if millisecond reaches 100
	    if (t [2] == 100)
	    {
		t [2] = 0;      //set millisecond back to 0
		t [1]++;        //add 1 to second
	    }
	    //if second reaches 60
	    if (t [1] == 60)
	    {
		t [1] = 0;      //set second back to 0
		t [0]++;        //add 1 to minute
	    }

	    try
	    {
		sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }
    
    //this method will return the current time
    public int[] getTime(){
	return t;
    }

    //this method will end the clock
    public void end ()
    {
	go = false;
    }


    //this method will run teh clock
    public void run ()
    {
	drawClock ();
    }
} // Clock class


