package com.maik_adt.fundamentalesandroid;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class AcelerometroTest extends Activity implements SensorEventListener {
	private StringBuilder builder=new StringBuilder();
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Gire el Equipo para habilitar el Acelerometro");						
		setContentView(textView);
		SensorManager manager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
		if(manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size()==0){
			textView.setText("No hay acelerometro instalado");
		}else{
			Sensor accelerometer=manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			if(!manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)){
				textView.setText("No se ah podido registrar el sensor listener");
			}
		}
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		builder.setLength(0);
		builder.append("x: ");
		builder.append(event.values[0]);
		builder.append(", y: ");
		builder.append(event.values[1]);
		builder.append(", z: ");
		builder.append(event.values[2]);		
		textView.setText(builder.toString());
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {		
	}
}
