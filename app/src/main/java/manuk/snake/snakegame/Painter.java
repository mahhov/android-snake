package manuk.snake.snakegame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

class Painter {
	private Paint paint;
	private int width, height, shiftX, shiftY;
	private SurfaceHolder surfaceHolder;
	private Canvas canvas;
	
	Painter(int width, int height, int fullWidth, int fullHeight) {
		this.width = width;
		this.height = height;
		shiftX = (fullWidth - width) / 2;
		shiftY = (fullHeight - height) / 2;
		paint = new Paint();
		paint.setTextSize(40);
		paint.setTextAlign(Paint.Align.CENTER);
	}
	
	void prep(SurfaceHolder surfaceHolder) {
		this.surfaceHolder = surfaceHolder;
		canvas = surfaceHolder.lockCanvas();
		canvas.drawRGB(100, 100, 100);
		drawRect(0, 0, 1, 1, Color.BLACK);
	}
	
	void post() {
		surfaceHolder.unlockCanvasAndPost(canvas);
	}
	
	void drawRect(double x, double y, double width, double height, int color) {
		paint.setColor(color);
		float left = (float) (shiftX + x * this.width);
		float top = (float) (shiftY + y * this.height);
		float right = (float) (left + width * this.width);
		float bottom = (float) (top + height * this.height);
		canvas.drawRect(left, top, right, bottom, paint);
	}
	
	void drawText(String text, double x, double y, int color) {
		paint.setColor(color);
		float left = (float) (shiftX + x * this.width);
		float top = (float) (shiftY + y * this.height);
		canvas.drawText(text, left, top, paint);
	}
}
