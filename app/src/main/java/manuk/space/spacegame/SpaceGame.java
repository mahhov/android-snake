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
	private Paint paint;
	
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
		
		paint = new Paint();
		paint.setTextSize(40);
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
			canvas.drawRGB(128, 128, 128);
			
			rect(canvas, player.x - player.half, player.y - player.half, player.half * 2, player.half * 2, Color.WHITE);
			
			paint.setColor(Color.BLACK);
			canvas.drawRect(10, 10, 20, 20, paint);
			canvas.drawRect(width - 20, height - 20, width - 10, height - 10, paint);
			canvas.drawText(DEBUG, 0, height - 10, paint);
			surfaceHolder.unlockCanvasAndPost(canvas);
		}
	}
	
	private void rect(Canvas canvas, double x, double y, double width, double height, int color) {
		paint.setColor(color);
		float left = (float) (x * this.width);
		float top = (float) (y * this.height);
		float right = (float) (left + width * this.width);
		float bottom = (float) (top + height * this.height);
		canvas.drawRect(left, top, right, bottom, paint);
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
