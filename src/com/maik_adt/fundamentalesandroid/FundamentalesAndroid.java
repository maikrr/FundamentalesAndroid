package com.maik_adt.fundamentalesandroid;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FundamentalesAndroid extends ListActivity{
	
	private String pruebas[] = {"CicloDeVidaTest","ToqueSimpleTest","MultiToqueTest",
			"TeclasTest","AcelerometroTest","ActivosTest","AlmacenamientoExternoTest",
			"SonidoDePiscinaTest","ReproductorDeMediosTest","PantallaCompletaTest",
			"VistaDeRendimientoTest","FuenteTest","VistaDeSuperficieTest"};
	public void onCreate (Bundle savedInstanceState){
		super .onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,pruebas));
	}
	@Override
	protected void onListItemClick(ListView list,View view,int position,long id){
		super .onListItemClick(list, view, position, id);
		String nombrePrueba=pruebas[position];
		System.out.println("CADENA DEL STRING NOMBRE DE PRUEBA"+nombrePrueba);
		try {
			Class<?> clazz=Class.forName("com.maik_adt.fundamentalesandroid."+nombrePrueba);
			Intent intent=new Intent(this, clazz);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}