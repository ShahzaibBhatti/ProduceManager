//This class is responsible for creating the fruit used in the game

import java.awt.*;
import java.awt.image.ImageObserver;


class Fruit extends movingObject implements ImageObserver {

	private String fruitColour;
	private int width;
	private int height;
	private Image picture;


	public Fruit (String colour, int x, int y, int h, 
			int v, Image pic)
	{
		super(x,y,h,v);
		setFruitColour(colour);
		setPicture (pic);
		setWidth();
		setHeight();
		
	}
	
	public Fruit (String colour, int x, int y, int h,
			int v, int wid, int hei, Image pic)
	{
		super(x,y,h,v);
		setFruitColour(colour);
		setPicture (pic);
		setWidth(wid);
		setHeight(hei);
		
	}

	public Fruit (String colour, Image pic)
	{
		super(0,0,0,0); //Allows for creating a constructor because super required
		setFruitColour(colour);
		setPicture (pic);
		setWidth();
		setHeight();
	} 


	public void setPicture(Image picture) {
		this.picture = picture;
	}
	public Image getPicture() {
		return picture;
	}
	public void setFruitColour(String fruitColour) {
		this.fruitColour = fruitColour;
	}
	public String getFruitColour() {
		return fruitColour;
	}
	public void setWidth() {
		width = this.getPicture().getWidth(this);
	}
	public void setWidth(int w) {
		width= w;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight() {
		height = this.getPicture().getHeight(this);
	}
	public void setHeight(int h) {
		height =h;
	}
	public int getHeight() {
		return height;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		return false;
	}


}
