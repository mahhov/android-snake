package manuk.space.spacegame;

import android.view.MotionEvent;
import android.view.View;

public class Controller implements View.OnTouchListener {
	public boolean touch;
	public float touchX, touchY;
	
	public boolean onTouch(View v, MotionEvent event) {
		touchX = event.getX();
		touchY = event.getY();
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
