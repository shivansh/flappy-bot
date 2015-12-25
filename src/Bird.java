
public class Bird {
	
	private int centerX = 100;
	private int centerY = 200;
	private boolean jumped = false;
	private int MOVESPEED = 5;
	
	 private static background bg1 = Flappy.getBg1();                 
     private static background bg2 = Flappy.getBg2();
	
	public boolean isJumped() {
		return jumped;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	public void update() {
		bg1.setSpeedX(-MOVESPEED);
		bg2.setSpeedX(-MOVESPEED);
	}

}
