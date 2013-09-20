//This class is responsible for creating and removing the blades when the mouse is dragged based on a set duration

import java.awt.Image;

public class Blade {

	private int xPosition;
	private int yPosition;
	private Image picture;
	private int counter;
	private final int BLADE_DURATION=7;

	public Blade (int x, int y, Image pic)
	{
		setxPosition(x);
		setyPosition(y);
		setPicture(pic);
		setCounter(0);

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

	public void setPicture(Image picture) {
		this.picture = picture;
	}

	public Image getPicture() {
		return picture;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public int getBLADE_DURATION() {
		return BLADE_DURATION;
	}

}