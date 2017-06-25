package manuk.space;

public class ClickToWin {
	private boolean win;

	public void clicked() {
		win = !win;
	}

	public String getWinState() {
		return win ? "YOU HAVE WON!!!" : "SORRY UR A LOSER";
	}
}
