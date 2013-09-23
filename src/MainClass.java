// The "MainClass" class.
/*
 * 
__________                   .___                   
\______   \_______  ____   __| _/_ __   ____  ____  
 |     ___/\_  __ \/  _ \ / __ |  |  \_/ ___\/ __ \ 
 |    |     |  | \(  <_> ) /_/ |  |  /\  \__\  ___/ 
 |____|     |__|   \____/\____ |____/  \___  >___  >
                              \/           \/    \/ 
   _____                                             
  /     \ _____    ____ _____     ____   ___________ 
 /  \ /  \\__  \  /    \\__  \   / ___\_/ __ \_  __ \
/    Y    \/ __ \|   |  \/ __ \_/ /_/  >  ___/|  | \/
\____|__  (____  /___|  (____  /\___  / \___  >__|   
        \/     \/     \/     \//_____/      \/       

Saad Asif and Shahzaib Bhatti
December 2010 -- January 2011
Produce Manager
A game based around getting points by slashing fruit.
Produce Manager is a game based on the famous iPhone based game fruit ninja.
The aim of the game is to get as many points as possible by slashing fruit.
Along with slashing fruit, one has to avoid letting three fruit drop,
or slashing a bad apple which both end the game.
They can also get more point by slicing fruit fast,
which will get them combo points. Outside of combos,
for every one fruit sliced, one point is gained.
And based upon your combo you can get up to 1, 2 or 3 addition points
for a combo of 3, 4 and 5 respectively. Along with the game,
the player has the option the pick between a red green or white blade color.
They can also pick a background and a song to play the game to.
The game has file IO for saving scores, background,
the selected blade and selected music. As well as options,
our game has a small database with one funny comic each for the fruit/veggies.

Note: Install font

 */

import java.applet.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.io.*;

import java.net.*;

