package com.maik_adt.fundamentalesandroid;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class ToqueSimpleTest extends Activity implements OnTouchListener{
	private StringBuilder builder=new StringBuilder();
	private TextView textView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView=new TextView(this);
		textView.setText("Toca y arrastra ¡(Un dedo Solamente)!");
		textView.setOnTouchListener(this);
		setContentView(textView);
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		builder.setLength(0);//limpiar el string builder
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				builder.append("down, ");
				break;
			case MotionEvent.ACTION_MOVE:
				builder.append("move, ");
				break;
			case MotionEvent.ACTION_CANCEL:
				builder.append("cancel, ");
				break;
			case MotionEvent.ACTION_UP:
				builder.append("up, ");
				break;
		}
		builder.append(event.getX());
		builder.append(", ");
		builder.append(event.getY());
		String text=builder.toString();
		Log.d("TouchTest", text);
		textView.setText(text);
		return true;
	}
}
