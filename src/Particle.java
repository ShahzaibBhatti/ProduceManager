//This class is responsible for creating the seeds used in the game

import java.awt.Image;

public class Particle extends movingObject {

private Image picture;

public Particle (int x, int y, int h, int v, Image pic)
{
super (x,y,h,v);
        setPicture(pic);
}

public void setPicture(Image picture) {
        this.picture = picture;
}

public Image getPicture() {
        return picture;
}
}