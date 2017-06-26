package manuk.space.spacegame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import static manuk.space.spacegame.SpaceGame.DEBUG;

class Painter {
	private Paint paint;
	private int width, height;
	private SurfaceHolder surfaceHolder;
	private Canvas canvas;
	
	Painter(int width, int height) {
		this.width = width;
		this.height = height;
		paint = new Paint();
		paint.setTextSize(40);
	}
	
	void prep(SurfaceHolder surfaceHolder) {
		this.surfaceHolder = surfaceHolder;
		canvas = surfaceHolder.lockCanvas();
		if (canvas != null) {
			canvas.drawRGB(128, 128, 128);
			paint.setColor(Color.BLACK);
			canvas.drawRect(10, 10, 20, 20, paint);
			canvas.drawRect(width - 20, height - 20, width - 10, height - 10, paint);
			canvas.drawText(DEBUG, 0, height - 10, paint);
		}
	}
	
	void post() {
		surfaceHolder.unlockCanvasAndPost(canvas);
	}
	
	void drawRect(double x, double y, double width, double height, int color) {
		paint.setColor(color);
		float left = (float) (x * this.width);
		float top = (float) (y * this.height);
		float right = (float) (left + width * this.width);
		float bottom = (float) (top + height * this.height);
		canvas.drawRect(left, top, right, bottom, paint);
	}
}
