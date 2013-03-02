package com.maik_adt.fundamentalesandroid;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;

public class TeclasTest extends Activity implements OnKeyListener{
	private StringBuilder builder= new StringBuilder();
	private TextView textView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Pulsa Teclas y observa el resultado en la Pantalla");
		textView.setOnKeyListener(this);
		textView.setFocusableInTouchMode(true);
		textView.requestFocus();
		setContentView(textView);
	}
	
	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		builder.setLength(0);
		switch (event.getAction()) {
			case KeyEvent.ACTION_DOWN:
				builder.append("down, ");			
			break;
			case KeyEvent.ACTION_UP:
				builder.append("up, ");
		}
		builder.append(event.getKeyCode());
		builder.append(", ");
		builder.append((char)event.getUnicodeChar());
		String text =builder.toString();
		Log.d("KeyTest", text);
		textView.setText(text);
		if(event.getKeyCode()==KeyEvent.KEYCODE_BACK)
			return false;
		else
			return true;
	}

}
