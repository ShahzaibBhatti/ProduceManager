//This class is responsible for creating and removing the splashes on the screen

import java.awt.Image;


public class Splash
{
	private int xPosition;
	private int yPosition;
	final private int DURATION=50;
	private int durationCount;
	private int currentStage;
	final private int NUMBER_OF_SPLASHES=3;
	private Image [] picture = new Image [NUMBER_OF_SPLASHES];

	public Splash (int x, int y,Image pic1,Image pic2,Image pic3)
	{
		setxPosition(x);
		setyPosition(y);
		picture[0]=pic1;
		picture[1]=pic2;
		picture[2]=pic3;
		setDurationCount(0);
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public int getDURATION() {
		return DURATION;
	}

	public void setCurrentStage(int currentStage) {
		this.currentStage = currentStage;
	}

	public int getCurrentStage() {
		return currentStage;
	}

	public Image getPicture()
	{
		return picture[currentStage];
	}

	public void setDurationCount(int durationCount) {
		this.durationCount = durationCount;
	}

	public int getDurationCount() {
		return durationCount;
	}

}
