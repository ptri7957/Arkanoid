
public class Paddle {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private double xVel;
	
	public Paddle(int x, int y, int width, int height, double xVel){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.xVel = xVel;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public double getXVel(){
		return xVel;
	}
	
	public void moveRight(double xVel){
		if(x <= 640){
			x += xVel;
		}
	}
	
	public void moveLeft(double xVel){
		if(x >= 0){
			x -= xVel;
		}
	}
	
	public void move(int x, double vel){
		while(this.x > x && this.x >= 0){
			this.x -= vel;
		}
		
		while(this.x < x && this.x + width <= 640){
			this.x += vel;	
		}
	}
}
