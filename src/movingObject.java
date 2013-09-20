//This class is responsible for handling information used by both the fruit and the seeds

		abstract class movingObject {
        
        private int xPosition;
        private int yPosition;
        private int xMovement;
        private int yMovement;
        
        public movingObject (int x, int y, int h, int v)
        {
                setxPosition(x);
                setyPosition(y);
                setxMovement(h);
                setyMovement(v);
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

        public void setxMovement(int xMovement) {
                this.xMovement = xMovement;
        }

        public int getxMovement() {
                return xMovement;
        }

        public void setyMovement(int yMovement) {
                this.yMovement = yMovement;
        }

        public int getyMovement() {
                return yMovement;
        }

}
