package com.OMM.application.user.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper{

	private static String dbName= "OMM.db";
	private static String sql="CREATE TABLE [PARLAMENTAR] ( [ID_PARLAMENTAR] VARCHAR(10),  [NOME_PARLAMENTAR] VARCHAR(40));";
	private static int version =1;
	
	
	public DB(Context context) {
		super(context, dbName, null, version);
				
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * Esse eh executado quando instalada aplicacao
		 */
		db.execSQL(sql);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		/* Eh executado quando o usuario ja tem a aplicacao instalada e deseja
		 * instalar uma versao superior, com esse metodo vc consegue 
		 * fazer melhor a atualizacao do banco da nova versao sem que o usuario
		 * perca as informa��es ja persistidas no celular
		 * por exemplo , suponha que o usuario deseja atualizar a versao 
		 * 1 para 2 do aplicativo e nessa nova versao nao existe mais a tabela
		 * log e foi criada a tabela clientes ... veja como fica o corpo do metodo
		 * if(oldVersion==1)
			{
				if(newVersion ==2)
				{
					db.execSQL("DROP TABLE logs");
					db.execSQL("CREATE TABLE cliente....");
				}
			}
		 */
		
		
	}
	

}
