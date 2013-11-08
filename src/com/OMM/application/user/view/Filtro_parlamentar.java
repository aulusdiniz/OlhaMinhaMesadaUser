package com.OMM.application.user.view;

import com.OMM.application.user.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Filtro_parlamentar extends Activity {
	
	
	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_list_parlamentar);
		Button btn_filtrar=(Button)findViewById(R.id.btn_busca_parlamentar);
		final EditText pesquisar=(EditText)findViewById(R.id.editT_buscar_parlamentar);
		
		btn_filtrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				setResult(RESULT_OK,new Intent().putExtra("txt",pesquisar.getText().toString().toUpperCase()));
				finish();
				
			}
		});
	}
	
	

}
