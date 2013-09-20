//This class is responsible for creating objects that are clickable images, with a highlighted version and a result by clicking

import java.awt.*;
import java.awt.image.ImageObserver;


public class clickablePicture extends optionPicture implements ImageObserver {
	

	private Image clickedVersion;
	private int width;
	private int height;
	private boolean highlighted;
	private boolean clickable;
	
	public clickablePicture(int x, int y,int w, int h, Image pic, Image pic2) 
	{
		super(x, y, pic);
		setClickedVersion(pic2);
		setWidth(w);
		setHeight(h);
		setClickable(false);
		setHighlighted(false);
		
	}

	public void setClickedVersion(Image clickedVersion) {
		this.clickedVersion = clickedVersion;
	}

	public Image getClickedVersion() {
		return clickedVersion;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public boolean isHighlighted() {
		return highlighted;
	}

	public void setClickable(boolean clickable) {
		this.clickable = clickable;
	}

	public boolean isClickable() {
		return clickable;
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}

}
