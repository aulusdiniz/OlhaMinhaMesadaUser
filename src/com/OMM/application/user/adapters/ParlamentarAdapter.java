package com.OMM.application.user.adapters;

import java.util.List;

import com.OMM.application.user.pojo.ParlamentarPO;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ParlamentarAdapter extends BaseAdapter{

	private Context ctx;
	private List <ParlamentarPO>lista;
	
	
	public ParlamentarAdapter (Context ctx,List <ParlamentarPO> lista)
	{
		this.ctx=ctx;
		this.lista=lista;
	}
	@Override
	public int getCount() 
	{
	
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		/*
		 * Esse metedo recupeda os dados do banco, pega um xml que tem o layout 
		 * e transforma numa view dinamica, vc transforma o xml em um objeto
		 */
		
		ParlamentarPO po = (ParlamentarPO)getItem(position);
		
		LayoutInflater layout = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = layout.inflate(com.OMM.application.user.R.layout.gui_listagem, null);
		
		TextView PARLAMENTAR =(TextView) v.findViewById(com.OMM.application.user.R.id.textV_listar_nome);
		PARLAMENTAR.setText(po.getNome_parlamentar().toString());
		
				
		return v;
	}

}
