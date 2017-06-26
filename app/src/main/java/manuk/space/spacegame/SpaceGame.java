package manuk.space.spacegame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class SpaceGame implements Runnable {
	SurfaceHolder surfaceHolder;
	private Controller controller;
	private Player player;
	private LList<Projectile> projectile;
	private int x;
	
	public SpaceGame(SurfaceHolder surfaceHolder) {
		this.surfaceHolder = surfaceHolder;
		controller = new Controller();
		player = new Player();
		projectile = new LList<>();
	}
	
	private void update() {
		x++;
		if (x == 1000)
			x = 0;
	}
	
	private void draw() {
		Canvas canvas = surfaceHolder.lockCanvas();
		if (canvas != null) {
			
			int y = (int) (Math.random() * 20) + 100;
			canvas.drawRGB(0, 128, y);
			
			Paint myPaint = new Paint();
			myPaint.setColor(Color.rgb(0, 0, 0));
			myPaint.setStrokeWidth(10);
			canvas.drawRect(100 + x, 100, 200 + x, 200, myPaint);
			
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
