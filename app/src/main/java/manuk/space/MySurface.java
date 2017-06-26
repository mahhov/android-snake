package manuk.space;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import manuk.space.spacegame.Controller;
import manuk.space.spacegame.SpaceGame;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {
	SpaceGame spaceGame;
	
	public MySurface(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
	}
	
	public void surfaceCreated(SurfaceHolder surfaceHolder) {
		Canvas canvas = surfaceHolder.lockCanvas();
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		Controller controller = new Controller(width, height);
		setOnTouchListener(controller);
		spaceGame = new SpaceGame(surfaceHolder, controller, width, height);
		new Thread(spaceGame).start();
		surfaceHolder.unlockCanvasAndPost(canvas);
	}
	
	public void surfaceChanged(SurfaceHolder surfaceHolder, int frmt, int w, int h) {
	}
	
	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
		if (spaceGame != null)
			spaceGame.stop();
	}
}