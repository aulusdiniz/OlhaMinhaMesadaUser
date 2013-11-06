package com.OMM.application.user.view;



import com.OMM.application.user.adapters.ParlamentarAdapter;
import com.OMM.application.user.dao.ParlamentarUserDao;
import com.OMM.application.user.pojo.ParlamentarPO;


import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class GuiBuscarParlamentar extends ListActivity {
	
	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ParlamentarUserDao dao = new ParlamentarUserDao(getBaseContext());
		setListAdapter(new ParlamentarAdapter(getBaseContext(), dao.getAll()));
		
				
	}
	@Override
	 protected void onListItemClick(ListView l, View v, int position, long id){
		/*
		 * Dessa forma voce consegue fazer passagens de paramentros dentro da aplicacao
		 * 
		 */
		ParlamentarPO po= (ParlamentarPO)l.getAdapter().getItem(position);// aqui eu digo em que item usuario clicou
		Toast.makeText(getBaseContext(),"Cod do parlamentar:"+po.getCod_parlamentar().toString(), Toast.LENGTH_SHORT).show();
	}
	

}
