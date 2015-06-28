import processing.core.PApplet;
import java.io.*;

/**
 * @author PHILLIP
 *
 */
public class Arkanoid extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Ball b;
	Paddle p;
	Brick[] level1;
	Brick[] level2;
	Brick[] level3;
	Brick[][] levels;
	Collision c;
	int count = 0;
	int level = 0;

	boolean start = false;
	boolean win = false;

	public void setup() {
		size(640, 480);

		b = new Ball(60, 420, 8, -10, 6);
		p = new Paddle(320, 460, 70, 10, 5);
		c = new Collision();
		levels = new Brick[3][];

		// Level 1
		try {
			// Read in file to determine placement and size of bricks
			InputStream in = Arkanoid.class.getResourceAsStream("Level 1.txt");
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			String line = input.readLine();
			level1 = new Brick[Integer.parseInt(line)];

			for (int i = 0; i < level1.length; i++) {
				level1[i] = new Brick();
			}

			// While going through the input, assign the bricks its features
			while ((line = input.readLine()) != null) {

				String[] container = line.split(" ");

				int j = 1;
				if (container[0].equals("x:")) {
					for (int i = 0; i < level1.length; i++) {
						level1[i].setX(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("y:")) {
					for (int i = 0; i < level1.length; i++) {
						level1[i].setY(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("width:")) {
					for (int i = 0; i < level1.length; i++) {
						level1[i].setWidth(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("height:")) {
					for (int i = 0; i < level1.length; i++) {
						level1[i].setHeight(Integer.parseInt(container[j]));
						j++;
					}
				}

			}

		} catch (NumberFormatException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		// Level 2
		try {
			// Read in file to determine placement and size of bricks
			InputStream in = Arkanoid.class.getResourceAsStream("Level 2.txt");
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			String line = input.readLine();
			level2 = new Brick[Integer.parseInt(line)];

			for (int i = 0; i < level2.length; i++) {
				level2[i] = new Brick();
			}

			// While going through the input, assign the bricks its features
			while ((line = input.readLine()) != null) {

				String[] container = line.split(" ");

				int j = 1;
				if (container[0].equals("x:")) {
					for (int i = 0; i < level2.length; i++) {
						level2[i].setX(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("y:")) {
					for (int i = 0; i < level2.length; i++) {
						level2[i].setY(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("width:")) {
					for (int i = 0; i < level2.length; i++) {
						level2[i].setWidth(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("height:")) {
					for (int i = 0; i < level2.length; i++) {
						level2[i].setHeight(Integer.parseInt(container[j]));
						j++;
					}
				}

			}

		} catch (NumberFormatException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		// Level 3
		try {
			// Read in file to determine placement and size of bricks
			InputStream in = Arkanoid.class.getResourceAsStream("Level 3.txt");
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			String line = input.readLine();
			level3 = new Brick[Integer.parseInt(line)];

			for (int i = 0; i < level3.length; i++) {
				level3[i] = new Brick();
			}

			// While going through the input, assign the bricks its features
			while ((line = input.readLine()) != null) {

				String[] container = line.split(" ");

				int j = 1;
				if (container[0].equals("x:")) {
					for (int i = 0; i < level3.length; i++) {
						level3[i].setX(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("y:")) {
					for (int i = 0; i < level3.length; i++) {
						level3[i].setY(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("width:")) {
					for (int i = 0; i < level3.length; i++) {
						level3[i].setWidth(Integer.parseInt(container[j]));
						j++;
					}
				} else if (container[0].equals("height:")) {
					for (int i = 0; i < level3.length; i++) {
						level3[i].setHeight(Integer.parseInt(container[j]));
						j++;
					}
				}

			}

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// Add each individual level to levels
		levels[0] = level1;
		levels[1] = level2;
		levels[2] = level3;
	}

	public void draw() {

		background(0);

		// For debugging
		// text(Integer.toString(count), 225, 240);
		// textSize(20);

		// Move the ball only when the game has
		// started
		if (start) {
			b.move();
			ellipse(b.getX(), b.getY(), b.getRadius() * 2, b.getRadius() * 2);
		} else {
			text("Press Space to Start", 225, 240);
			textSize(20);
		}

		// If the game is paused, reset ball position
		if (b.getPause()) {
			start = false;
			b = new Ball(60, 420, 8, -10, 6);
		}

		// Draw the paddle
		rect(p.getX(), p.getY(), p.getWidth(), p.getHeight());

		c.collideWithPaddle(p, b);

		// Brick collision
		for (int i = 0; i < levels[level].length; i++) {
			if (!levels[level][i].getHit()) {

				rect(levels[level][i].getX(), levels[level][i].getY(),
						levels[level][i].getWidth(),
						levels[level][i].getHeight());

				c.collideWithBrick(levels[level][i], b);
			}
		}

		// Stop the game if all the bricks
		// have been destroyed
		if (c.count >= levels[level].length) {
			b.setPause();
			win = true;
			c.count = 0;
			if (level < 2) {
				level++;
			}
		}

	}

	// Catches keypress event
	public void keyPressed() {
		if (keyCode == LEFT) {
			p.moveLeft(p.getXVel());
		}

		if (keyCode == RIGHT) {
			p.moveRight(p.getXVel());
		}

		if (key == ' ') {
			start = true;
		}
	}

	// Catches mouse drag event
	public void mouseDragged() {
		p.move(mouseX, p.getXVel());
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Arkanoid.class.getName() });
	}

}
