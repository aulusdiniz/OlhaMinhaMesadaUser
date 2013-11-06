package com.OMM.application.user.dao;

import java.util.ArrayList;
import java.util.List;

import com.OMM.application.user.helper.DB;
import com.OMM.application.user.pojo.ParlamentarPO;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ParlamentarUserDao {
	
	private static String nome_tabela="PARLAMENTAR";
	private static Context context;
	private static String[] colunas={"ID_PARLAMENTAR,NOME_PARLAMENTAR"};
	
	
	public boolean insert(ParlamentarPO po)
{
	SQLiteDatabase db=new DB(context).getWritableDatabase();
	ContentValues ctv = new ContentValues();
	
	ctv.put("ID_PARLAMENTAR", po.getCod_parlamentar().toString());
	ctv.put("NOME_PARLAMENTAR", po.getNome_parlamentar().toString());
		
	return (db.insert(nome_tabela,null, ctv)>0);
}
	
	public boolean delete(ParlamentarPO po){
	SQLiteDatabase db=new DB(context).getWritableDatabase();
	return(db.delete(nome_tabela,"ID_PARLAMENTAR=?",new String[]{po.getCod_parlamentar().toString()})>0);
	}
	
	public boolean update(ParlamentarPO po){
	SQLiteDatabase db= new DB(context).getWritableDatabase();
	ContentValues ctv = new ContentValues();
	
	ctv.put("ID_PARLAMENTAR", po.getCod_parlamentar());
	ctv.put("NOME_PARLAMENTAR", po.getNome_parlamentar());
	
	return(	db.update(nome_tabela, ctv, "ID_PARLAMENTAR=?", new String[]{po.getCod_parlamentar().toString()})>0);

	}
	
	
	
	public ParlamentarUserDao(Context context)
	{
		this.context=context;
	}
	
	public ParlamentarPO getById(Integer ID_PARLAMENTAR)
	{
		SQLiteDatabase db= new DB(context).getReadableDatabase();
		
		Cursor rs= db.query(nome_tabela, colunas, "ID_PARLAMENTAR=?",new String[]{ID_PARLAMENTAR.toString()},null,null,null);
		
		ParlamentarPO po=null;
		if(rs.moveToFirst())
		{
			po= new ParlamentarPO();
			po.setCod_parlamentar(rs.getString(rs.getColumnIndex("ID_CLIENTE")));
			po.setNome_parlamentar(rs.getString(rs.getColumnIndex("NOME_PARLAMENTAR")));
		
			
		}
		return po;
	}
	public List<ParlamentarPO> getAll()
	{
		SQLiteDatabase db= new DB(context).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT ID_PARLAMENTAR,NOME_PARLAMENTAR FROM PARLAMENTAR", null);
		List <ParlamentarPO> lista= new ArrayList<ParlamentarPO>();
		while(rs.moveToNext())
		{
			ParlamentarPO po = new ParlamentarPO(rs.getString(0),rs.getString(1));
			lista.add(po);
			
		}
		return lista;
	}
}
