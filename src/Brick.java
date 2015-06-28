
public class Brick {
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean isHit = false;
	private int count = 0;
	
	public Brick(){
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}
	
	public Brick(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
	
	public boolean getHit(){
		return isHit;
	}
	
	public int getCount(){
		return count;
	}
	
	public void setHit(){
		isHit = true;
		count++;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
}
