package manuk.snake.snakegame;

import android.view.SurfaceHolder;

public class SnakeGame implements Runnable {
	private boolean running = true;
	private SurfaceHolder surfaceHolder;
	
	static final int WIDTH = 20, HEIGHT = 20;
	static final double BLOCK_WIDTH = 1. / WIDTH, BLOCK_HEIGHT = 1. / HEIGHT;
	private Painter painter;
	private Controller controller;
	private Snake snake;
	
	public SnakeGame(SurfaceHolder surfaceHolder, Controller controller, int width, int height) {
		this.surfaceHolder = surfaceHolder;
		painter = new Painter(width, width, width, height);
		this.controller = controller;
		snake = new Snake();
	}
	
	private void update() {
		if (controller.getTouch()) {
			double threshold = .1;
			boolean centerX = controller.touchX > threshold && controller.touchX < 1 - threshold;
			boolean centerY = controller.touchY > threshold && controller.touchY < 1 - threshold;
			if (controller.touchX < threshold && centerY)
				snake.setDirection(Snake.LEFT);
			else if (controller.touchX > 1 - threshold && centerY)
				snake.setDirection(Snake.RIGHT);
			else if (controller.touchY < threshold && centerX)
				snake.setDirection(Snake.UP);
			else if (controller.touchY > 1 - threshold && centerX)
				snake.setDirection(Snake.DOWN);
		}
		snake.update();
	}
	
	private void draw() {
		painter.prep(surfaceHolder);
		snake.draw(painter);
		painter.post();
	}
	
	private void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		running = true;
		while (running) {
			update();
			draw();
			sleep(100);
		}
	}
	
	public void stop() {
		running = false;
	}
}
