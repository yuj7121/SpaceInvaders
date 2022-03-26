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
import java.io.*;
import javax.swing.*;

public class GameScreen
{

    //variable declaration
    private Console c;                  // The output console
    private int score = 0;              //this varibale holds the score of the game.
    private int[] t = {0, 0, 0};        //the current play time
    private int startLevel = 1;             //the starting level
    private int currentLevel = 1;           //the current level
    private Enemy[] enemies;            //an array of enemies declared
    private boolean levelEnd = false;   //this boolean holds wether the level is finished or not
    private String[] [] scoreboard = new String [10] [7];

    //this is the constructor the method.
    public GameScreen (Console c)
    {
	this.c = c;
	mainMenu ();
    }


    //this method draws the main menu of the game. It asks for input and ets the user play
    private void mainMenu ()
    {
	splashScreen ();
	while (true)
	{
	    drawTitle ();
	    //the options
	    c.setColor (Color.white);
	    c.setFont (new Font ("Agency FB", Font.PLAIN, 30));
	    c.drawString ("SEE INSTRUCTIONS - PRESS 'A'", 40, 220);
	    c.drawString ("SEE HIGH SCORES - PRESS 'S'", 40, 260);
	    c.drawString ("PLAY GAME - PRESS 'SPACE'", 40, 300);
	    c.drawString ("EXIT GAME - PRESS 'D'", 40, 340);
	    char ch = c.getChar ();

	    if (ch == 'a' || ch == 'A')
	    {
		instructions ();
	    }
	    else if (ch == 's' || ch == 'S')
	    {
		seeHighScore ();
	    }
	    else if (ch == 'd' || ch == 'D')
	    {
		goodbye ();
	    }
	    else if (ch == ' ')
	    {
		do
		{

		    //prompts the user for a level
		    c.setCursor (22, 1);
		    c.println ("TYPE IN THE LEVEL YOU WOULD LIKE TO PLAY THE GAME FROM 1 TO 10");
		    String str = c.readLine ();
		    //tries to coverts the input to an integer
		    try
		    {
			startLevel = Integer.parseInt (str);
		    }
		    catch (NumberFormatException e)
		    {
			//erase the bad input
			c.setCursor (22, 1);
			c.println ();
			c.println ();
			//if the input is wrong startlevel is set to 0 so that the while loop continues
			startLevel = 0;
		    }
		}
		while (startLevel == 0);
		//sets the current level to the user's input
		currentLevel = startLevel;
		//lets the user play!
		play ();
	    }
	}
    }


    //this method will display out how to play space invaders
    private void instructions ()
    {
	c.clear ();
	c.print (' ', 25);
	c.println ("INSTRUCTIONS");
	c.println ();
	c.println ("SPACES INVADERS IS A GAME WHERE YOU FIGHT THE ALIENS THAT ARE  TRYING TO INVADE THE EARTH. ");
	c.println ();
	c.println ("YOU CAN USE 'A' AND 'D' TO MOVE LEFT AND RIGHT ON THE HORIZON. ");
	c.println ();
	c.println ("YOU CAN PRESS 'SPACE' TO FIRE A MISSILE. ");
	c.println ();
	c.println ("IF YOU GET HIT BY AN ENEMY BOMB OR LET THE ENMIES DESCEND BELOW THE HORIZON, YOU LOSE. ");
	c.println ();
	c.println ("IF YOU CLEAR ALL THE ENEMIES, THE GAME PROCEEDS TO THE NEXT LEVEL. ");
	c.println ();
	c.println ("...GOOD LUCK!");
	c.println ();
	c.println ();
	c.println ();
	c.println ();
	c.println ();
	c.println ();
	c.println ("PRESS ANY KEY TO GO BACK TO THE MAIN MENU. ");
	c.getChar ();
    }


    //this emthod will display the goodbye message to the user
    private void goodbye ()
    {
	JOptionPane.showMessageDialog (null, "THANK YOU FOR USING MY PROGRAM \n                     GOODBYE!");
	System.exit (0);
    }


    //this method will load up the loading screen
    private void splashScreen ()
    {
	//draws the black background
	c.setColor (Color.black);
	c.fillRect (0, 0, 500, 500);
	c.setColor (Color.white);
	c.drawRoundRect (20, 440, 460, 30, 10, 10);
	for (int i = 0 ; i < 1000 ; i++)
	{
	    drawHugeEnemy ();
	    c.setFont (new Font ("Agency FB", Font.BOLD, 50));
	    c.drawString ("L  O  A  D  I  N  G  .  .  .  .  .", 40, 420);
	    c.fillRoundRect (25, 445, (int) (i * 0.45), 20, 5, 5);
	}
    }


