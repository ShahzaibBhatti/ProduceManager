//This class is responsible for creating option pictures which are movable 

import java.awt.Image;

public class optionPicture {
        
        private int xPosition;
        private int yPosition;
        private Image picture;
        private int movement;
        private final int NO_MOVEMENT=0;
        
        public optionPicture (int x, int y, Image pic)
        {
        	setxPosition(x);
        	setyPosition(y);
        	setPicture(pic);
        	setMovement(NO_MOVEMENT);
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

		public void setMovement(int movement) {
			this.movement = movement;
		}

		public int getMovement() {
			return movement;
		}

}
