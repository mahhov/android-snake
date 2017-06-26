package manuk.space.spacegame;

import android.view.MotionEvent;
import android.view.View;

public class Controller implements View.OnTouchListener {
	private int width, height;
	boolean touch;
	double touchX, touchY;
	
	public Controller(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public boolean onTouch(View v, MotionEvent event) {
		if (width == 0)
			return false;
		touchX = event.getX() / width;
		touchY = event.getY() / height;
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
			case MotionEvent.ACTION_MOVE:
				touch = true;
				break;
			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_CANCEL:
			case MotionEvent.ACTION_OUTSIDE:
				touch = false;
				break;
		}
		return true;
	}
}
