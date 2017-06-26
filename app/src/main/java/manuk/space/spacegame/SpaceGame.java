package manuk.space.spacegame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class SpaceGame implements Runnable {
	public static String DEBUG = "debug string";
	
	private SurfaceHolder surfaceHolder;
	private Controller controller;
	private Player player;
	private LList<Projectile> projectile;
	private int x;
	
	public SpaceGame(SurfaceHolder surfaceHolder, Controller controller) {
		this.surfaceHolder = surfaceHolder;
		this.controller = controller;
		player = new Player();
		projectile = new LList<>();
	}
	
	private void update() {
		if (controller.touch)
			x--;
		else
			x++;
		if (x == 1000)
			x = 0;
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
			canvas.drawRect(100 + x, 100, 200 + x, 200, myPaint);
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
		while (true) {
			update();
			draw();
			sleep(10);
		}
	}
}
