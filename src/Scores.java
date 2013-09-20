//This class is responsible for storing the scores and saved data in the game

import java.io.Serializable;

public class Scores implements Serializable  
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1216535603347455781L;
	private int selectedBackground=0;
	private int selectedSong=0;
	private int selectedBlade=0;
	final private int HIGH_SCORES_SAVED=3;
	private int[] highScores = new int [HIGH_SCORES_SAVED];
	private int highestCombo;
	private final int FIRST_SCORE=0;
	private final int SECOND_SCORE=1;
	private final int THIRD_SCORE=2;

public Scores()
{
}

	public   void setSelectedBackground(int selectedBackground) {
		this.selectedBackground = selectedBackground;
	}

	public   int getSelectedBackground() {
		return selectedBackground;
	}

	public   void setSelectedSong(int selectedSong) {
		this.selectedSong = selectedSong;
	}

	public   int getSelectedSong() {
		return selectedSong;
	}

	public   void setSelectedBlade(int selectedBlade) {
		this.selectedBlade = selectedBlade;
	}

	public   int getSelectedBlade() {
		return selectedBlade;
	}

	public   void calculateHighestCombo(int newCombo) {
		if (newCombo>highestCombo)
		{
			highestCombo=newCombo;
		}
	}

	public   int getHighestCombo() {
		return highestCombo;
	}

	public   boolean calculateHighScores(int newScore) {
		if (newScore> highScores[FIRST_SCORE])
		{
			highScores[THIRD_SCORE]=highScores[SECOND_SCORE];
			highScores[SECOND_SCORE]=highScores[FIRST_SCORE];
			highScores[FIRST_SCORE]=newScore;
			return true;
		}
		else if (newScore>highScores[SECOND_SCORE])
		{
			highScores[THIRD_SCORE]=highScores[SECOND_SCORE];
			highScores[SECOND_SCORE]=newScore;
			return true;
		}
		else if (newScore>highScores[THIRD_SCORE])
		{
			highScores[THIRD_SCORE]=newScore;
			return true;
		}
		return false;
	}

	public   int getHighScores1() {
		return highScores[FIRST_SCORE];
	}
	public   int getHighScores2() {
		return highScores[SECOND_SCORE];
	}
	public   int getHighScores3() {
		return highScores[THIRD_SCORE];
	}

}