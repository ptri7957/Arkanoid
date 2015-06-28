public class Ball {

	private int x;
	private int y;
	private double xVel;
	private double yVel;
	private int radius;
	private boolean pause = false;

	public Ball(int x, int y, double xVel, double yVel, int radius) {
		this.x = x;
		this.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
		this.radius = radius;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getXVel() {
		return xVel;
	}

	public double getYVel() {
		return yVel;
	}

	public int getRadius() {
		return radius;
	}
	
	public boolean getPause(){
		return pause;
	}
	
	public void setPause(){
		pause = true;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXVel(double xVel) {
		this.xVel = xVel;
	}

	public void setYVel(double yVel) {
		this.yVel = yVel;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void reflectX(){
		xVel *= -1;
	}
	
	public void reflectY(){
		yVel *= -1;
	}
	
	boolean collisionDetection(float aBoxLeft, float aBoxRight, float aBoxTop,
			float aBoxBottom, float bBoxLeft, float bBoxRight, float bBoxTop,
			float bBoxBottom) {
		return bBoxRight >= aBoxLeft && bBoxBottom >= aBoxTop
				&& aBoxRight >= bBoxLeft && aBoxBottom >= bBoxTop;
	}

	public void move() {
		x += xVel;
		y += yVel;

		if (x < 0 || x > 640) {
			xVel *= -1;
		}

		if (y < 0) {
			yVel *= -1;
		}
		
		if(y > 480){
			pause = true;
		}
	}
}
