package manuk.space.spacegame;

import android.graphics.Color;

class Player {
	double x, y;
	double half = .1;
	
	void draw(Painter painter) {
		painter.drawRect(x - half, y - half, half * 2, half * 2, Color.WHITE);
	}
}