    //this method will draw the title of the spcae invaders
    private void drawTitle ()
    {
	//draws the black background
	c.setColor (Color.black);
	c.fillRect (0, 0, 500, 500);

	//the red drop shadow behind
	c.setColor (Color.red);
	c.setFont (new Font ("Agency FB", Font.BOLD, 75));
	c.drawString ("S P A C E", 117, 75);
	c.drawString ("I N V A D E R S", 61, 155);
	//the second row of red letters
	c.setFont (new Font ("Agency FB", Font.BOLD, 76));
	c.drawString ("S P A C E", 116, 80);
	c.drawString ("I N V A D E R S", 58, 160);
	//the third row of red letters
	c.setFont (new Font ("Agency FB", Font.BOLD, 77));
	c.drawString ("S P A C E", 115, 85);
	c.drawString ("I N V A D E R S", 57, 165);

	//the yellow title
	c.setColor (Color.yellow);
	c.setFont (new Font ("Agency FB", Font.BOLD, 80));
	c.drawString ("S P A C E", 110, 90);
	c.drawString ("I N V A D E R S", 50, 170);
    }


    //this method will allow the user to play the game.
    private void play ()
    {
	int rank;   //the rank of the player among the high scores.
	level ();
	gameOver ();
	rank = checkHighScore ();
	if (rank <= 10)
	{
	    writeHighScore (rank);
	}
    }


    //this method will draw all the enemies and the player, and let the user play a level.
    private void level ()
    {
	boolean gameOver = false;

	while (!gameOver)
	{
	    //draws the black background
	    c.setColor (Color.black);
	    c.fillRect (0, 0, 500, 500);
	    c.setCursor (1, 1);
	    c.print ("Level " + currentLevel + "            ");

	    //creates a new clock object
	    Clock cl = new Clock (c, t);
	    cl.start ();

	    //creates a new player object and start its thread
	    Player p = new Player (c);
	    p.start ();

	    //creates a new animate enemeis object and starts its thread
	    AnimateEnemies e = new AnimateEnemies (c, currentLevel, p);
	    e.setScore (score);
	    e.start ();

	    boolean levelEnd = false;       //so the loop runs
	    while (!levelEnd)
	    {
		score = e.getScore ();
		//if block for checking if the player has been hit
		if (p.getPlayerHit () || e.hitBottom ())
		{
		    cl.end ();
		    p.end ();
		    e.end ();
		    levelEnd = true;
		    gameOver = true;
		}
		//if loop checking if the player has cleared the level
		if (e.getEnemiesLeft () == 0)
		{
		    cl.end ();
		    p.end ();
		    e.end ();
		    levelEnd = true;

		    //if the user cleared all levels
		    if (currentLevel == 10)
		    {
			for (int i = 50 ; i > 0 ; i--)
			{
			    //draws the black background
			    c.setColor (Color.black);
			    c.fillRect (0, 0, 500, 500);
			    drawHugeEnemy ();
			    c.setFont (new Font ("Agency FB", Font.BOLD, 40));
			    c.drawString ("CONGRATULATIONS!", 120, 400);
			    c.drawString ("YOU HAVE CLEARED THE GAME", 40, 440);
			    c.drawString ("PRESS ENTER TO CONTINUE", 60, 480);
			}
			c.readLine ();
			gameOver = true;
		    }
		    else
		    {
			//the level change screen
			//for loop because it takes time for all the enemies and bo,bs to stop getting drawn.
			for (int i = 50 ; i > 0 ; i--)
			{
			    //draws the black background
			    c.setColor (Color.black);
			    c.fillRect (0, 0, 500, 500);
			    drawHugeEnemy ();
			    c.setColor (Color.white);
			    c.setFont (new Font ("Agency FB", Font.BOLD, 100));
			    c.drawString ("L E V E L  " + (currentLevel + 1), 60, 460);
			}
			try
			{
			    Thread.sleep (3000);
			}
			catch (Exception ex)
			{
			}
			currentLevel++;
		    } //if else user cleared ALL levels block's end
		} //if user cleared a level block end
	    } //while !levelEnd loop end
	} //while !gameOver loop end
    } //end of the method


    //this method draws the huge enemy!
    private void drawHugeEnemy ()
    {
	//draws the a huge drawing of the alien
	c.setColor (Color.white);
	c.fillRect (110, 30, 40, 40); //top left ear
	c.fillRect (350, 30, 40, 40); //top rght ear
	c.fillRect (150, 70, 40, 40); //low left ear
	c.fillRect (310, 70, 40, 40); //low right ear
	c.fillRect (110, 110, 280, 40); //forehead
	c.fillRect (70, 150, 80, 40);  //left side of head
	c.fillRect (190, 150, 120, 40); //between eys
	c.fillRect (350, 150, 80, 40);  //right side of eye
	c.fillRect (30, 190, 440, 40);  //middile of the face
	c.fillRect (110, 230, 280, 40); //bottom of face
	c.fillRect (30, 230, 40, 80);   //left arm
	c.fillRect (430, 230, 40, 80);  //right arm
	c.fillRect (110, 270, 40, 40);  //left top jaw
	c.fillRect (350, 270, 40, 40);  //right top jaw
	c.fillRect (150, 310, 80, 40);  //left bottom jaw
	c.fillRect (270, 310, 80, 40);  //right bottom jaw
    }