public class MainClass extends Applet implements MouseListener, Runnable,MouseMotionListener, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1537070253354648495L;
	Thread t = new Thread(this);

	private Image dbImage;
	private Graphics dbg;


	// The applet base URL 
	URL base; 


	//Constant variables
	final int MAIN_MENU=3;
	final int CLASSIC_MODE=0;
	final int GAME_OVER=4;
	final int DATABASE=2;
	final int OPTIONS=1;
	final int INSTRUCTIONS=5;
	final int NUMBER_OF_SQUISH=3;
	final int MAX_VERTICAL=10;
	final int MIN_VERTICAL=25;
	final int MAX_HORIZONTAL=20;
	final int MIN_HORIZONTAL=-10;
	final int MAX_X=300;
	final int MIN_X=300;
	final int Y=600;
	final int COMBO_COUNTER_MAX=5;
	final int NUMBER_OF_LIVES=3;
	final int MIN_SEED_COUNT=5;
	final int MAX_SEED_COUNT=15;
	final int NUMBER_OF_TEXT=10;
	final int OPTION_TOP=0;
	final int OPTION_BOTTOM=1;
	final int MAIN_MENU_TOP=2;
	final int GAME_CIRCLE=3;
	final int OPTION_CIRCLE=4;
	final int DATABASE_CIRCLE=5;
	final int GAME_OVER_SCREEN=6;
	final int COUNTER3=7;
	final int COUNTER2=8;
	final int COUNTER1=9;
	final int NUMBER_OF_BUTTONS=16;
	final int DONE=0;
	final int WHITEBLADE=1;
	final int REDBLADE=2;
	final int GREENBLADE=3;
	final int SONG1=4;
	final int SONG2=5;
	final int SONG3=6;
	final int SONG4=7;
	final int SONG0=8;
	final int BACKGROUND1=9;
	final int BACKGROUND2=10;
	final int BACKGROUND3=11;
	final int BACKGROUND0=12;
	final int INSTRUCTION_BUTTON=13;
	final int PAUSE=14;
	final int EXIT=15;
	final int ORIGIN_Y=0;
	final int ORIGIN_X=0;
	final int SINGLE_INCREASE=1;
	final int NO_MOVEMENT=0;
	final int ROTATION_MAX=120;
	final int GAME_CIRCLE_Y_POS=150;
	final int DATABASE_CIRCLE_Y_POS=150;
	final int OPTION_CIRCLE_Y_POS=300;
	final int MAIN_MENU_FRUIT_CIRCLE_POS=100;
	final int PAUSE_LENGTH=125;
	final int MENU_APPLE=0;
	final int MENU_COCONUT=1;
	final int MENU_MUSHROOM=2;
	final int MIN_COUNTER=0;
	final int OFF_SCREEN=600;
	final int SINGLE_COMBO=3;
	final int SINGLE_COMBO_BONUS=1;
	final int DOUBLE_COMBO=4;
	final int DOUBLE_COMBO_BONUS=2;
	final int TRIPLE_COMBO=5;
	final int TRIPLE_COMBO_BONUS=3;
	final int NUMBER_OF_ADDITION_SPLASHES=2;
	final int STARTING_NUMBER_OF_FRUIT=1;
	final int GAME_CIRCLE_X_POS=30;
	final int OPTION_CIRCLE_X_POS=330;
	final int DATABASE_CIRCLE_X_POS=630;
	final int CLICK_CLOCK_WOOD=0;
	final int JINJO_VILLAGE=1;
	final int CAN_CAN=2;
	final int LOVE_IS_IN_THE_AIR=3;
	final int THEME_SONG_YELLOW=4;
	final int DONE_BUTTON_HEIGHT =44;
	final int DONE_BUTTON_WIDTH =143;
	final int DONE_BUTTON_X=740;
	final int DONE_BUTTON_Y=580;
	final int EXIT_BUTTON_HEIGHT=44;
	final int EXIT_BUTTON_WIDTH=143;
	final int EXIT_BUTTON_X=740;
	final int EXIT_BUTTON_Y=580;
	final int INSTRUCTIONS_BUTTON_X=0;
	final int INSTRUCTION_BUTTON_Y=580;
	final int INSTRUCTION_BUTTON_WIDTH=400;
	final int INSTRUCTION_BUTTON_HEIGHT=44;
	final int WHITE_BLADE_BUTTON_X=100;
	final int WHITE_BLADE_BUTTON_Y=200;
	final int WHITE_BLADE_BUTTON_WIDTH=200;
	final int WHITE_BLADE_BUTTON_HEIGHT=44;
	final int RED_BLADE_BUTTON_X=97;
	final int RED_BLADE_BUTTON_Y=270;
	final int RED_BLADE_BUTTON_WIDTH=143;
	final int RED_BLADE_BUTTON_HEIGHT=44;
	final int GREEN_BLADE_BUTTON_X=118;
	final int GREEN_BLADE_BUTTON_Y=340;
	final int GREEN_BLADE_BUTTON_WIDTH=170;
	final int GREEN_BLADE_BUTTON_HEIGHT=44;
	final int SONG1_BUTTON_X=100;
	final int SONG1_BUTTON_Y=500;
	final int SONG1_BUTTON_WIDTH=205;
	final int SONG1_BUTTON_HEIGHT=31;
	final int SONG2_BUTTON_X=100;
	final int SONG2_BUTTON_Y=550;
	final int SONG2_BUTTON_WIDTH=142;
	final int SONG2_BUTTON_HEIGHT=31;
	final int SONG3_BUTTON_X=300;
	final int SONG3_BUTTON_Y=500;
	final int SONG3_BUTTON_WIDTH=250;
	final int SONG3_BUTTON_HEIGHT=31;
	final int SONG4_BUTTON_X=300;
	final int SONG4_BUTTON_Y=550;
	final int SONG4_BUTTON_WIDTH=300;
	final int SONG4_BUTTON_HEIGHT=31;
	final int SONG0_BUTTON_X=550;
	final int SONG0_BUTTON_Y=500;
	final int SONG0_BUTTON_WIDTH=275;
	final int SONG0_BUTTON_HEIGHT=31;
	final int BACKGROUND1_BUTTON_X=600;
	final int BACKGROUND1_BUTTON_Y=200;
	final int BACKGROUND2_BUTTON_X=600;
	final int BACKGROUND2_BUTTON_Y=350;
	final int BACKGROUND3_BUTTON_X=800;
	final int BACKGROUND3_BUTTON_Y=200;
	final int BACKGROUND0_BUTTON_X=800;
	final int BACKGROUND0_BUTTON_Y=350;
	final int BACKGROUND_BUTTON_DIMENSIONS=100;
	final int PAUSE_BUTTON_X=0;
	final int PAUSE_BUTTON_Y=0;
	final int PAUSE_BUTTON_DIMENSIONS=50;
	final int WHITE_BLADE_VALUE=0;
	final int RED_BLADE_VALUE=1;
	final int GREEN_BLADE_VALUE=2;
	final int BACKGROUND1_VALUE=1;
	final int BACKGROUND2_VALUE=2;
	final int BACKGROUND3_VALUE=3;
	final int BACKGROUND0_VALUE=0;
	final int SPACE_BETWEEN_RED_Xs=50;
	final int RED_X_Y_POSITION=480;
	final int DATABASE_SCROLLER_MAX_Y=100;
	final int DATABASE_SCROLLER_MIN_Y=-2050;
	final int DATABASE_SCROLLER_MAX_X=200;
	final int DATABASE_NAME_SPACEING=50;
	final int DATABASE_NAME_SPACING_MID_VALUE=25;
	final int APPLE_WIDTH=69;
	final int APPLE_HEIGHT=84;
	final int COCONUT_WIDTH=81;
	final int COCONUT_HEIGHT=91;
	final int MUSHROOM_WIDTH=80;
	final int MUSHROOM_HEIGHT=76;
	final int FONT_SIZE=48;
	final String SAVE_FILE="scores.txt";
	final int DATABASE_SCROLLER_X=0;
	final int GAME_SPEED=40;
	final int BAD_APPLE=0;
	final int GRAPES=1;
	final int LEMON=2;
	final int LIME=3;
	final int MELON=4;
	final int PEAR=5;
	final int PINEAPPLE=6;
	final int STRAWBERRY=7;
	final int BANANA=8;
	final int BLUEBERRY=9;
	final int CHERRY=10;
	final int GOOSEBERRY=11;
	final int KIWI_FRUIT=12;
	final int ORANGE=13;
	final int PEACH=14;
	final int SATSUMA=15;
	final int APPLE=16;
	final int POMEGRANATE=17;
	final int PAPAYA=18;
	final int OLIVE=19;
	final int RASPBERRY=20;
	final int MANGO=21;
	final int COCONUT=22;
	final int STARFRUIT=23;
	final int AVOCADO=24;
	final int MANDARIN=25;
	final int PASSION_FRUIT=26;
	final int APRICOT=27;
	final int MANGOSTEEN=28;
	final int DRAGON_FRUIT=29;
	final int PLUM=30;
	final int ELDERBERRY=31;
	final int ONION=32;
	final int MUSHROOM=33;
	final int TOMATO=34;
	final int CORN=35;
	final int BROCCOLI=36;
	final int CHICKPEA=37;
	final int PUMPKIN=38;
	final int PEA=39;
	final int CARROT=40;
	final int BEAN=41;
	final int POTATO=42;
	final int BRUSSELS_SPROUTS=43;
	final int NUMBER_OF_FRUIT=44;
	final int SCREEN_HEIGHT=640;
	final int SCREEN_WIDTH=960;
	final int NUMBER_OF_BACKGROUNDS=4;
	final int NUMBER_OF_SONGS=5;
	final int NUMBER_OF_MENU_OPTIONS=3;
	final int MAX_NUMBER_OF_FRUIT_ON_SCREEN=3;
	final int NUMBER_OF_HEY=5;
	final int MAX_SEED_HOR=20;
	final int MAX_SEED_VER=20;
	final int MIN_SEED_HOR=-10;
	final int MENU_APPLE_X=125;
	final int MENU_COCONUT_X=425;
	final int MENU_MUSHROOM_X=730;
	final int COUNT_DOWN_DURATION=25;
	final int SCORE_X=10;
	final int SCORE_Y=625;
	final int COMBO_X=10;
	final int COMBO_Y=575;
	final int DATABASE_NAME_SPACING=50;
	final int DATABASE_FRUIT_X=550;
	final int DATABASE_FRUIT_Y=20;
	final int DATABASE_COMIC_X=350;
	final int DATABASE_COMIC_Y=200;
	final int DATABASE_START_SKIP=2;
	final int END_GAME_SCORE_DISPLAY_X=360;
	final int END_GAME_SCORE_DISPLAY_Y=310;
	final int END_GAME_HIGH_SCORE_X=50;
	final int END_GAME_CURRENT_COMBO_X=360;
	final int END_GAME_CURRENT_COMBO_Y=375;
	final int END_GAME_HIGH_COMBO_X=550;
	final int END_GAME_HIGH_COMBO_Y=500;
	final int END_GAME_FIRST_SCORE_Y=500;
	final int END_GAME_SECOND_SCORE_Y=550;
	final int END_GAME_THIRD_SCORE_Y=600;
	final int COMBO_COUNTER_MIN=1;
	final int NUMBER_OF_SOUND_EFFECTS=13;
	final int CLASSIC_MODE_SF=0;
	final int TEAM_BATTLE_SF=1;
	final int SPECTATE_SF=2;
	final int THREE_SF=3;
	final int TWO_SF=4;
	final int ONE_SF=5;
	final int READY_SF=6;
	final int GO_SF=7;
	final int GAME_SF=8;
	final int NEW_RECORD_SF=9;
	final int TRAINING_SF=10;
	final int ROTATION_SF=11;
	final int CLICK_SF=12;




	//Arrays holding different types of objects/variables for game use
	Image background[] = new Image [NUMBER_OF_BACKGROUNDS];
	AudioClip[] song = new AudioClip [NUMBER_OF_SONGS];
	Fruit [] menuFruit = new Fruit [NUMBER_OF_MENU_OPTIONS];
	Image[] comicPicture = new Image [NUMBER_OF_FRUIT];
	Fruit [] defaultFruit = new Fruit [NUMBER_OF_FRUIT];
	Fruit [] shownFruit = new Fruit [MAX_NUMBER_OF_FRUIT_ON_SCREEN];
	AudioClip[] hey = new AudioClip [NUMBER_OF_HEY];
	optionPicture [] displayedText = new optionPicture [NUMBER_OF_TEXT];
	AudioClip[] squish = new AudioClip [NUMBER_OF_SQUISH];
	clickablePicture [] displayedButton = new clickablePicture [NUMBER_OF_BUTTONS];
	AudioClip[] soundEffects = new AudioClip [NUMBER_OF_SOUND_EFFECTS];

	//Array lists for seeds, splashes and blades
	ArrayList<Particle> seed = new ArrayList<Particle>();
	ArrayList<Splash> splash = new ArrayList<Splash>();
	ArrayList<Blade> blade =  new ArrayList<Blade>();

	//An instance of the score class to store all saved information
	Scores gameScores = new Scores();
	//A random generator to get random values
	Random generator = new Random ();

	//Individual images used in the game
	Image seedPicture;
	Image xImage;
	Image instructionScreen;
	Image databaseScroll;
	Image databaseOverlay;

	//Other non constant variables used in the game to keep track of information
	int comboCounter;
	int comboScore;
	int highestComboScore;
	int countDownCounter;
	int fallCount;
	int currentEvent;
	int numberOfFruitOnScreen;
	int fruitToAdd;
	int fruitX;
	int fruitY;
	int fruitHor;
	int fruitVer;
	int currentSquish;
	int currentHey;
	int seedHor;
	int seedVer;
	int xPosition;
	int yPosition;
	int seedCount;
	int score;
	int multiplier;
	int databaseScrollerY;
	boolean meneFruitSlashable;
	boolean countDownScreen;

	//Font used in the game
	Font gameFont = new Font("VAL", Font.PLAIN, FONT_SIZE);

	/////////////////////////////////////////////////////////////////////////////////
	public void run()
	{
		while (true)
		{

			//Resets multiplier so will not make the integer too long
			if (multiplier ==ROTATION_MAX){
				multiplier = NO_MOVEMENT;
			}
			//Increase multiplier constantly to rotate menu images
			multiplier ++;

			//Things to happen when the user is running the main menu
			if (currentEvent==MAIN_MENU)
			{//Moves the menu top down on screen when its the main menu screen
				if (displayedText [MAIN_MENU_TOP].getyPosition() < ORIGIN_Y)
				{
					displayedText [MAIN_MENU_TOP].setMovement(displayedText [MAIN_MENU_TOP].getMovement()+SINGLE_INCREASE);
					displayedText [MAIN_MENU_TOP].setyPosition(displayedText [MAIN_MENU_TOP].getyPosition()+displayedText [MAIN_MENU_TOP].getMovement());
					if (displayedText [MAIN_MENU_TOP].getyPosition() >= ORIGIN_Y)
					{//Stops the movement when screen in position
						displayedText [MAIN_MENU_TOP].setyPosition(NO_MOVEMENT);
						displayedText [MAIN_MENU_TOP].setMovement(NO_MOVEMENT);
						meneFruitSlashable=true; //Allows for the fruit on the menu to be slashes
						//Allows user to press the exit and instruction button
						displayedButton[INSTRUCTION_BUTTON].setClickable(true);
						displayedButton[EXIT].setClickable(true);
					}
				}
				//Moves the game circle in position when main menu
				if (displayedText [GAME_CIRCLE].getyPosition() > ORIGIN_Y)
				{
					displayedText [GAME_CIRCLE].setMovement(displayedText [GAME_CIRCLE].getMovement()-SINGLE_INCREASE);
					displayedText [GAME_CIRCLE].setyPosition(displayedText [GAME_CIRCLE].getyPosition()+displayedText [GAME_CIRCLE].getMovement());
					if (displayedText [GAME_CIRCLE].getyPosition() <= GAME_CIRCLE_Y_POS)
					{//Stops movement when circle in place
						displayedText [GAME_CIRCLE].setyPosition(GAME_CIRCLE_Y_POS);
						displayedText [GAME_CIRCLE].setMovement(NO_MOVEMENT);
					}
					//Sets the apples position in place using the circle as reference
					menuFruit[MENU_APPLE].setyPosition(displayedText[GAME_CIRCLE].getyPosition()+MAIN_MENU_FRUIT_CIRCLE_POS);
				}
				//Moves the option circle in position when main menu
				if (displayedText [OPTION_CIRCLE].getyPosition() > ORIGIN_Y)
				{
					displayedText [OPTION_CIRCLE].setMovement(displayedText [OPTION_CIRCLE].getMovement()-SINGLE_INCREASE);
					displayedText [OPTION_CIRCLE].setyPosition(displayedText [OPTION_CIRCLE].getyPosition()+displayedText [OPTION_CIRCLE].getMovement());
					if (displayedText [OPTION_CIRCLE].getyPosition() <= OPTION_CIRCLE_Y_POS)
					{//Stops movement when circle in place
						displayedText [OPTION_CIRCLE].setyPosition(OPTION_CIRCLE_Y_POS);
						displayedText [OPTION_CIRCLE].setMovement(NO_MOVEMENT);
					}
					//Sets the coconuts position in place using the circle as reference
					menuFruit[MENU_COCONUT].setyPosition(displayedText[OPTION_CIRCLE].getyPosition()+MAIN_MENU_FRUIT_CIRCLE_POS);
				}
				//Moves the database circle in position when main menu
				if (displayedText [DATABASE_CIRCLE].getyPosition() > ORIGIN_Y)
				{
					displayedText [DATABASE_CIRCLE].setMovement(displayedText [DATABASE_CIRCLE].getMovement()-SINGLE_INCREASE);
					displayedText [DATABASE_CIRCLE].setyPosition(displayedText [DATABASE_CIRCLE].getyPosition()+displayedText [DATABASE_CIRCLE].getMovement());
					if (displayedText [DATABASE_CIRCLE].getyPosition() <= DATABASE_CIRCLE_Y_POS)
					{//Stops movement when circle in place
						displayedText [DATABASE_CIRCLE].setyPosition(DATABASE_CIRCLE_Y_POS);
						displayedText [DATABASE_CIRCLE].setMovement(NO_MOVEMENT);
					}
					//Sets the mushroom position in place using circle as reference
					menuFruit[MENU_MUSHROOM].setyPosition(displayedText[DATABASE_CIRCLE].getyPosition()+MAIN_MENU_FRUIT_CIRCLE_POS);
				}

			}
			else
			{
				//Turns off buttons from screen
				displayedButton[INSTRUCTION_BUTTON].setClickable(false);//if not options, remove done button
				displayedButton[EXIT].setClickable(false);
				//Moves top menu off the screen
				if (displayedText [MAIN_MENU_TOP].getyPosition() > -SCREEN_HEIGHT)
				{
					displayedText [MAIN_MENU_TOP].setMovement(displayedText [MAIN_MENU_TOP].getMovement()-SINGLE_INCREASE);
					displayedText [MAIN_MENU_TOP].setyPosition(displayedText [MAIN_MENU_TOP].getyPosition()+displayedText [MAIN_MENU_TOP].getMovement());
					if (displayedText [MAIN_MENU_TOP].getyPosition() <-SCREEN_HEIGHT)
					{
						displayedText [MAIN_MENU_TOP].setyPosition(-SCREEN_HEIGHT);
						displayedText [MAIN_MENU_TOP].setMovement(NO_MOVEMENT);
					}
				}
				//Moves the game circle off the screen
				if (displayedText [GAME_CIRCLE].getyPosition() < SCREEN_HEIGHT)
				{
					displayedText [GAME_CIRCLE].setMovement(displayedText [GAME_CIRCLE].getMovement()+SINGLE_INCREASE);
					displayedText [GAME_CIRCLE].setyPosition(displayedText [GAME_CIRCLE].getyPosition()+displayedText [GAME_CIRCLE].getMovement());
					if (displayedText [GAME_CIRCLE].getyPosition() > SCREEN_HEIGHT)
					{
						displayedText [GAME_CIRCLE].setyPosition(SCREEN_HEIGHT);
						displayedText [GAME_CIRCLE].setMovement(NO_MOVEMENT);
					}
					menuFruit[MENU_APPLE].setyPosition(displayedText[GAME_CIRCLE].getyPosition()+MAIN_MENU_FRUIT_CIRCLE_POS);
				}
				//Moves the option circle off the screen
				if (displayedText [OPTION_CIRCLE].getyPosition() < SCREEN_HEIGHT)
				{
					displayedText [OPTION_CIRCLE].setMovement(displayedText [OPTION_CIRCLE].getMovement()+SINGLE_INCREASE);
					displayedText [OPTION_CIRCLE].setyPosition(displayedText [OPTION_CIRCLE].getyPosition()+displayedText [OPTION_CIRCLE].getMovement());
					if (displayedText [OPTION_CIRCLE].getyPosition() > SCREEN_HEIGHT)
					{
						displayedText [OPTION_CIRCLE].setyPosition(SCREEN_HEIGHT);
						displayedText [OPTION_CIRCLE].setMovement(NO_MOVEMENT);
					}
					menuFruit[MENU_COCONUT].setyPosition(displayedText[OPTION_CIRCLE].getyPosition()+MAIN_MENU_FRUIT_CIRCLE_POS);
				}
				//Moves the database circle off the screen
				if (displayedText [DATABASE_CIRCLE].getyPosition() < SCREEN_HEIGHT)
				{
					displayedText [DATABASE_CIRCLE].setMovement(displayedText [DATABASE_CIRCLE].getMovement()+SINGLE_INCREASE);
					displayedText [DATABASE_CIRCLE].setyPosition(displayedText [DATABASE_CIRCLE].getyPosition()+displayedText [DATABASE_CIRCLE].getMovement());
					if (displayedText [DATABASE_CIRCLE].getyPosition() > SCREEN_HEIGHT)
					{
						displayedText [DATABASE_CIRCLE].setyPosition(SCREEN_HEIGHT);
						displayedText [DATABASE_CIRCLE].setMovement(NO_MOVEMENT);
					}
					menuFruit[MENU_MUSHROOM].setyPosition(displayedText[DATABASE_CIRCLE].getyPosition()+MAIN_MENU_FRUIT_CIRCLE_POS);
				}
				//Makes it so the fruit can no longer be slashes on the menu
				meneFruitSlashable=false;
			}
			if (currentEvent==CLASSIC_MODE)
			{
				//Allows the user to pause
				//TODO FIX PAUSE

				displayedButton[PAUSE].setClickable(false);
				//Starts a count down before the game starts or after game is unpaused
				if (countDownScreen)
				{
					countDownCounter++;
					if (countDownCounter==COUNT_DOWN_DURATION/2)
						soundEffects[THREE_SF].play();
					if (countDownCounter==COUNT_DOWN_DURATION*2)
						soundEffects[TWO_SF].play();
					if (countDownCounter==COUNT_DOWN_DURATION*3)
						soundEffects[ONE_SF].play();
					if (countDownCounter==COUNT_DOWN_DURATION*4)
						soundEffects[READY_SF].play();
					if (countDownCounter==PAUSE_LENGTH)
					{
						//Resets count down for later use and turns it off
						countDownCounter=MIN_COUNTER;
						countDownScreen=false;
						soundEffects[GO_SF].play();
					}
				}
				else //If not counting, game is playing
				{
					//For the number of fruit that is supposed to be on screen if a fruit doesn not exist, create one
					for (int i=MIN_COUNTER; i<numberOfFruitOnScreen;i++)
					{
						if (shownFruit[i]==null)
						{
							//Generate a spawning location based on random variations
							fruitToAdd =  generator.nextInt(NUMBER_OF_FRUIT);
							fruitX =  generator.nextInt(MAX_X)+MIN_X; 
							fruitVer =  generator.nextInt(MAX_VERTICAL)+MIN_VERTICAL;
							fruitHor =  generator.nextInt(MAX_HORIZONTAL)+MIN_HORIZONTAL;

							//Creates the fruit
							shownFruit[i]= new Fruit (defaultFruit[fruitToAdd].getFruitColour(),
									fruitX, Y, fruitHor, fruitVer, defaultFruit[fruitToAdd].getPicture());
							currentHey =  generator.nextInt(NUMBER_OF_HEY);
							if (generator.nextInt(5) == 1)
								hey[currentHey].play();

						}
						else
						{
							//If fruit already exists, move it according to previously set data
							shownFruit[i].setxPosition(shownFruit[i].getxPosition()+shownFruit[i].getxMovement());
							shownFruit[i].setyPosition(shownFruit[i].getyPosition()-shownFruit[i].getyMovement());
							//Decrease speed of the fruit moving up and eventually move them down
							shownFruit[i].setyMovement(shownFruit[i].getyMovement()-SINGLE_INCREASE);
							if (shownFruit[i].getyPosition()>OFF_SCREEN)
							{//If a fruit were to fall off screen, a live would be lost
								if (shownFruit[i].getPicture()!=defaultFruit[BAD_APPLE].getPicture())
								{
									fallCount++;
								}
								shownFruit[i]=null; //The fruit becomes null, so another fruit can be created
								//If the number of fruit on the screen has not reached its max which is set in the code, make another fruit appear
								if (numberOfFruitOnScreen < MAX_NUMBER_OF_FRUIT_ON_SCREEN)
								{
									numberOfFruitOnScreen++;
								}
								if (fallCount >= NUMBER_OF_LIVES)
								{
									//if all lives lost, game ends and scores and calculated
									currentEvent=GAME_OVER;
									if (gameScores.calculateHighScores(score))
										soundEffects[NEW_RECORD_SF].play();
									else
										soundEffects[GAME_SF].play();
									gameScores.calculateHighestCombo(highestComboScore);
									writeScores();
								}
							}

						}
					}
					if (comboScore>MIN_COUNTER)
					{
						comboCounter++; //If a combo exists the counter increases
						if (comboCounter>COMBO_COUNTER_MAX)
						{//If the combo reaches its max counter, give points according to bonus
							comboCounter=MIN_COUNTER;
							if (comboScore==SINGLE_COMBO)
								score=score+SINGLE_COMBO_BONUS;
							if (comboScore==DOUBLE_COMBO)
								score=score+DOUBLE_COMBO_BONUS;
							if (comboScore>=TRIPLE_COMBO)
								score=score+TRIPLE_COMBO_BONUS;
							if (comboScore>highestComboScore)
								highestComboScore=comboScore;
							comboScore=MIN_COUNTER; //Cancels counter

						}
					}
					if (displayedButton[PAUSE].isHighlighted())
					{//If the user clicks the pause button, options to leave game or pause comes to play, count down starts again after if unpaused
						displayedButton[EXIT].setClickable(true);
						repaint();
						while (displayedButton[PAUSE].isHighlighted())
						{
						}
						countDownScreen=true;
						displayedButton[EXIT].setClickable(false);
					}
				}
			}
			if (currentEvent==GAME_OVER)
			{
				//Saves data and displayed required buttons
				displayedButton[PAUSE].setClickable(false);
				displayedButton[DONE].setClickable(true);//if not options, remove done button
			}
			else
			{
				//Takes away done button
				if (currentEvent!=OPTIONS && currentEvent!=DATABASE && currentEvent!=INSTRUCTIONS)
				{
					displayedButton[DONE].setClickable(false);//if not options, remove done button
				}
			}
			if (currentEvent==INSTRUCTIONS)
			{
				//Displays done button
				displayedButton[DONE].setClickable(true);//if not options, remove done button
			}
			else
			{
				//Takes away done button
				if (currentEvent!=OPTIONS && currentEvent!=DATABASE && currentEvent!=GAME_OVER)
				{
					displayedButton[DONE].setClickable(false);//if not options, remove done button
				}
			}
			if (currentEvent==DATABASE)
			{
				//Displays done button
				displayedButton[DONE].setClickable(true);//if not options, remove done button
			}
			else
			{
				//Removes done button
				if (currentEvent!=OPTIONS && currentEvent!=GAME_OVER && currentEvent!=INSTRUCTIONS)
				{
					displayedButton[DONE].setClickable(false);//if not options, remove done button
				}
				//Resets the database scroller
				databaseScrollerY=MIN_COUNTER;
			}
			if (currentEvent==OPTIONS)
			{//Moves the options top display in place
				if (displayedText [OPTION_TOP].getyPosition() < ORIGIN_Y)
				{
					displayedText [OPTION_TOP].setMovement(displayedText [OPTION_TOP].getMovement()+SINGLE_INCREASE);
					displayedText [OPTION_TOP].setyPosition(displayedText [OPTION_TOP].getyPosition()+displayedText [OPTION_TOP].getMovement());
					if (displayedText [OPTION_TOP].getyPosition() > MIN_COUNTER)
					{//Stops movement when reached end point
						displayedText [OPTION_TOP].setyPosition(NO_MOVEMENT);
						displayedText [OPTION_TOP].setMovement(NO_MOVEMENT);
					}
				}
				if (displayedText [OPTION_BOTTOM].getyPosition() > ORIGIN_Y)
				{//Movies the options bottom display in place
					displayedText [OPTION_BOTTOM].setMovement(displayedText [OPTION_BOTTOM].getMovement()-SINGLE_INCREASE);
					displayedText [OPTION_BOTTOM].setyPosition(displayedText [OPTION_BOTTOM].getyPosition()+displayedText [OPTION_BOTTOM].getMovement());
					if (displayedText [OPTION_BOTTOM].getyPosition() <= ORIGIN_Y)
					{
						//Stops movement of bottom menus when neccesary
						displayedText [OPTION_BOTTOM].setyPosition(NO_MOVEMENT);
						displayedText [OPTION_BOTTOM].setMovement(NO_MOVEMENT);
						for (int i = DONE; i<=BACKGROUND0;i++)
						{//Displays all required buttons for options
							displayedButton[i].setClickable(true);
						}
					}
				}
			}
			else
			{
				//Moves options top away from screen
				if (displayedText [OPTION_TOP].getyPosition() > -SCREEN_HEIGHT)
				{
					displayedText [OPTION_TOP].setMovement(displayedText [OPTION_TOP].getMovement()-SINGLE_INCREASE);
					displayedText [OPTION_TOP].setyPosition(displayedText [OPTION_TOP].getyPosition()+displayedText [OPTION_TOP].getMovement());
					if (displayedText [OPTION_TOP].getyPosition() <-SCREEN_HEIGHT)
					{
						displayedText [OPTION_TOP].setyPosition(-SCREEN_HEIGHT);
						displayedText [OPTION_TOP].setMovement(NO_MOVEMENT);
					}
				}
				//Moves options bottom away from screen
				if (displayedText [OPTION_BOTTOM].getyPosition() < SCREEN_HEIGHT)
				{
					displayedText [OPTION_BOTTOM].setMovement(displayedText [OPTION_BOTTOM].getMovement()+1);
					displayedText [OPTION_BOTTOM].setyPosition(displayedText [OPTION_BOTTOM].getyPosition()+displayedText [OPTION_BOTTOM].getMovement());
					if (displayedText [OPTION_BOTTOM].getyPosition() > SCREEN_HEIGHT)
					{
						displayedText [OPTION_BOTTOM].setyPosition(SCREEN_HEIGHT);
						displayedText [OPTION_BOTTOM].setMovement(NO_MOVEMENT);
					}
				}
				//Removes done button if not right screen
				if (currentEvent!=GAME_OVER && currentEvent!= DATABASE && currentEvent!=INSTRUCTIONS)
				{
					displayedButton[DONE].setClickable(false);//if not options, remove done button
				}
				//Removes all other buttons
				for (int i=WHITEBLADE; i<=BACKGROUND0; i++)
				{
					displayedButton[i].setClickable(false);
				}
			}
			//Movies seeds if on screen
			for (int i=MIN_COUNTER; i < seed.size(); i++)
			{
				seed.get(i).setxPosition(seed.get(i).getxPosition()+seed.get(i).getxMovement());
				seed.get(i).setyPosition(seed.get(i).getyPosition()-seed.get(i).getyMovement());
				seed.get(i).setyMovement(seed.get(i).getyMovement()-SINGLE_INCREASE);
				if (seed.get(i).getyPosition()>OFF_SCREEN) //Under screen
				{
					//Removes seeds when needed
					seed.remove(i);
				}
			}
			for (int i=0; i < blade.size(); i++)
			{
				//Removes blade when needed
				if (blade.get(i)!=null) //Random times array list will try to access and blade that does not exist
				{
					blade.get(i).setCounter(blade.get(i).getCounter()+SINGLE_INCREASE); //Adds to counter each time
					if (blade.get(i).getCounter()>=blade.get(i).getBLADE_DURATION()) //Checks counter max to see when to remove
					{
						blade.remove(i); 
					}
				}
			}
			//Does commands for each splash on screen
			for (int i=0; i < splash.size(); i++)
			{
				//Checks duration length of each splash
				splash.get(i).setDurationCount(splash.get(i).getDurationCount()+1);
				if (splash.get(i).getDurationCount()>=splash.get(i).getDURATION())
				{
					if (splash.get(i).getCurrentStage()<NUMBER_OF_ADDITION_SPLASHES)
					{ //changes splash to next splash if duration over and resets duration
						splash.get(i).setCurrentStage(splash.get(i).getCurrentStage()+1);
						splash.get(i).setDurationCount(MIN_COUNTER);
					}
					else
					{
						//removes splash if on last stage
						splash.remove(i);
					}
				}
			}
			repaint();
			try 
			{
				Thread.sleep(GAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/////////////////////////////////////////////////////////////////////////////////       

	public void update (Graphics g)
	{

		// Initialise buffer
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize ().width, this.getSize ().height);
			dbg = dbImage.getGraphics ();
		}

		// clear screen in backgroundStart
		dbg.setColor (getBackground ());
		dbg.fillRect (ORIGIN_X, ORIGIN_Y, this.getSize ().width, this.getSize ().height);

		// draw elements in backgroundStart
		dbg.setColor (getForeground ());
		paint (dbg);

		// draw image on the screen
		g.drawImage (dbImage, ORIGIN_X, ORIGIN_Y, this);

	}

	/////////////////////////////////////////////////////////////////////////////////////////       

	public void init ()
	{
		//Loads all saved data

		resize (960,640);
		
			readScores();

			
			
		try { 
			// getDocumentbase gets the applet path. 
			base = getDocumentBase(); 
		} 
		catch (Exception e) {} 

		//Sets values for the start of the game
		fallCount=MIN_COUNTER;
		score=MIN_COUNTER;
		numberOfFruitOnScreen=STARTING_NUMBER_OF_FRUIT;
		comboCounter=MIN_COUNTER;
		comboScore=MIN_COUNTER;
		highestComboScore=MIN_COUNTER;
		meneFruitSlashable=false;
		countDownScreen=false;
		countDownCounter=MIN_COUNTER;
		currentEvent=MAIN_MENU;

		//Sets all comic pictures into their array
		for (int i =MIN_COUNTER; i < NUMBER_OF_FRUIT;i++)
		{
			comicPicture[i] = getImage(base,"db"+i+".png");
		}
		//Sets all squish sounds into their array
		for (int i =MIN_COUNTER; i < NUMBER_OF_SQUISH; i++)
		{
			squish[i] = getAudioClip(getDocumentBase(),"squish"+i+".wav");
		}
		//Sets all spawn sounds into their array
		for (int i =MIN_COUNTER; i < NUMBER_OF_HEY; i++)
		{
			hey[i] = getAudioClip(getDocumentBase(),"hey"+i+".wav");
		}

		//Sets other images into variables
		databaseScroll= getImage(base,"databasescroller.png");
		databaseOverlay= getImage(base,"databaseOverlay.png");
		xImage = getImage (base, "x.png");
		instructionScreen = getImage (base, "instructionScreen.png");

		//Creates a default list of fruit so extract information from when creating fruit for the game
		defaultFruit[BAD_APPLE]= new Fruit ("white",getImage(base,"badapple.png"));
		defaultFruit[GRAPES]= new Fruit ("green",getImage(base,"grapes.png"));
		defaultFruit[LEMON]= new Fruit ("yellow",getImage(base,"lemon.png"));
		defaultFruit[LIME]= new Fruit ("white",getImage(base,"lime.png"));
		defaultFruit[MELON]= new Fruit ("pink",getImage(base,"melon.png"));
		defaultFruit[PEAR]= new Fruit ("white",getImage(base,"pear.png"));
		defaultFruit[PINEAPPLE]= new Fruit ("yellow",getImage(base,"pineapple.png"));
		defaultFruit[STRAWBERRY]= new Fruit ("red",getImage(base,"strawberry.png"));
		defaultFruit[BANANA]= new Fruit ("white",getImage(base,"banana.png"));
		defaultFruit[BLUEBERRY]= new Fruit ("blue",getImage(base,"blueberry.png"));
		defaultFruit[CHERRY]= new Fruit ("red",getImage(base,"cherry.png"));
		defaultFruit[GOOSEBERRY]= new Fruit ("green",getImage(base,"gooseberry.png"));
		defaultFruit[KIWI_FRUIT]= new Fruit ("green",getImage(base,"kiwifruit.png"));
		defaultFruit[ORANGE]= new Fruit ("orange",getImage(base,"orange.png"));
		defaultFruit[PEACH]= new Fruit ("orange",getImage(base,"peach.png"));
		defaultFruit[SATSUMA]= new Fruit ("orange",getImage(base,"satsuma.png"));
		defaultFruit[APPLE]= new Fruit ("white",getImage(base,"apple.png"));
		defaultFruit[POMEGRANATE]= new Fruit ("red",getImage(base,"pomegranate.png"));
		defaultFruit[PAPAYA]= new Fruit ("orange",getImage(base,"papaya.png"));
		defaultFruit[OLIVE]= new Fruit ("green",getImage(base,"olive.png"));
		defaultFruit[RASPBERRY]= new Fruit ("red",getImage(base,"raspberry.png"));
		defaultFruit[MANGO]= new Fruit ("orange",getImage(base,"mango.png"));
		defaultFruit[COCONUT]= new Fruit ("white",getImage(base,"coconut.png"));
		defaultFruit[STARFRUIT]= new Fruit ("yellow",getImage(base,"starfruit.png"));
		defaultFruit[AVOCADO]= new Fruit ("green",getImage(base,"avocado.png"));
		defaultFruit[MANDARIN]= new Fruit ("orange",getImage(base,"mandarin.png"));
		defaultFruit[PASSION_FRUIT]= new Fruit ("yellow",getImage(base,"passionfruit.png"));
		defaultFruit[APRICOT]= new Fruit ("pink",getImage(base,"apricot.png"));
		defaultFruit[MANGOSTEEN]= new Fruit ("white",getImage(base,"mangosteen.png"));
		defaultFruit[DRAGON_FRUIT]= new Fruit ("white",getImage(base,"dragonfruit.png"));
		defaultFruit[PLUM]= new Fruit ("purple",getImage(base,"plum.png"));
		defaultFruit[ELDERBERRY]= new Fruit ("purple",getImage(base,"elderberry.png"));
		defaultFruit[ONION]= new Fruit ("white",getImage(base,"onion.png"));
		defaultFruit[MUSHROOM]= new Fruit ("white",getImage(base,"mushroom.png"));
		defaultFruit[TOMATO]= new Fruit ("red",getImage(base,"tomato.png"));
		defaultFruit[CORN]= new Fruit ("yellow",getImage(base,"corn.png"));
		defaultFruit[BROCCOLI]= new Fruit ("green",getImage(base,"broccoli.png"));
		defaultFruit[CHICKPEA]= new Fruit ("yellow",getImage(base,"chickpea.png"));
		defaultFruit[PUMPKIN]= new Fruit ("orange",getImage(base,"pumpkin.png"));
		defaultFruit[PEA]= new Fruit ("green",getImage(base,"pea.png"));
		defaultFruit[CARROT]= new Fruit ("orange",getImage(base,"carrot.png"));
		defaultFruit[BEAN]= new Fruit ("green",getImage(base,"bean.png"));
		defaultFruit[POTATO]= new Fruit ("yellow",getImage(base,"potato.png"));
		defaultFruit[BRUSSELS_SPROUTS]= new Fruit ("green",getImage(base,"brusselssprout.png"));

		//Creates the fruit for the menu options
		menuFruit[MENU_APPLE]= new Fruit (defaultFruit[APPLE].getFruitColour(),
				MENU_APPLE_X, ORIGIN_Y, NO_MOVEMENT, NO_MOVEMENT,69,84, defaultFruit[APPLE].getPicture());

		menuFruit[MENU_COCONUT]= new Fruit (defaultFruit[COCONUT].getFruitColour(),
				MENU_COCONUT_X, ORIGIN_Y, NO_MOVEMENT,NO_MOVEMENT,81,91,defaultFruit[COCONUT].getPicture());

		menuFruit[MENU_MUSHROOM]= new Fruit (defaultFruit[MUSHROOM].getFruitColour(),
				MENU_MUSHROOM_X, ORIGIN_Y, NO_MOVEMENT,NO_MOVEMENT,80,76,defaultFruit[MUSHROOM].getPicture());


		//sets up the image for the seed
		seedPicture = getImage(base,"seed.png");



		//Creates to pictures for menus deciding direction and location
		displayedText [OPTION_TOP] = new optionPicture (ORIGIN_X,-SCREEN_HEIGHT,getImage(base,"optionmenutop.png"));
		displayedText [OPTION_BOTTOM] = new optionPicture (ORIGIN_X,SCREEN_HEIGHT,getImage(base,"optionmenubottom.png"));
		displayedText [MAIN_MENU_TOP] = new optionPicture (ORIGIN_X,-SCREEN_HEIGHT,getImage(base,"mainmenutop.png"));
		displayedText [GAME_CIRCLE] = new optionPicture (GAME_CIRCLE_X_POS,SCREEN_HEIGHT,getImage(base,"game.png"));
		displayedText [OPTION_CIRCLE] = new optionPicture (OPTION_CIRCLE_X_POS,SCREEN_HEIGHT,getImage(base,"options.png"));
		displayedText [DATABASE_CIRCLE] = new optionPicture (DATABASE_CIRCLE_X_POS,SCREEN_HEIGHT,getImage(base,"database.png"));
		displayedText [GAME_OVER_SCREEN] = new optionPicture (ORIGIN_X,ORIGIN_Y,getImage(base,"gameover.png"));
		displayedText [COUNTER3] = new optionPicture (ORIGIN_X,ORIGIN_Y,getImage(base,"3lives.png"));
		displayedText [COUNTER2] = new optionPicture (ORIGIN_X,ORIGIN_Y,getImage(base,"2nothing.png"));
		displayedText [COUNTER1] = new optionPicture (ORIGIN_X,ORIGIN_Y,getImage(base,"1badapple.png"));


		//Creates to pictures for buttons deciding direction and location
		displayedButton [DONE] = new clickablePicture (DONE_BUTTON_X,DONE_BUTTON_Y,DONE_BUTTON_WIDTH,DONE_BUTTON_HEIGHT,getImage(base,"done.png"),getImage(base,"donehover.png"));
		displayedButton [EXIT] = new clickablePicture (EXIT_BUTTON_X,EXIT_BUTTON_Y,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT,getImage(base,"exit.png"),getImage(base,"exithover.png"));
		displayedButton [INSTRUCTION_BUTTON] = new clickablePicture (INSTRUCTIONS_BUTTON_X,INSTRUCTION_BUTTON_Y,INSTRUCTION_BUTTON_WIDTH,INSTRUCTION_BUTTON_HEIGHT,getImage(base,"instructions.png"),getImage(base,"instructionshover.png"));
		displayedButton [WHITEBLADE] = new clickablePicture (WHITE_BLADE_BUTTON_X,WHITE_BLADE_BUTTON_Y,WHITE_BLADE_BUTTON_WIDTH,WHITE_BLADE_BUTTON_HEIGHT,getImage(base,"white.png"),getImage(base,"whitehover.png"));
		displayedButton [REDBLADE] = new clickablePicture (RED_BLADE_BUTTON_X,RED_BLADE_BUTTON_Y,RED_BLADE_BUTTON_WIDTH,RED_BLADE_BUTTON_HEIGHT,getImage(base,"red.png"),getImage(base,"redhover.png"));
		displayedButton [GREENBLADE] = new clickablePicture (GREEN_BLADE_BUTTON_X,GREEN_BLADE_BUTTON_Y,GREEN_BLADE_BUTTON_WIDTH,GREEN_BLADE_BUTTON_HEIGHT,getImage(base,"green.png"),getImage(base,"greenhover.png"));
		displayedButton [SONG1] = new clickablePicture (SONG1_BUTTON_X,SONG1_BUTTON_Y,SONG1_BUTTON_WIDTH,SONG1_BUTTON_HEIGHT,getImage(base,"song1.png"),getImage(base,"song1hover.png"));
		displayedButton [SONG2] = new clickablePicture (SONG2_BUTTON_X,SONG2_BUTTON_Y,SONG2_BUTTON_WIDTH,SONG2_BUTTON_HEIGHT,getImage(base,"song2.png"),getImage(base,"song2hover.png"));
		displayedButton [SONG3] = new clickablePicture (SONG3_BUTTON_X,SONG3_BUTTON_Y,SONG3_BUTTON_WIDTH,SONG3_BUTTON_HEIGHT,getImage(base,"song3.png"),getImage(base,"song3hover.png"));
		displayedButton [SONG4] = new clickablePicture (SONG4_BUTTON_X,SONG4_BUTTON_Y,SONG4_BUTTON_WIDTH,SONG4_BUTTON_HEIGHT,getImage(base,"song4.png"),getImage(base,"song4hover.png"));
		displayedButton [SONG0] = new clickablePicture (SONG0_BUTTON_X,SONG0_BUTTON_Y,SONG0_BUTTON_WIDTH,SONG0_BUTTON_HEIGHT,getImage(base,"song0.png"),getImage(base,"song0hover.png"));
		displayedButton [BACKGROUND1] = new clickablePicture (BACKGROUND1_BUTTON_X,BACKGROUND1_BUTTON_Y,BACKGROUND_BUTTON_DIMENSIONS,BACKGROUND_BUTTON_DIMENSIONS,getImage(base,"bg1sample.png"),getImage(base,"bg1samplehover.png"));
		displayedButton [BACKGROUND2] = new clickablePicture (BACKGROUND2_BUTTON_X,BACKGROUND2_BUTTON_Y,BACKGROUND_BUTTON_DIMENSIONS,BACKGROUND_BUTTON_DIMENSIONS,getImage(base,"bg2sample.png"),getImage(base,"bg2samplehover.png"));
		displayedButton [BACKGROUND3] = new clickablePicture (BACKGROUND3_BUTTON_X,BACKGROUND3_BUTTON_Y,BACKGROUND_BUTTON_DIMENSIONS,BACKGROUND_BUTTON_DIMENSIONS,getImage(base,"bg3sample.png"),getImage(base,"bg3samplehover.png"));
		displayedButton [BACKGROUND0] = new clickablePicture (BACKGROUND0_BUTTON_X,BACKGROUND0_BUTTON_Y,BACKGROUND_BUTTON_DIMENSIONS,BACKGROUND_BUTTON_DIMENSIONS,getImage(base,"bg0sample.png"),getImage(base,"bg0samplehover.png"));
		displayedButton [PAUSE] = new clickablePicture (PAUSE_BUTTON_X,PAUSE_BUTTON_Y,PAUSE_BUTTON_DIMENSIONS,PAUSE_BUTTON_DIMENSIONS,getImage(base,"pause.png"),getImage(base,"play.png"));


		soundEffects[CLASSIC_MODE_SF]= getAudioClip(getDocumentBase(),"sf0.wav");
		soundEffects[TEAM_BATTLE_SF]= getAudioClip(getDocumentBase(),"sf1.wav");
		soundEffects[SPECTATE_SF]= getAudioClip(getDocumentBase(),"sf2.wav");
		soundEffects[THREE_SF]= getAudioClip(getDocumentBase(),"sf3.wav");
		soundEffects[TWO_SF]= getAudioClip(getDocumentBase(),"sf4.wav");
		soundEffects[ONE_SF]= getAudioClip(getDocumentBase(),"sf5.wav");
		soundEffects[READY_SF]= getAudioClip(getDocumentBase(),"sf6.wav");
		soundEffects[GO_SF]= getAudioClip(getDocumentBase(),"sf7.wav");
		soundEffects[GAME_SF]= getAudioClip(getDocumentBase(),"sf8.wav");
		soundEffects[NEW_RECORD_SF]= getAudioClip(getDocumentBase(),"sf9.wav");
		soundEffects[TRAINING_SF]= getAudioClip(getDocumentBase(),"sf10.wav");
		soundEffects[ROTATION_SF]= getAudioClip(getDocumentBase(),"sf11.wav");
		soundEffects[CLICK_SF]= getAudioClip(getDocumentBase(),"sf12.wav");





		//Sets up all the backgrounds based on the amount inputed at the top
		for (int i=MIN_COUNTER; i<NUMBER_OF_BACKGROUNDS; i++)
		{
			background[i]= getImage(base,"bg"+i+".png");
		}



		//Sets up all the songs based on the amount inputed at the top
		for (int i=MIN_COUNTER; i<NUMBER_OF_SONGS; i++)
		{
			song[i]= getAudioClip(getDocumentBase(),"song"+i+".wav");
		}


		//Starts the previously saved song
		song[gameScores.getSelectedSong()].loop();
		if (gameScores.getSelectedSong()==JINJO_VILLAGE)
			displayedButton[SONG1].setHighlighted(true);
		if (gameScores.getSelectedSong()==CAN_CAN)
			displayedButton[SONG2].setHighlighted(true);
		if (gameScores.getSelectedSong()==LOVE_IS_IN_THE_AIR)
			displayedButton[SONG3].setHighlighted(true);
		if (gameScores.getSelectedSong()==THEME_SONG_YELLOW)
			displayedButton[SONG4].setHighlighted(true);
		if (gameScores.getSelectedSong()==CLICK_CLOCK_WOOD)
			displayedButton[SONG0].setHighlighted(true);

		//Starts the game with previously selected blade
		if (gameScores.getSelectedBlade()==WHITE_BLADE_VALUE)
			displayedButton[WHITEBLADE].setHighlighted(true);
		if (gameScores.getSelectedBlade()==RED_BLADE_VALUE)
			displayedButton[REDBLADE].setHighlighted(true);
		if (gameScores.getSelectedBlade()==GREEN_BLADE_VALUE)
			displayedButton[GREENBLADE].setHighlighted(true);

		//Starts the game with previously selected background
		if (gameScores.getSelectedBackground()==BACKGROUND1_VALUE)
			displayedButton[BACKGROUND1].setHighlighted(true);
		if (gameScores.getSelectedBackground()==BACKGROUND2_VALUE)
			displayedButton[BACKGROUND2].setHighlighted(true);
		if (gameScores.getSelectedBackground()==BACKGROUND3_VALUE)
			displayedButton[BACKGROUND3].setHighlighted(true);
		if (gameScores.getSelectedBackground()==BACKGROUND0_VALUE)
			displayedButton[BACKGROUND0].setHighlighted(true);

		addMouseListener (this);
		addMouseMotionListener(this);
		t.start();
		
		

		//Start the rotation counter to start with no rotation
		multiplier=MIN_COUNTER;

	} // init method

	/////////////////////////////////////////////////////////////////////////////////////////    

	public void paint (Graphics g)
	{

		Graphics2D g2d = (Graphics2D) g;
		//Change the font for score use
		g.setFont(gameFont);
		g.setColor(Color.white);
		//Draw background as first thing so will be in the back
		g.drawImage(background[gameScores.getSelectedBackground()],ORIGIN_X,ORIGIN_Y,this);

		//Draw all splashes on screen
		for (int i=MIN_COUNTER; i <splash.size();i++)
		{
			g.drawImage(splash.get(i).getPicture(),splash.get(i).getxPosition(),splash.get(i).getyPosition(),this);
		}

		//Draw all seeds on the screen
		for (int i=MIN_COUNTER; i <seed.size();i++)
		{
			g.drawImage(seed.get(i).getPicture(),seed.get(i).getxPosition(),seed.get(i).getyPosition(),this);
		}

		//Keep menus on screen for sliding on and off use
		g.drawImage(displayedText [OPTION_TOP].getPicture(),displayedText [OPTION_TOP].getxPosition(), displayedText [OPTION_TOP].getyPosition(),this);
		g.drawImage(displayedText [OPTION_BOTTOM].getPicture(),displayedText [OPTION_BOTTOM].getxPosition(), displayedText [OPTION_BOTTOM].getyPosition(),this);
		g.drawImage(displayedText [MAIN_MENU_TOP].getPicture(),displayedText [MAIN_MENU_TOP].getxPosition(), displayedText [MAIN_MENU_TOP].getyPosition(),this);

		//Draw blades on screen as required, on top of the menus
		for (int i=MIN_COUNTER; i <blade.size();i++)
		{
			if (blade.get(i)!=null) //Random times array list will try to access and blade that does not exist
				g.drawImage(blade.get(i).getPicture(),blade.get(i).getxPosition(),blade.get(i).getyPosition(),this);
		}

		//Draws the menu fruit on the screen for going to different menus
		if (currentEvent==MAIN_MENU)
		{
			for (int i=MIN_COUNTER; i<NUMBER_OF_MENU_OPTIONS;i++)
			{
				g.drawImage(menuFruit[i].getPicture(),menuFruit[i].getxPosition(),menuFruit[i].getyPosition(),this);
			}
		}

		else if (currentEvent==CLASSIC_MODE)
		{
			for (int i=0; i<numberOfFruitOnScreen;i++)
			{
				//Draws fruit on the screen
				if (shownFruit[i]!=null)
				{
					g.drawImage(shownFruit[i].getPicture(),shownFruit[i].getxPosition(),shownFruit[i].getyPosition(),this);
				} 
			}
			//Draws the Xs for every fruit dropped
			for (int i=MIN_COUNTER; i<fallCount; i++)
			{
				g.drawImage(xImage,SPACE_BETWEEN_RED_Xs*i,RED_X_Y_POSITION,this);
			}
			//Displays counter pictures based on length
			if (countDownCounter>COUNT_DOWN_DURATION && countDownCounter <COUNT_DOWN_DURATION*2)
			{
				g.drawImage(displayedText[COUNTER3].getPicture(), displayedText[COUNTER3].getxPosition(), displayedText[COUNTER3].getyPosition(),this);
			}
			else if (countDownCounter>=COUNT_DOWN_DURATION*2 && countDownCounter <COUNT_DOWN_DURATION*3)
			{
				g.drawImage(displayedText[COUNTER2].getPicture(), displayedText[COUNTER2].getxPosition(), displayedText[COUNTER2].getyPosition(),this);
			}
			else if (countDownCounter>=COUNT_DOWN_DURATION*3 && countDownCounter <COUNT_DOWN_DURATION*4)
			{
				g.drawImage(displayedText[COUNTER1].getPicture(), displayedText[COUNTER1].getxPosition(), displayedText[COUNTER1].getyPosition(),this);
			}
			//Displays scores and combos
			g.drawString(Integer.toString(score), SCORE_X, SCORE_Y);
			g.drawString("x"+Integer.toString(comboScore),COMBO_X,COMBO_Y);
			//if game is paused, dim down the screen
			if (displayedButton[PAUSE].isHighlighted())
			{
				AlphaComposite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F);
				g2d.setComposite(comp);
				g2d.fillRect(ORIGIN_X,ORIGIN_Y,this.getWidth(), this.getHeight());
				comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
				g2d.setComposite(comp);
			}
		}
		//Sets rotation variables for rotation
		AffineTransform origXform = g2d.getTransform ();
		AffineTransform newXformGame = (AffineTransform) (origXform.clone ());
		AffineTransform newXformOption = (AffineTransform) (origXform.clone ());
		AffineTransform newXformDatabase = (AffineTransform) (origXform.clone ());

		//center of rotation is center of the panel, sets that and draws the rotated image
		double xRot = displayedText [GAME_CIRCLE].getPicture().getWidth (this) / 2;
		double yRot = displayedText [GAME_CIRCLE].getPicture().getHeight (this) / 2;
		newXformGame.rotate (Math.PI/60 * multiplier, xRot+displayedText[GAME_CIRCLE].getxPosition(), yRot+ displayedText [GAME_CIRCLE].getyPosition());
		g2d.setTransform (newXformGame);
		g2d.drawImage(displayedText [GAME_CIRCLE].getPicture(),displayedText [GAME_CIRCLE].getxPosition(), displayedText [GAME_CIRCLE].getyPosition(),this);
		g2d.setTransform (origXform);

		//center of rotation is center of the panel, sets that and draws the rotated image
		xRot = displayedText [OPTION_CIRCLE].getPicture().getWidth (this) / 2;
		yRot = displayedText [OPTION_CIRCLE].getPicture().getHeight (this) / 2;
		newXformOption.rotate (Math.PI/60 * multiplier, xRot+displayedText[OPTION_CIRCLE].getxPosition(), yRot+ displayedText [OPTION_CIRCLE].getyPosition());
		g2d.setTransform (newXformOption);
		g2d.drawImage(displayedText [OPTION_CIRCLE].getPicture(),displayedText [OPTION_CIRCLE].getxPosition(), displayedText [OPTION_CIRCLE].getyPosition(),this);
		g2d.setTransform (origXform);

		//center of rotation is center of the panel, sets that and draws the rotated image
		xRot = displayedText [DATABASE_CIRCLE].getPicture().getWidth (this) / 2;
		yRot = displayedText [DATABASE_CIRCLE].getPicture().getHeight (this) / 2;
		newXformDatabase.rotate (Math.PI/60 * multiplier, xRot+displayedText[DATABASE_CIRCLE].getxPosition(), yRot+ displayedText [DATABASE_CIRCLE].getyPosition());
		g2d.setTransform (newXformDatabase);
		g2d.drawImage(displayedText [DATABASE_CIRCLE].getPicture(),displayedText [DATABASE_CIRCLE].getxPosition(), displayedText [DATABASE_CIRCLE].getyPosition(),this);
		g2d.setTransform (origXform);

		//draw image centered in panel
		g2d.setTransform (origXform);
		if (currentEvent ==INSTRUCTIONS)
		{
			g.drawImage(instructionScreen,ORIGIN_X,ORIGIN_Y, this);
		}
		else if (currentEvent==GAME_OVER)
		{
			//Displays all the scores at the end game screen
			g.drawImage(displayedText [GAME_OVER_SCREEN].getPicture(),displayedText [GAME_OVER_SCREEN].getxPosition(), displayedText [GAME_OVER_SCREEN].getyPosition(),this);
			g.drawString(Integer.toString(score), END_GAME_SCORE_DISPLAY_X, END_GAME_SCORE_DISPLAY_Y);
			g.drawString("x"+Integer.toString(highestComboScore),END_GAME_CURRENT_COMBO_X,END_GAME_CURRENT_COMBO_Y);	
			g.drawString("x"+Integer.toString(gameScores.getHighestCombo()), END_GAME_HIGH_COMBO_X, END_GAME_HIGH_COMBO_Y);
			g.drawString("1st: "+Integer.toString(gameScores.getHighScores1()), END_GAME_HIGH_SCORE_X, END_GAME_FIRST_SCORE_Y);
			g.drawString("2nd: "+Integer.toString(gameScores.getHighScores2()), END_GAME_HIGH_SCORE_X, END_GAME_SECOND_SCORE_Y);
			g.drawString("3rd: "+Integer.toString(gameScores.getHighScores3()), END_GAME_HIGH_SCORE_X, END_GAME_THIRD_SCORE_Y);
		}
		else if (currentEvent==DATABASE)
		{
			//Draws database menu interface
			g.drawImage(databaseScroll,DATABASE_SCROLLER_X, databaseScrollerY,this);
			g.drawImage(databaseOverlay,ORIGIN_X, ORIGIN_Y,this);
			//Draws fruit and comic based on where the scroll interface is
			if (databaseScrollerY%DATABASE_NAME_SPACING==MIN_COUNTER)
			{
				g.drawImage(defaultFruit[-(databaseScrollerY/DATABASE_NAME_SPACING)+DATABASE_START_SKIP].getPicture(),DATABASE_FRUIT_X,DATABASE_FRUIT_Y,this);
				g.drawImage(comicPicture[-(databaseScrollerY/DATABASE_NAME_SPACING)+DATABASE_START_SKIP],DATABASE_COMIC_X,DATABASE_COMIC_Y,this);
			}
		}


		//Displays button when they are clickable, and draw highlighted image if image is highlighted
		//Note: some images get highlighted by hovering over them, some by clicking them
		for (int i =MIN_COUNTER; i< NUMBER_OF_BUTTONS; i++)
		{
			if (displayedButton[i].isClickable())
			{
				if (displayedButton[i].isHighlighted())	
				{
					g.drawImage(displayedButton[i].getClickedVersion(), displayedButton[i].getxPosition(), displayedButton[i].getyPosition(),this);
				}
				else
				{
					g.drawImage(displayedButton[i].getPicture(), displayedButton[i].getxPosition(), displayedButton[i].getyPosition(),this);
				}
			}
		}

	}

	public void mouseClicked(MouseEvent e)
	{
		yPosition = e.getY ();
		xPosition = e.getX ();

		if (currentEvent==OPTIONS || currentEvent == GAME_OVER || currentEvent==DATABASE || currentEvent ==INSTRUCTIONS)
		{//If the user clicks the done button
			if (xPosition > displayedButton[DONE].getxPosition()
					&&xPosition < (displayedButton[DONE].getxPosition()+displayedButton[DONE].getWidth())
					&&yPosition > displayedButton[DONE].getyPosition()
					&&yPosition < (displayedButton[DONE].getyPosition()+displayedButton[DONE].getHeight())
					&&displayedButton[DONE].isClickable())
			{
				displayedButton[DONE].setClickable(false);
				displayedButton[DONE].setHighlighted(false);
				resetFruit();
				//Stops the movement of the menus so that the acceleration does not interfere with menu changing
				for (int i =MIN_COUNTER; i < NUMBER_OF_TEXT; i++)
				{
					displayedText[i].setMovement(0);
				}
				//Takes user back to the main menu
				soundEffects[CLICK_SF].play();
				currentEvent=MAIN_MENU;
			}
		}
		if (currentEvent==MAIN_MENU)
		{
			// If instruction button is clicked, go to instruction screen and remove button
			if (xPosition > displayedButton[INSTRUCTION_BUTTON].getxPosition()
					&&xPosition < (displayedButton[INSTRUCTION_BUTTON].getxPosition()+displayedButton[INSTRUCTION_BUTTON].getWidth())
					&&yPosition > displayedButton[INSTRUCTION_BUTTON].getyPosition()
					&&yPosition < (displayedButton[INSTRUCTION_BUTTON].getyPosition()+displayedButton[INSTRUCTION_BUTTON].getHeight())
					&&displayedButton[INSTRUCTION_BUTTON].isClickable())
			{
				displayedButton[INSTRUCTION_BUTTON].setClickable(false);
				displayedButton[INSTRUCTION_BUTTON].setHighlighted(false);
				currentEvent=INSTRUCTIONS;
				soundEffects[CLICK_SF].play();
				soundEffects[TRAINING_SF].play();
			}
			//If exit button is clicked, close the game
			if (xPosition > displayedButton[EXIT].getxPosition()
					&&xPosition < (displayedButton[EXIT].getxPosition()+displayedButton[EXIT].getWidth())
					&&yPosition > displayedButton[EXIT].getyPosition()
					&&yPosition < (displayedButton[EXIT].getyPosition()+displayedButton[EXIT].getHeight())
					&&displayedButton[EXIT].isClickable())
			{
				System.exit(0);
			}
		}
		if (currentEvent==CLASSIC_MODE)
		{
			//If pause button is clicked, switch between paused and unpaused
			if (xPosition > displayedButton[PAUSE].getxPosition()
					&&xPosition < (displayedButton[PAUSE].getxPosition()+displayedButton[PAUSE].getWidth())
					&&yPosition > displayedButton[PAUSE].getyPosition()
					&&yPosition < (displayedButton[PAUSE].getyPosition()+displayedButton[PAUSE].getHeight())
					&&displayedButton[PAUSE].isClickable() && !countDownScreen)
			{
				if (displayedButton[PAUSE].isHighlighted())
				{
					displayedButton[PAUSE].setHighlighted(false);
				}
				else if (!displayedButton[PAUSE].isHighlighted())
				{
					displayedButton[PAUSE].setHighlighted(true);
				}
			}
			//If exit is clicked go back to main menu (during a pause)
			if (xPosition > displayedButton[EXIT].getxPosition()
					&&xPosition < (displayedButton[EXIT].getxPosition()+displayedButton[EXIT].getWidth())
					&&yPosition > displayedButton[EXIT].getyPosition()
					&&yPosition < (displayedButton[EXIT].getyPosition()+displayedButton[EXIT].getHeight())
					&&displayedButton[EXIT].isClickable())
			{
				resetFruit();
				displayedButton[PAUSE].setHighlighted(false);
				displayedButton[PAUSE].setClickable(false);
				displayedButton[EXIT].setClickable(false);
				displayedButton[EXIT].setHighlighted(false);
				soundEffects[CLICK_SF].play();
				currentEvent=MAIN_MENU;
			}
		}
		if (currentEvent==OPTIONS)
		{
			//If white blade button is clicked, change blade to white
			if (xPosition > displayedButton[WHITEBLADE].getxPosition()
					&&xPosition < (displayedButton[WHITEBLADE].getxPosition()+displayedButton[WHITEBLADE].getWidth())
					&&yPosition > displayedButton[WHITEBLADE].getyPosition()
					&&yPosition < (displayedButton[WHITEBLADE].getyPosition()+displayedButton[WHITEBLADE].getHeight())
					&&displayedButton[WHITEBLADE].isClickable())
			{
				displayedButton[WHITEBLADE].setHighlighted(true);
				displayedButton[REDBLADE].setHighlighted(false);
				displayedButton[GREENBLADE].setHighlighted(false);
				gameScores.setSelectedBlade(WHITE_BLADE_VALUE);
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If red blade button is clicked, change blade to white
			else if (xPosition > displayedButton[REDBLADE].getxPosition()
					&&xPosition < (displayedButton[REDBLADE].getxPosition()+displayedButton[REDBLADE].getWidth())
					&&yPosition > displayedButton[REDBLADE].getyPosition()
					&&yPosition < (displayedButton[REDBLADE].getyPosition()+displayedButton[REDBLADE].getHeight())
					&&displayedButton[REDBLADE].isClickable())
			{
				displayedButton[WHITEBLADE].setHighlighted(false);
				displayedButton[REDBLADE].setHighlighted(true);
				displayedButton[GREENBLADE].setHighlighted(false);
				gameScores.setSelectedBlade(RED_BLADE_VALUE);
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If green blade button is clicked, change blade to white
			else if (xPosition > displayedButton[GREENBLADE].getxPosition()
					&&xPosition < (displayedButton[GREENBLADE].getxPosition()+displayedButton[GREENBLADE].getWidth())
					&&yPosition > displayedButton[GREENBLADE].getyPosition()
					&&yPosition < (displayedButton[GREENBLADE].getyPosition()+displayedButton[GREENBLADE].getHeight())
					&&displayedButton[GREENBLADE].isClickable())
			{
				displayedButton[WHITEBLADE].setHighlighted(false);
				displayedButton[REDBLADE].setHighlighted(false);
				displayedButton[GREENBLADE].setHighlighted(true);
				gameScores.setSelectedBlade(GREEN_BLADE_VALUE);
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the first song is clicked, change the song to that song (Jinjo Village)
			else if (xPosition > displayedButton[SONG1].getxPosition()
					&&xPosition < (displayedButton[SONG1].getxPosition()+displayedButton[SONG1].getWidth())
					&&yPosition > displayedButton[SONG1].getyPosition()
					&&yPosition < (displayedButton[SONG1].getyPosition()+displayedButton[SONG1].getHeight())
					&&displayedButton[SONG1].isClickable())
			{
				displayedButton[SONG1].setHighlighted(true);
				displayedButton[SONG2].setHighlighted(false);
				displayedButton[SONG3].setHighlighted(false);
				displayedButton[SONG4].setHighlighted(false);
				displayedButton[SONG0].setHighlighted(false);
				song[gameScores.getSelectedSong()].stop();
				gameScores.setSelectedSong(JINJO_VILLAGE);
				song[gameScores.getSelectedSong()].loop();
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the second song is clicked, change the song to that song (Can-Can)
			else if (xPosition > displayedButton[SONG2].getxPosition()
					&&xPosition < (displayedButton[SONG2].getxPosition()+displayedButton[SONG2].getWidth())
					&&yPosition > displayedButton[SONG2].getyPosition()
					&&yPosition < (displayedButton[SONG2].getyPosition()+displayedButton[SONG2].getHeight())
					&&displayedButton[SONG2].isClickable())
			{
				displayedButton[SONG1].setHighlighted(false);
				displayedButton[SONG2].setHighlighted(true);
				displayedButton[SONG3].setHighlighted(false);
				displayedButton[SONG4].setHighlighted(false);
				displayedButton[SONG0].setHighlighted(false);
				song[gameScores.getSelectedSong()].stop();
				gameScores.setSelectedSong(CAN_CAN);
				song[gameScores.getSelectedSong()].loop();
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the third song is clicked, change the song to that song (Love is in the Air)
			else if (xPosition > displayedButton[SONG3].getxPosition()
					&&xPosition < (displayedButton[SONG3].getxPosition()+displayedButton[SONG3].getWidth())
					&&yPosition > displayedButton[SONG3].getyPosition()
					&&yPosition < (displayedButton[SONG3].getyPosition()+displayedButton[SONG3].getHeight())
					&&displayedButton[SONG3].isClickable())
			{
				displayedButton[SONG1].setHighlighted(false);
				displayedButton[SONG2].setHighlighted(false);
				displayedButton[SONG3].setHighlighted(true);
				displayedButton[SONG4].setHighlighted(false);
				displayedButton[SONG0].setHighlighted(false);
				song[gameScores.getSelectedSong()].stop();
				gameScores.setSelectedSong(LOVE_IS_IN_THE_AIR);
				song[gameScores.getSelectedSong()].loop();
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the forth song is clicked, change the song to that song (Theme Song Yellow)
			else if (xPosition > displayedButton[SONG4].getxPosition()
					&&xPosition < (displayedButton[SONG4].getxPosition()+displayedButton[SONG4].getWidth())
					&&yPosition > displayedButton[SONG4].getyPosition()
					&&yPosition < (displayedButton[SONG4].getyPosition()+displayedButton[SONG4].getHeight())
					&&displayedButton[SONG4].isClickable())
			{
				displayedButton[SONG1].setHighlighted(false);
				displayedButton[SONG2].setHighlighted(false);
				displayedButton[SONG3].setHighlighted(false);
				displayedButton[SONG4].setHighlighted(true);
				displayedButton[SONG0].setHighlighted(false);
				song[gameScores.getSelectedSong()].stop();
				gameScores.setSelectedSong(THEME_SONG_YELLOW);
				song[gameScores.getSelectedSong()].loop();
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the zeroth song is clicked, change the song to that song (Click clock wood)
			else if (xPosition > displayedButton[SONG0].getxPosition()
					&&xPosition < (displayedButton[SONG0].getxPosition()+displayedButton[SONG0].getWidth())
					&&yPosition > displayedButton[SONG0].getyPosition()
					&&yPosition < (displayedButton[SONG0].getyPosition()+displayedButton[SONG0].getHeight())
					&&displayedButton[SONG0].isClickable())
			{
				displayedButton[SONG1].setHighlighted(false);
				displayedButton[SONG2].setHighlighted(false);
				displayedButton[SONG3].setHighlighted(false);
				displayedButton[SONG4].setHighlighted(false);
				displayedButton[SONG0].setHighlighted(true);
				song[gameScores.getSelectedSong()].stop();
				gameScores.setSelectedSong(CLICK_CLOCK_WOOD);
				song[gameScores.getSelectedSong()].loop();
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the first background is clicked, change it to that background
			else if (xPosition > displayedButton[BACKGROUND1].getxPosition()
					&&xPosition < (displayedButton[BACKGROUND1].getxPosition()+displayedButton[BACKGROUND1].getWidth())
					&&yPosition > displayedButton[BACKGROUND1].getyPosition()
					&&yPosition < (displayedButton[BACKGROUND1].getyPosition()+displayedButton[BACKGROUND1].getHeight())
					&&displayedButton[BACKGROUND1].isClickable())
			{
				displayedButton[BACKGROUND1].setHighlighted(true);
				displayedButton[BACKGROUND2].setHighlighted(false);
				displayedButton[BACKGROUND3].setHighlighted(false);
				displayedButton[BACKGROUND0].setHighlighted(false);
				gameScores.setSelectedBackground(BACKGROUND1_VALUE);	
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the second background is clicked, change it to that background
			else if (xPosition > displayedButton[BACKGROUND2].getxPosition()
					&&xPosition < (displayedButton[BACKGROUND2].getxPosition()+displayedButton[BACKGROUND2].getWidth())
					&&yPosition > displayedButton[BACKGROUND2].getyPosition()
					&&yPosition < (displayedButton[BACKGROUND2].getyPosition()+displayedButton[BACKGROUND2].getHeight())
					&&displayedButton[BACKGROUND2].isClickable())
			{
				displayedButton[BACKGROUND1].setHighlighted(false);
				displayedButton[BACKGROUND2].setHighlighted(true);
				displayedButton[BACKGROUND3].setHighlighted(false);
				displayedButton[BACKGROUND0].setHighlighted(false);
				gameScores.setSelectedBackground(BACKGROUND2_VALUE);	
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the third background is clicked, change it to that background
			else if (xPosition > displayedButton[BACKGROUND3].getxPosition()
					&&xPosition < (displayedButton[BACKGROUND3].getxPosition()+displayedButton[BACKGROUND3].getWidth())
					&&yPosition > displayedButton[BACKGROUND3].getyPosition()
					&&yPosition < (displayedButton[BACKGROUND3].getyPosition()+displayedButton[BACKGROUND3].getHeight())
					&&displayedButton[BACKGROUND3].isClickable())
			{
				displayedButton[BACKGROUND1].setHighlighted(false);
				displayedButton[BACKGROUND2].setHighlighted(false);
				displayedButton[BACKGROUND3].setHighlighted(true);
				displayedButton[BACKGROUND0].setHighlighted(false);
				gameScores.setSelectedBackground(BACKGROUND3_VALUE);	
				soundEffects[CLICK_SF].play();
				writeScores();
			}
			//If the zeroth background is clicked, change it to that background
			else if (xPosition > displayedButton[BACKGROUND0].getxPosition()
					&&xPosition < (displayedButton[BACKGROUND0].getxPosition()+displayedButton[BACKGROUND0].getWidth())
					&&yPosition > displayedButton[BACKGROUND0].getyPosition()
					&&yPosition < (displayedButton[BACKGROUND0].getyPosition()+displayedButton[BACKGROUND0].getHeight())
					&&displayedButton[BACKGROUND0].isClickable())
			{
				displayedButton[BACKGROUND1].setHighlighted(false);
				displayedButton[BACKGROUND2].setHighlighted(false);
				displayedButton[BACKGROUND3].setHighlighted(false);
				displayedButton[BACKGROUND0].setHighlighted(true);
				gameScores.setSelectedBackground(BACKGROUND0_VALUE);
				soundEffects[CLICK_SF].play();
				writeScores();
			}

		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) 
	{

	}

	public void mouseDragged (MouseEvent e)
	{
		//Places above x and y readings so can check for change in readings	
		if (currentEvent==DATABASE)
		{//Scrolls the database list if on darkened part and direction depends on direction scrolled
			if (xPosition<DATABASE_SCROLLER_MAX_X)
			{
				if (e.getY()>yPosition && databaseScrollerY <= DATABASE_SCROLLER_MAX_Y)
				{
					databaseScrollerY=databaseScrollerY+(e.getY()-yPosition);
					if (databaseScrollerY>DATABASE_SCROLLER_MAX_Y)
					{
						databaseScrollerY=DATABASE_SCROLLER_MAX_Y;
					}
				}
				else if (e.getY()<yPosition && databaseScrollerY >=DATABASE_SCROLLER_MIN_Y)
				{
					databaseScrollerY=databaseScrollerY+(e.getY()-yPosition);
					if (databaseScrollerY<DATABASE_SCROLLER_MIN_Y)
					{
						databaseScrollerY=DATABASE_SCROLLER_MIN_Y;
					}
				}
			}

		}
		else
		{
			//Draws blades if not paused and not in database
			if (!displayedButton[PAUSE].isHighlighted())
				blade.add(new Blade (xPosition, yPosition, getImage(base,"blade"+gameScores.getSelectedBlade()+".png")));
		}

		yPosition = e.getY ();
		xPosition = e.getX ();


		if (currentEvent == CLASSIC_MODE)
		{
			//checks to see if fruit are slashed during the game, not while paused or counting down
			if (!displayedButton[PAUSE].isHighlighted() && !countDownScreen)
			{
				for (int i=MIN_COUNTER; i<MAX_NUMBER_OF_FRUIT_ON_SCREEN; i++)
				{
					if (shownFruit[i]!=null){
						if (xPosition > shownFruit[i].getxPosition()
								&&xPosition < (shownFruit[i].getxPosition()+shownFruit[i].getWidth())
								&&yPosition > shownFruit[i].getyPosition()
								&&yPosition < (shownFruit[i].getyPosition()+shownFruit[i].getHeight()))
						{
							//Increase number of fruit on screen until at its max
							if (numberOfFruitOnScreen < MAX_NUMBER_OF_FRUIT_ON_SCREEN)
							{
								numberOfFruitOnScreen++;
							}
							//If player slashes the bad apple, ends the game
							if (shownFruit[i].getPicture()==defaultFruit[BAD_APPLE].getPicture())
							{
								currentEvent=GAME_OVER;
								if (gameScores.calculateHighScores(score))
									soundEffects[NEW_RECORD_SF].play();
								else
									soundEffects[GAME_SF].play();
								gameScores.calculateHighestCombo(highestComboScore);
								writeScores();
							}
							else
							{
								//If the fruit is not a bad apple, create the seed particles using random values
								seedCount = generator.nextInt(MAX_SEED_COUNT)+MIN_SEED_COUNT;
								for (int j=MIN_COUNTER; j<seedCount;j++)
								{
									seedHor=  generator.nextInt(MAX_SEED_HOR)+MIN_SEED_HOR;
									seedVer =  generator.nextInt(MAX_SEED_VER);
									seed.add(new Particle (shownFruit[i].getxPosition(), shownFruit[i].getyPosition()
											,shownFruit[i].getxMovement()+seedHor, shownFruit[i].getyMovement()-seedVer, seedPicture));
								}
								splash.add(new Splash (shownFruit[i].getxPosition(), shownFruit[i].getyPosition()
										,getImage(base,shownFruit[i].getFruitColour()+"1.png")
										,getImage(base,shownFruit[i].getFruitColour()+"2.png")
										,getImage(base,shownFruit[i].getFruitColour()+"3.png")));
								//Adds to the score and combo
								comboScore++;
								comboCounter=COMBO_COUNTER_MIN;
								score++;
							}
							shownFruit[i]=null;
							//plays the squish sound when fruit gets sliced
							currentSquish =  generator.nextInt(NUMBER_OF_SQUISH);
							squish[currentSquish].play();

						}
					}
				}
			}
		}
		if (currentEvent==MAIN_MENU)
		{
			for (int i=MIN_COUNTER; i<NUMBER_OF_MENU_OPTIONS; i++)
			{
				//Changes menu depending on which menu fruit was sliced
				if (xPosition > menuFruit[i].getxPosition()
						&&xPosition < (menuFruit[i].getxPosition()+menuFruit[i].getWidth())
						&&yPosition > menuFruit[i].getyPosition()
						&&yPosition < (menuFruit[i].getyPosition()+menuFruit[i].getHeight())
						&& meneFruitSlashable==true)
				{
					countDownScreen=true; //turns the count down screen on
					currentEvent=i; //changes menu depending on the fruit slashed
					soundEffects[i].play();
					seedCount = generator.nextInt(MAX_SEED_COUNT)+MIN_SEED_COUNT;
					for (int k=MIN_COUNTER; k <seedCount; k++)
					{
						seedHor=  generator.nextInt(MAX_SEED_HOR)+MIN_SEED_HOR;
						seedVer =  generator.nextInt(MAX_SEED_VER);
						seed.add(new Particle (menuFruit[i].getxPosition(), menuFruit[i].getyPosition()
								,menuFruit[i].getxMovement()+seedHor, menuFruit[i].getyMovement()-seedVer, seedPicture));
					}
					splash.add(new Splash (menuFruit[i].getxPosition(), menuFruit[i].getyPosition()
							,getImage(base,menuFruit[i].getFruitColour()+"1.png")
							,getImage(base,menuFruit[i].getFruitColour()+"2.png")
							,getImage(base,menuFruit[i].getFruitColour()+"3.png")));
					currentSquish =  generator.nextInt(NUMBER_OF_SQUISH);
					squish[currentSquish].play(); //plays a squish after fruit being cut
				}
			}
		}
	}


	public void mouseReleased(MouseEvent e) 
	{
		//auto locks scroller in place of closest fruit name
		if (currentEvent==DATABASE)
		{
			while (databaseScrollerY%DATABASE_NAME_SPACEING!=MIN_COUNTER)
			{
				if (databaseScrollerY%DATABASE_NAME_SPACEING>-DATABASE_NAME_SPACING_MID_VALUE)
					databaseScrollerY++;
				else
					databaseScrollerY--;
			}
		}
	}

	public void mouseMoved(MouseEvent e) {

		yPosition = e.getY ();
		xPosition = e.getX ();

		//Highlights done button if hovered over
		if (displayedButton[DONE].isClickable())
		{
			if (xPosition > displayedButton[DONE].getxPosition() 
					& xPosition < (displayedButton[DONE].getxPosition()+displayedButton[DONE].getWidth())
					& yPosition > displayedButton[DONE].getyPosition()
					& yPosition < (displayedButton[DONE].getyPosition()+displayedButton[DONE].getHeight()))
			{
				displayedButton[DONE].setHighlighted(true);
			}
			else
			{
				displayedButton[DONE].setHighlighted(false);
			}
		}
		//Highlights instruction button if hovered over
		if (displayedButton[INSTRUCTION_BUTTON].isClickable())
		{
			if (xPosition > displayedButton[INSTRUCTION_BUTTON].getxPosition() 
					& xPosition < (displayedButton[INSTRUCTION_BUTTON].getxPosition()+displayedButton[INSTRUCTION_BUTTON].getWidth())
					& yPosition > displayedButton[INSTRUCTION_BUTTON].getyPosition()
					& yPosition < (displayedButton[INSTRUCTION_BUTTON].getyPosition()+displayedButton[INSTRUCTION_BUTTON].getHeight()))
			{
				displayedButton[INSTRUCTION_BUTTON].setHighlighted(true);
			}
			else
			{
				displayedButton[INSTRUCTION_BUTTON].setHighlighted(false);
			}
		}
		//Highlights exit button if hovered over
		if (displayedButton[EXIT].isClickable())
		{
			if (xPosition > displayedButton[EXIT].getxPosition() 
					& xPosition < (displayedButton[EXIT].getxPosition()+displayedButton[EXIT].getWidth())
					& yPosition > displayedButton[EXIT].getyPosition()
					& yPosition < (displayedButton[EXIT].getyPosition()+displayedButton[EXIT].getHeight()))
			{
				displayedButton[EXIT].setHighlighted(true);
				repaint();
			}
			else
			{
				displayedButton[EXIT].setHighlighted(false);
				repaint();
			}
		}



	}

	//Clears all the fruit from the lists and resets all the variables for new game
	public void resetFruit()
	{
		for (int i = MIN_COUNTER; i < MAX_NUMBER_OF_FRUIT_ON_SCREEN; i++)
		{
			if (shownFruit[i]!=null)
			{
				shownFruit[i]=null;
			}
			numberOfFruitOnScreen=STARTING_NUMBER_OF_FRUIT;
			fallCount=MIN_COUNTER;
			score=MIN_COUNTER;
			comboScore=MIN_COUNTER;
			comboCounter=MIN_COUNTER;
			highestComboScore=MIN_COUNTER;
		}
	}

	//Reads the scores into a object
	public void readScores() {
		ObjectInputStream inputStream = null;
		try {
			// Construct the ObjectInputStream object
			inputStream = new ObjectInputStream(new FileInputStream(SAVE_FILE));

			gameScores = (Scores) inputStream.readObject();
			inputStream.close();
		} catch (EOFException ex) { // This exception will be caught when EOF is
			// reached
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			//ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	//Writes the scores to a file
	public void writeScores() {
		try {
			FileOutputStream f = new FileOutputStream(SAVE_FILE);
			ObjectOutputStream s = new ObjectOutputStream(f);
			s.writeObject(gameScores);
			s.close();
		} 
		catch (Exception e) {
		}
	} 



} // MainClass class
