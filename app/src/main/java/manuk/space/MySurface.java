package manuk.space;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import manuk.space.spacegame.SpaceGame;

import static android.content.ContentValues.TAG;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {
	public MySurface(Context context, AttributeSet attrs) {
		super(context, attrs);
		SurfaceHolder surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
		new Thread(new SpaceGame(surfaceHolder)).start();
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
	}
	
	public void surfaceChanged(SurfaceHolder holder, int frmt, int w, int h) {
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
}