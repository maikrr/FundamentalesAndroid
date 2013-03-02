package com.maik_adt.fundamentalesandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
public class CicloDeVidaTest extends Activity {
	private StringBuilder builder = new StringBuilder();
	private TextView textView;

	private void log(String text){
		Log.d("CicloDeVidaTest", text);
		builder.append(text);
		builder.append('\n');
		textView.setText(builder.toString());
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView =new TextView(this);
		textView.setText(builder.toString());
		setContentView(textView);
		log("Creado...");
	}
	@Override
	protected void onResume() {
		super.onResume();
		log("resumed");
	}
	@Override
	protected void onPause() {
		super.onPause();
		log("Pausado");
		if(isFinishing()){
			log("Finalizado");
		}
	}
}
