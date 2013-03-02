package com.maik_adt.fundamentalesandroid;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MultiToqueTest extends Activity implements OnTouchListener{
	private StringBuilder builder=new StringBuilder();
	private TextView textView;
	private float[] x=new float[10];
	private float[] y=new float[10];
	private boolean[] tocado=new boolean[10];	
	private  void updateTextView(){
		builder.setLength(0);
		for(int i=0;i<10;i++){
			builder.append(tocado[i]);
			builder.append(", ");
			builder.append(x[i]);
			builder.append(", ");
			builder.append(y[i]);
			builder.append("\n");
		}
		textView.setText(builder.toString());
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView=new TextView(this);
		textView.setText("Toca y arrastra ¡(Soporta multiples dedos)!");
		textView.setOnTouchListener(this);
		setContentView(textView);
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int action=event.getAction() & MotionEvent.ACTION_MASK;
		int pointerIndex= (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;
		int pointerId= event.getPointerId(pointerIndex);		
		switch (action) {
			case MotionEvent.ACTION_DOWN:			
			case MotionEvent.ACTION_POINTER_DOWN:
				tocado[pointerId]= true;
				x[pointerId]=(int)event.getX(pointerIndex);
				y[pointerId]=(int)event.getY(pointerIndex);
				break;
			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_POINTER_UP:
			case MotionEvent.ACTION_CANCEL:
				tocado[pointerId]= false;
				x[pointerId]=(int)event.getX(pointerIndex);
				y[pointerId]=(int)event.getY(pointerIndex);
				break;
			case MotionEvent.ACTION_MOVE:
				int pointerCount=event.getPointerCount();
				for(int i=0;i<pointerCount;i++){
					pointerIndex=i;
					pointerId=event.getPointerId(pointerIndex);
					x[pointerId]=(int)event.getX(pointerIndex);
					y[pointerId]=(int)event.getY(pointerIndex);
				}
				break;
		}
		
		updateTextView();
		return true;
	}
}
