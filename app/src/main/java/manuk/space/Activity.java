package manuk.space;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Activity extends AppCompatActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
	}

	private ClickToWin game = new ClickToWin();

	public void clickWinButton(View v) {
		game.clicked();
		TextView status = (TextView) findViewById(R.id.fullscreen_content);
		status.setText(game.getWinState());
	}
}
