package manuk.space.spacegame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import static android.R.attr.x;

public class SpaceGame implements Runnable {
	public static String DEBUG = "debug string";
	private boolean running = true;
	private int width, height;
	
	private SurfaceHolder surfaceHolder;
	private Controller controller;
	private Player player;
	private LList<Projectile> projectile;
	
	public SpaceGame(SurfaceHolder surfaceHolder, Controller controller, int width, int height) {
		this.width = width;
		this.height = height;
		this.surfaceHolder = surfaceHolder;
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
		Canvas canvas = surfaceHolder.lockCanvas();
		if (canvas != null) {
			int width = canvas.getWidth();
			int height = canvas.getHeight();
			
			int y = (int) (Math.random() * 20) + 100;
			canvas.drawRGB(0, 128, y);
			
			Paint myPaint = new Paint();
			myPaint.setColor(Color.rgb(0, 0, 0));
			myPaint.setStrokeWidth(10);
			canvas.drawRect(100, 100, 200, 200, myPaint);
			canvas.drawRect(10, 10, 20, 20, myPaint);
			canvas.drawRect(canvas.getWidth() - 20, canvas.getHeight() - 20, canvas.getWidth() - 10, canvas.getHeight() - 10, myPaint);
			
			myPaint.setTextSize(40);
			canvas.drawText(DEBUG, 0, height - 10, myPaint);
			
			surfaceHolder.unlockCanvasAndPost(canvas);
		}
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
