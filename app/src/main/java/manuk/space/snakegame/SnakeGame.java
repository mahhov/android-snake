package manuk.space.snakegame;

import android.view.SurfaceHolder;

public class SnakeGame implements Runnable {
	static String DEBUG = "debug string";
	private boolean running = true;
	private SurfaceHolder surfaceHolder;
	
	static final int WIDTH = 20, HEIGHT = 20;
	static final double BLOCK_WIDTH = 1. / WIDTH, BLOCK_HEIGHT = 1. / HEIGHT;
	private Painter painter;
	private Controller controller;
	private Player player;
	
	public SnakeGame(SurfaceHolder surfaceHolder, Controller controller, int width, int height) {
		this.surfaceHolder = surfaceHolder;
		painter = new Painter(width, height);
		this.controller = controller;
		player = new Player();
	}
	
	private void update() {
		if (controller.touch) {
			double threshold = .1;
			boolean centerX = controller.touchX > threshold && controller.touchX < 1 - threshold;
			boolean centerY = controller.touchY > threshold && controller.touchY < 1 - threshold;
			if (controller.touchX < threshold && centerY)
				player.setDirection(Player.LEFT);
			else if (controller.touchX > 1 - threshold && centerY)
				player.setDirection(Player.RIGHT);
			else if (controller.touchY < threshold && centerX)
				player.setDirection(Player.UP);
			else if (controller.touchY > 1 - threshold && centerX)
				player.setDirection(Player.DOWN);
			DEBUG = controller.touchX + " " + controller.touchY;
		}
		player.update();
	}
	
	private void draw() {
		painter.prep(surfaceHolder);
		player.draw(painter);
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
			sleep(10);
		}
	}
	
	public void stop() {
		running = false;
	}
}
