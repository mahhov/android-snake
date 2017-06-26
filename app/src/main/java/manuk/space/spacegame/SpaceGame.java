package manuk.space.spacegame;

import android.view.SurfaceHolder;

public class SpaceGame implements Runnable {
	public static String DEBUG = "debug string";
	private boolean running = true;
	private SurfaceHolder surfaceHolder;
	
	private Painter painter;
	private Controller controller;
	private Player player;
	private LList<Projectile> projectile;
	
	public SpaceGame(SurfaceHolder surfaceHolder, Controller controller, int width, int height) {
		this.surfaceHolder = surfaceHolder;
		painter = new Painter(width, height);
		this.controller = controller;
		player = new Player();
		projectile = new LList<>();
	}
	
	private void update() {
		if (controller.touch) {
			player.x = controller.touchX;
			player.y = controller.touchY;
			DEBUG = player.x + " " + player.y;
		}
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
