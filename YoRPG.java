/*
Team Club Pengueen -- Janet Zhang, Kevin Hwang, Dorothy Ng
APCS1 pd5
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Monster smaug; //Friendly generic monster name, eh?
    private Character chara;

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

	String s;
	String name = "";
    int charaN;
	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }


	s = "Intrepid player, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	s = "\nChoose your class: \n\n";
	s += "\t1: Warrior\n" + "[The Warrior is primarily a defender. His main job is the take the brunt of attacks for his teammates. Because of this, the Warrior has higher HP and defense than other classes do.]"+"\n\n";
	s += "\t2: Mage\n" + "[The Mage specializes in the magic granted by mysterious spirits. Despite having low strength and defense, with help from the mysterious spirits, he is a force to be reckoned with.]"+"\n\n";
	s += "\t3: Rogue\n" + "[The Rogue is a nimble attacker. His attacks are on point, just like his choice of weapon, daggers. However, while he has high strength, he also has low HP and low defense. Getting hit will definitely hurt a lot.]"+"\n\n";
	s += "\t4: Ducky\n" + "[The Ducky is the defender of the World and the only one who has a 99.7% chance of defeating the Boss. While his strength and HP is abysmal, he has incredibly high defense, likened to a solid firewall.]"+"\n\n";
	s += "\t5: Boss\n" + "[The Boss is the master of all trades. His stats are all ridiculously high. Some say he's invincible. Recently, there has been a rumor that a single hero might have a chance at defeating him...]"+"\n\n";
	s += "Selection: ";
	System.out.print( s );
	
	try {
	    charaN = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { charaN = 0; }

	//instantiate the player's character
		//pat = new Character( name );
	if (charaN==1) { chara = new Warrior(name);}
	else if (charaN==2) { chara = new Mage(name);}
    else if (charaN==3) { chara = new Rogue(name);}
    else if (charaN==4) { chara = new Ducky(name);}
    else if (charaN==5) { chara = new Boss(name);}
    else { chara = new Warrior(name);}

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "Nothing to see here. Move along!" );

	else {
	    System.out.println( "Lo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && chara.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "Do you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( Exception e ) {i = 1;}

		if ( i == 2 )
		    chara.specialize();
		else
		    chara.normalize();

		d1 = chara.attack( smaug );
		d2 = smaug.attack( chara );

		System.out.println( chara.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "Ye Olde Monster hit back for " + d2 +
				    " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !chara.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !chara.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	/*=============================================

	  =============================================*/

    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
