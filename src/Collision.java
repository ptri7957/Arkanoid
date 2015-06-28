
public class Collision {
	
	int count = 0;
	
	public void collideWithPaddle(Paddle p, Ball b){
		float ballLeft = b.getX();
		float ballRight = b.getX() + b.getRadius() * 2;
		float ballTop = b.getY();
		float ballBottom = b.getY() + b.getRadius() * 2;

		float nextBallLeft = (float) (ballLeft + b.getXVel());
		float nextBallRight = (float) (ballRight + b.getXVel());
		float nextBallTop = (float) (ballTop + b.getYVel());
		float nextBallBottom = (float) (ballBottom + b.getYVel());
		
		float paddleLeft = p.getX();
		float paddleRight = p.getX() + p.getWidth();
		float paddleTop = p.getY();
		float paddleBottom = p.getY() + p.getHeight();
		
		if (b.collisionDetection(paddleLeft, paddleRight, paddleTop,
				paddleBottom, nextBallLeft, nextBallRight, ballTop, ballBottom)) {
			b.reflectX();
		}

		if (b.collisionDetection(paddleLeft, paddleRight, paddleTop,
				paddleBottom, ballLeft, ballRight, nextBallTop, nextBallBottom)) {
			b.reflectY();
		}
	}
	
	public void collideWithBrick(Brick br, Ball b){
		float ballLeft = b.getX();
		float ballRight = b.getX() + b.getRadius() * 2;
		float ballTop = b.getY();
		float ballBottom = b.getY() + b.getRadius() * 2;

		float nextBallLeft = (float) (ballLeft + b.getXVel());
		float nextBallRight = (float) (ballRight + b.getXVel());
		float nextBallTop = (float) (ballTop + b.getYVel());
		float nextBallBottom = (float) (ballBottom + b.getYVel());
		
		float boxLeft = br.getX();
		float boxRight = br.getX() + br.getWidth();
		float boxTop = br.getY();
		float boxBottom = br.getY() + br.getHeight();

		if (b.collisionDetection(boxLeft, boxRight, boxTop, boxBottom,
				nextBallLeft, nextBallRight, ballTop, ballBottom)) {
			b.reflectX();
			br.setHit();
		}

		if (b.collisionDetection(boxLeft, boxRight, boxTop, boxBottom,
				ballLeft, ballRight, nextBallTop, nextBallBottom)) {
			b.reflectY();
			br.setHit();
		}
		
		if (b.collisionDetection(boxLeft, boxRight, boxTop, boxBottom,
				ballLeft, ballRight, nextBallTop, nextBallBottom)
				|| b.collisionDetection(boxLeft, boxRight, boxTop,
						boxBottom, nextBallLeft, nextBallRight,
						ballTop, ballBottom)) {
			count++;
		}
	}
}
