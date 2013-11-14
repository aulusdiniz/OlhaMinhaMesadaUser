package com.OMM.application.user.view;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;

import com.OMM.application.user.dao.ParlamentarUserDao;
import com.OMM.application.user.model.Parlamentar;

public class GuiMain extends Activity implements
		ParlamentarSeguidoListFragment.OnParlamentarSeguidoSelectedListener,
		ParlamentarListFragment.OnParlamentarSelectedListener {

	private static final String SEGUIDOS = "Parlamentares Seguidos";
	private static final String PESQUISA = "Pesquisar Parlamentar";
	private static final String RANKINGS = "Rankings entre parlamentares";

	private static FragmentManager fragmentManager;


	TextView output;
	Button btn_sobre_main;
	Button btn_politico_main;
	Button btn_pesquisar_parlamentar;
	Button btn_teste;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_main);
		fragmentManager = this.getFragmentManager();

		
		  //inicializa o banco e cria se ele nao existir 
//		ParlamentarUserDao dao  = new ParlamentarUserDao(getBaseContext()); 
//		  Parlamentar po=new Parlamentar();
//		  po.setId(002);
//		  po.setNome("Tiririca");
//		  po.setPartido("pcdob");
//		  po.setSeguido(false);
//		  po.setUf("DF");
//		  dao.insert(po);
//		  po.setNome_parlamentar("Romario brilha muito no curintias");
//		  dao.insert(po); po.setCod_parlamentar("004");
//		  po.setNome_parlamentar("Popo"); dao.insert(po);
//		  po.setCod_parlamentar("005"); po.setNome_parlamentar("Arruda");
//		  dao.insert(po);

		if (findViewById(R.id.fragment_container) != null) {

			/* cria a primeira lista */
			ParlamentarSeguidoListFragment fragment = new ParlamentarSeguidoListFragment();
			fragmentManager.beginTransaction()
					.replace(R.id.fragment_container, fragment).commit();
		}

		/*
		 * //inicializa o banco e cria se ele nao existir ParlamentarUserDao dao
		 * = new ParlamentarUserDao(getBaseContext()); ParlamentarPO po=new
		 * ParlamentarPO("001","Ramon Cruz da silva"); dao.insert(po);
		 */

		/*
		 * Criando um banco sqlite na forma mais simples sem as boas praticas de
		 * programaï¿½ï¿½o
		 * SQLiteDatabase db=
		 * openOrCreateDatabase("devmedia.db",Context.MODE_PRIVATE,null);
		 * 
		 */
		 /*esse banco criado fica na pasta databese da aplicação e pode ser
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

				startActivity(new Intent(getBaseContext(), GuiSobre.class));// corrigir																				// a
																				// classe

			}
		});

		btn_politico_main.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				/* Substitui a lista */
				ParlamentarSeguidoListFragment listFragment = new ParlamentarSeguidoListFragment();
				FragmentTransaction transaction = fragmentManager
						.beginTransaction();
				transaction.replace(R.id.fragment_container, listFragment);
				transaction.commit();
				Toast.makeText(getBaseContext(), SEGUIDOS, Toast.LENGTH_SHORT)
						.show();
		}
		});

		btn_pesquisar_parlamentar
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						/* Substitui a lista */
						ParlamentarListFragment listFragment = new ParlamentarListFragment();
						FragmentTransaction transaction = fragmentManager
								.beginTransaction();
						transaction.replace(R.id.fragment_container,
								listFragment);
						transaction.commit();
						Toast.makeText(getBaseContext(), PESQUISA,
								Toast.LENGTH_SHORT).show();
					}
				});
		btn_ranking_main.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ParlamentarSeguidoListFragment newFragment = new ParlamentarSeguidoListFragment();
				FragmentTransaction transaction = fragmentManager
						.beginTransaction();
				transaction.replace(R.id.fragment_container, newFragment);
				transaction.commit();
				Toast.makeText(getBaseContext(), RANKINGS, Toast.LENGTH_SHORT)
						.show();

			}
		});

		btn_mostra_outros.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				/* Modificando a visibilidade dos botoes */
				if (btn_pesquisar_parlamentar.getVisibility() == View.GONE) {
					btn_pesquisar_parlamentar.setVisibility(View.VISIBLE);
					btn_politico_main.setVisibility(View.VISIBLE);
					btn_ranking_main.setVisibility(View.VISIBLE);
					btn_sobre_main.setVisibility(View.VISIBLE);
					btn_mostra_outros.setScaleX(1.0f);
					btn_mostra_outros.setScaleY(1.0f);
				}
				else {
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
	public void OnParlamentarSeguidoSelected(Parlamentar parlamentar) {
		/* Substitui o detalhe */
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			ParlamentarDetailFragment detailFragment = new ParlamentarDetailFragment();
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.fragment_container, detailFragment);
			// transaction.addToBackStack(null);
			transaction.commitAllowingStateLoss();
			getFragmentManager().executePendingTransactions();
			detailFragment.setText(parlamentar.getNome());

		} else {
			ParlamentarDetailFragment detailFragment = new ParlamentarDetailFragment();
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.detail_fragment_container, detailFragment);
			transaction.addToBackStack(null);
			transaction.commit();
			getFragmentManager().executePendingTransactions();
			detailFragment.setText(parlamentar.getNome());
		}
	}

	@Override
	public void OnParlamentarSelected(Parlamentar parlamentar) {
		/* Substitui o detalhe */
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			ParlamentarDetailFragment detailFragment = new ParlamentarDetailFragment();
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.fragment_container, detailFragment);
			// transaction.addToBackStack(null);
			transaction.commitAllowingStateLoss();
			getFragmentManager().executePendingTransactions();
			detailFragment.setText(parlamentar.getNome());

		} else {
			ParlamentarDetailFragment detailFragment = new ParlamentarDetailFragment();
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.detail_fragment_container, detailFragment);
			transaction.addToBackStack(null);
			transaction.commit();
			getFragmentManager().executePendingTransactions();
			detailFragment.setText(parlamentar.getNome());
		}
	}
}
				});

		btn_teste.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				ResponseHandler<String> response = HttpConnection.getResponseHandler();

				BuscaTask task = new BuscaTask();

				task.execute(response);
			}
		});

	}

	private class BuscaTask extends AsyncTask<ResponseHandler<String>, Void, String> {

		protected void onPreExecute() {
			progressDialog = ProgressDialog.show(GuiMain.this, "Aguarde...",
					"Buscando Dados");
		}

		@Override
		protected String doInBackground(ResponseHandler<String>... params) {

			ParlamentarUserController parlamentarController = ParlamentarUserController
					.getInstance();

			
			
			

			Parlamentar p =  parlamentarController.fazerRequisicao( params[0], 54373 );

			Log.i("LOGS", "Parlamentar:" + p.getNome());

			String objeto = p.toString();

			return objeto;
		}

		@Override
		protected void onPostExecute(final String result) {

			progressDialog.dismiss();
			output.setText(result);
		}
	}
}