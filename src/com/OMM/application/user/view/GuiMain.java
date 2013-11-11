package com.OMM.application.user.view;

import java.sql.SQLClientInfoException;

import com.OMM.application.user.R;
import com.OMM.application.user.dao.ParlamentarUserDao;
import com.OMM.application.user.pojo.ParlamentarPO;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class GuiMain extends Activity implements
		ParlamentarSeguidoListFragment.OnParlamentarSeguidoSelectedListener,  ParlamentarListFragment.OnParlamentarSelectedListener{
	// private SearchView mSearchView;
	// private TextView mStatusView;

	private static final String SEGUIDOS = "Parlamentares Seguidos";
	private static final String PESQUISA = "Pesquisar Parlamentar";
	private static final String RANKINGS = "Rankings entre parlamentares";
	
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
		// ParlamentarListFragment fragment = (ParlamentarListFragment)
		// getFragmentManager()
		// .findFragmentById(R.id.list_fragment);
		// fragment.updateListContent();

		if (findViewById(R.id.fragment_container) != null) {

			// However, if we're being restored from a previous state,
			// then we don't need to do anything and should return or else
			// we could end up with overlapping fragments.
			if (savedInstanceState != null) {
				//faz nada
			}
			else{
			// Create a new Fragment to be placed in the activity layout
			ParlamentarSeguidoListFragment fragment = new ParlamentarSeguidoListFragment();

			// In case this activity was started with special instructions from
			// an
			// Intent, pass the Intent's extras to the fragment as arguments
			// fragment.setArguments(getIntent().getExtras());

			// Add the fragment to the 'fragment_container' FrameLayout
			getFragmentManager().beginTransaction()
					.add(R.id.fragment_container, fragment).commit();
			}
		}

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

		final Button btn_sobre_main = (Button) findViewById(R.id.btn_sobre_main);
		final Button btn_politico_main = (Button) findViewById(R.id.btn_politico_main);
		final Button btn_pesquisar_parlamentar = (Button) findViewById(R.id.btn_pesquisar_parlamentar);
		final Button btn_ranking_main = (Button) findViewById(R.id.btn_ranking);
		final Button btn_mostra_outros = (Button) findViewById(R.id.btn_ic_rolagem);
		// agora vc deve implementar os metodos de captura de eventos

		btn_sobre_main.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// esse comando chama outra activity
				startActivity(new Intent(getBaseContext(), GuiSobre.class));// corrigir
																			// a
																			// class
			}
		});

		btn_politico_main.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Create fragment and give it an argument specifying the
				// article it should show
				ParlamentarSeguidoListFragment newFragment = new ParlamentarSeguidoListFragment();
				Bundle args = new Bundle();
				// args.putInt(ParlamentarListFragment.ARG_POSITION, position);
				// newFragment.setArguments(args);

				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				// Replace whatever is in the fragment_container view with this
				// fragment,
				// and add the transaction to the back stack so the user can
				// navigate back
				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				// Commit the transaction
				transaction.commit();
				Toast.makeText(getBaseContext(), SEGUIDOS, Toast.LENGTH_SHORT).show();

			}
		});

		btn_pesquisar_parlamentar
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// Create fragment and give it an argument specifying
						// the article it should show
						ParlamentarListFragment newFragment = new ParlamentarListFragment();
						Bundle args = new Bundle();
						// args.putInt(ParlamentarListFragment.ARG_POSITION,
						// position);
						// newFragment.setArguments(args);

						FragmentTransaction transaction = getFragmentManager()
								.beginTransaction();

						// Replace whatever is in the fragment_container view
						// with this fragment,
						// and add the transaction to the back stack so the user
						// can navigate back
						transaction.replace(R.id.fragment_container,
								newFragment);
						transaction.addToBackStack(null);

						// Commit the transaction
						transaction.commit();
						Toast.makeText(getBaseContext(), PESQUISA, Toast.LENGTH_SHORT).show();
					}
				});
		btn_ranking_main.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Create fragment and give it an argument specifying the
				// article it should show
				ParlamentarSeguidoListFragment newFragment = new ParlamentarSeguidoListFragment();
				Bundle args = new Bundle();
				// args.putInt(ParlamentarListFragment.ARG_POSITION, position);
				// newFragment.setArguments(args);

				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				// Replace whatever is in the fragment_container view with this
				// fragment,
				// and add the transaction to the back stack so the user can
				// navigate back
				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				// Commit the transaction
				transaction.commit();
				Toast.makeText(getBaseContext(), RANKINGS, Toast.LENGTH_SHORT).show();
			}
		});

		btn_mostra_outros.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (btn_pesquisar_parlamentar.getVisibility() == View.GONE) {
					btn_pesquisar_parlamentar.setVisibility(View.VISIBLE);
					btn_politico_main.setVisibility(View.VISIBLE);
					btn_ranking_main.setVisibility(View.VISIBLE);
					btn_sobre_main.setVisibility(View.VISIBLE);
					btn_mostra_outros.setScaleX(1.0f);
					btn_mostra_outros.setScaleY(1.0f);
				} else {
					btn_pesquisar_parlamentar.setVisibility(View.GONE);
					btn_politico_main.setVisibility(View.GONE);
					btn_ranking_main.setVisibility(View.GONE);
					btn_sobre_main.setVisibility(View.GONE);
					btn_mostra_outros.setScaleX(0.6f);
					btn_mostra_outros.setScaleY(0.6f);
					
				}
			}
		});
	
	}

	@Override
	public void OnParlamentarSeguidoSelected(String nome) {
		// TODO Auto-generated method stub
	}

	@Override
	public void OnParlamentarSelected(String nome) {
		// TODO Auto-generated method stub
		
	}
	
	public void repositioningBtn(View view, double amount){
				int amountOffscreen = (int)(view.getWidth() * amount);
				RelativeLayout.LayoutParams rlParams = 
				    (RelativeLayout.LayoutParams)view.getLayoutParams();
				rlParams.setMargins(0,0,-amountOffscreen,-amountOffscreen);
				view.setLayoutParams(rlParams);
	}

}
