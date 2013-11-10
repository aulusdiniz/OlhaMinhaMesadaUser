package com.OMM.application.user.view;

import java.sql.SQLClientInfoException;

import com.OMM.application.user.R;
import com.OMM.application.user.dao.ParlamentarUserDao;
import com.OMM.application.user.pojo.ParlamentarPO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class GuiMain extends Activity implements
		ParlamentarListFragment.OnParlamentarSelectedListener {
	// private SearchView mSearchView;
	// private TextView mStatusView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_main);

		/*
		 * //inicializa o banco e cria se ele nao existir ParlamentarUserDao dao
		 * = new ParlamentarUserDao(getBaseContext()); ParlamentarPO po=new
		 * ParlamentarPO("001","Ramon Cruz da silva");
		 * po.setCod_parlamentar("002"); po.setNome_parlamentar("Tiririca");
		 * dao.insert(po); po.setCod_parlamentar("003");
		 * po.setNome_parlamentar("Romario brilha muito no curintias");
		 * dao.insert(po); po.setCod_parlamentar("004");
		 * po.setNome_parlamentar("Popo"); dao.insert(po);
		 * po.setCod_parlamentar("005"); po.setNome_parlamentar("Arruda");
		 * dao.insert(po);
		 */
		ParlamentarListFragment fragment = (ParlamentarListFragment) getFragmentManager()
				.findFragmentById(R.id.list_fragment);
		fragment.updateListContent();

		/*
		 * Criando um banco sqlite na forma mais simples sem as boas praticas de
		 * programação
		 * 
		 * SQLiteDatabase db=
		 * openOrCreateDatabase("devmedia.db",Context.MODE_PRIVATE,null);
		 * 
		 * /*esse banco criado fica na pasta databese da aplicação e pode ser
		 * acessado usando o android Explorer do eclipse note que a criação do
		 * banco esta sendo manual. Detalhe: Se voce nao colocar o comando IF
		 * NOT EXISTS no inicio do comando CREATE TABLE o aplicativo executara
		 * apenas uma vez e dará um erro na segunda execucao, isso acontence
		 * porque jah existe um banco de dados com a tabela no aparelho celular
		 * e nao eh necessario criar a tabela novamente, o problema deste medoto
		 * eh o acoplamento, desta forma vc acopla a interface direto com o
		 * banco de dados e isso não eh uma boa coisa , a manutencao fica muito
		 * complicado, entao vamos usar os padroes de projeto ..nesse caso
		 * usaremos o padrao DAO. comece criando uma classe para tratar do bando
		 * que extende da classe SQLiteOpenHelper
		 * 
		 * esse parte do código foi substituida pela classe DB, ela que ficarah
		 * responsavel pelo banco de dados
		 * 
		 * 
		 * 
		 * StringBuilder strb= new StringBuilder();
		 * strb.append("CREATE TABLE  IF NOT EXISTS [clientes] (");
		 * strb.append("[ID_CLIENTE] INTEGER PRIMARY KEY AUTOINCREMENT,");
		 * strb.append("  [NOME] VARCHAR(30),");
		 * strb.append("[EMAIL] VARCHAR(40), ");
		 * strb.append(" [ENDERECO] VARCHAR(50),");
		 * strb.append("[NUMERO] VARCHAR(10));"); db.execSQL(strb.toString());
		 */

		/*
		 * começando a trabalhar com captura de eventos comece recuperando os
		 * elementos do layout como botoes campos de texto e etc.
		 */

		Button btn_sobre_main = (Button) findViewById(R.id.btn_sobre_main);
		Button btn_politico_main = (Button) findViewById(R.id.btn_politico_main);
		Button btn_pesquisar_parlamentar = (Button) findViewById(R.id.btn_pesquisar_parlamentar);

		// agora vc deve implementar os metodos de captura de eventos

		btn_sobre_main.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// esse comando chama outra activity
				startActivity(new Intent(getBaseContext(), GuiSobre.class));// corrigir
																			// a
																			// classe
			}
		});

		btn_politico_main.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(getBaseContext(), "Nao implementado",
						Toast.LENGTH_SHORT).show();

			}
		});

		btn_pesquisar_parlamentar
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// esse comando chama outra activity
						startActivity(new Intent(getBaseContext(),
								GuiBuscarParlamentar.class));

					}
				});
	}

	@Override
	public void OnParlamentarSelected(String nome) {
		// TODO Auto-generated method stub
	}

}
