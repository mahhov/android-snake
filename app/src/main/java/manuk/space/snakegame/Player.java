package manuk.space.snakegame;

import android.graphics.Color;

import static android.R.attr.headerBackground;
import static android.R.attr.width;
import static manuk.space.snakegame.SnakeGame.BLOCK_HEIGHT;
import static manuk.space.snakegame.SnakeGame.BLOCK_WIDTH;

class Player {
	static final int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;
	static final int[] OPPOSITE = new int[] {RIGHT, LEFT, DOWN, UP};
	private int direction;
	private int x, y;
	private LList<Pos> pos;
	private int size;
	
	Player() {
		direction = LEFT;
		size = 10;
		pos = new LList<>();
		for (x = 0; x < size; x++)
			pos.add(new Pos(x, y));
	}
	
	void setDirection(int direction) {
		if (direction != OPPOSITE[this.direction])
			this.direction = direction;
	}
	
	void update() {
		switch (direction) {
			case LEFT:
				if (--x < 0)
					x = SnakeGame.WIDTH - 1;
				break;
			case RIGHT:
				if (++x == SnakeGame.WIDTH)
					x = 0;
				break;
			case UP:
				if (--y < 0)
					y = SnakeGame.HEIGHT - 1;
				break;
			case DOWN:
				if (++y == SnakeGame.HEIGHT)
					y = 0;
				break;
		}
		pos.removeTail();
		pos.add(new Pos(x, y));
	}
	
	void draw(Painter painter) {
		for (Pos p : pos)
			painter.drawRect(p.x * BLOCK_WIDTH, p.y * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT, Color.WHITE);
	}
	
	private class Pos {
		private int x, y;
		
		private Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}