    //this method will display the gameover screen
    private void gameOver ()
    {
	for (int i = 50 ; i > 0 ; i--) //while all the enemies and the missiles take their time to stop moving
	{ //draws the black background
	    c.setColor (Color.black);
	    c.fillRect (0, 20, 500, 480);
	    drawHugeEnemy ();
	    //game over message
	    c.setFont (new Font ("Agency FB", Font.BOLD, 80));
	    c.drawString ("G A M E   O V E R", 30, 440);
	    c.setFont (new Font ("Agency FB", Font.PLAIN, 30));
	    c.drawString ("P R E S S   E N T E R   T O   C O N T I N U E", 60, 480);
	}
	c.readLine ();
    }



    private int checkHighScore ()
    {
	int rank = 11;
	try
	{
	    BufferedReader b = new BufferedReader (new FileReader ("HighScore.txt"));
	    if (b.readLine ().equals ("Name - score - minute - second - millisecond - start level - end level"))
	    {
		b.readLine ();

		for (int i = 1 ; i <= 10 ; i++)
		{
		    scoreboard [i - 1] [0] = b.readLine ();
		    scoreboard [i - 1] [1] = b.readLine ();
		    scoreboard [i - 1] [1] = scoreboard [i - 1] [1].substring (0, scoreboard [i - 1] [1].length ());
		    try
		    {
			if (rank == 11 && score >= Integer.parseInt (scoreboard [i - 1] [1]))
			{
			    rank = i;
			}
		    } //try block end
		    catch (NumberFormatException e)
		    {
		    } //catch block end
		    scoreboard [i - 1] [2] = b.readLine ();
		    scoreboard [i - 1] [3] = b.readLine ();
		    scoreboard [i - 1] [4] = b.readLine ();
		    scoreboard [i - 1] [5] = b.readLine ();
		    scoreboard [i - 1] [6] = b.readLine ();
		} //for loop end

	    } //if block end
	} //try block end
	catch (Exception e)
	{
	    JOptionPane.showMessageDialog (null, "Something is wrong with the highscore file");
	} //catch block end
	return rank;
    } //method end


    //this method will ask the high scoring user for their name and write to the high core file
    private void writeHighScore (int rank)
    {
	//try catch block for printwriters
	try
	{
	    c.fillRect (0, 0, 500, 500);
	    c.setCursor (1, 1);
	    c.println ("Congratulations! You have reached a high score!");
	    c.println ("You are in the " + rank + "th spot with the score of " + score);
	    c.println ("Please Type in Your Name. ");

	    //deletes anything written previously.
	    PrintWriter f = new PrintWriter (new FileWriter ("HighScore.txt"));
	    f.close ();

	    //a new printwriter that will actually write down the high scores
	    f = new PrintWriter (new FileWriter ("HighScore.txt"));

	    //moving the other scores behind the current user's score back by one
	    for (int i = 9 ; i >= rank ; i--)
	    {
		for (int l = 0 ; l < 7 ; l++)
		{
		    scoreboard [i] [l] = scoreboard [i - 1] [l];
		}
	    }

	    scoreboard [rank - 1] [0] = c.readLine ();
	    scoreboard [rank - 1] [1] = Integer.toString (score);
	    scoreboard [rank - 1] [2] = String.valueOf (t [0]);
	    scoreboard [rank - 1] [3] = String.valueOf (t [1]);
	    scoreboard [rank - 1] [4] = String.valueOf (t [2]);
	    scoreboard [rank - 1] [5] = String.valueOf (startLevel);
	    scoreboard [rank - 1] [6] = String.valueOf (currentLevel);


	    f.println ("Name - score - minute - second - millisecond - start level - end level");
	    f.println ();

	    for (int i = 0 ; i < 10 ; i++)
	    {
		for (int l = 0 ; l < 7 ; l++)
		{
		    f.println (scoreboard [i] [l]);
		}
	    }
	    f.close ();
	}
	catch (IOException e)
	{
	}
    }


    //this method will load the high scores fromt the file and display it on screen
    private void seeHighScore ()
    {
	c.clear ();
	try
	{
	    BufferedReader b = new BufferedReader (new FileReader ("HighScore.txt"));
	    b.readLine ();
	    b.readLine ();
	    c.print (' ', 23);
	    c.println ("S C O R E B O A R D");
	    c.println ();

	    c.println ("NAME                       SCORE       TIME     BEG LEV END LEV");
	    for (int i = 0 ; i < 10 ; i++)
	    {
		for (int l = 0 ; l < 7 ; l++)
		{
		    scoreboard [i] [l] = b.readLine ();
		}
		c.print (scoreboard [i] [0], 27);
		c.print (scoreboard [i] [1], 10);
		c.print (scoreboard [i] [2], 2);
		c.print (":" + scoreboard [i] [3], 3);
		c.print (":" + scoreboard [i] [4], 9);
		c.print (scoreboard [i] [5], 8);
		c.println (scoreboard [i] [6]);
	    }
	    c.println ();
	    c.println ("PRESS ANY KEY TO GO BACK TO THE MAIN MENU");
	    c.getChar ();
	}
	catch (Exception e)
	{
	    JOptionPane.showMessageDialog (null, "Something is wrong with the highscore file");
	}
    }
} // GameScreen class


