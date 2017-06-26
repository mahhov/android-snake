package manuk.space;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import manuk.space.spacegame.Controller;
import manuk.space.spacegame.SpaceGame;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {
	Controller controller;
	
	public MySurface(Context context, AttributeSet attrs) {
		super(context, attrs);
		SurfaceHolder surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
		controller = new Controller();
		setOnTouchListener(controller);
		new Thread(new SpaceGame(surfaceHolder, controller)).start();
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
	}
	
	public void surfaceChanged(SurfaceHolder holder, int frmt, int w, int h) {
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
}