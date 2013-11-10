package com.OMM.application.user.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.OMM.application.user.R;
import com.OMM.application.user.helper.JSONHelper;
import com.OMM.application.user.model.CotaParlamentar;
import com.OMM.application.user.model.Parlamentar;

public class GuiMain extends Activity {

	private ProgressDialog progressDialog;

	
	TextView output;
	Button btn_sobre_main;
	Button btn_politico_main;
	Button btn_pesquisar_parlamentar;
	Button btn_teste;
	
	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_main);
		
		this.btn_sobre_main=(Button)findViewById(R.id.btn_sobre_main);
		this.btn_politico_main =(Button)findViewById(R.id.btn_politico_main);
		this.btn_pesquisar_parlamentar=(Button) findViewById(R.id.btn_pesquisar_parlamentar);
		this.btn_teste = (Button) findViewById(R.id.button1);
		this.output = (TextView) findViewById(R.id.output);
		
		/*
		//inicializa o banco e cria se ele nao existir 
		ParlamentarUserDao dao = new ParlamentarUserDao(getBaseContext());
		ParlamentarPO po=new ParlamentarPO("001","Ramon Cruz da silva");
		dao.insert(po);
		*/
		
		/*Criando um banco sqlite na forma mais simples 
		sem as boas praticas de programaï¿½ï¿½o
		
		SQLiteDatabase db= openOrCreateDatabase("devmedia.db",Context.MODE_PRIVATE,null);
		
		/*esse banco criado fica na pasta databese da aplicaï¿½ï¿½o
		e pode ser acessado usando o android Explorer do eclipse
		note que a criaï¿½ï¿½o do banco esta sendo manual.
		Detalhe: Se voce nao colocar o comando IF NOT EXISTS  no inicio 
		do comando CREATE TABLE o aplicativo executara apenas uma vez
		e darï¿½ um erro na segunda execucao, isso acontence porque jah existe 
		um banco de dados com a tabela no aparelho celular e nao eh necessario
		criar a tabela novamente, o problema deste medoto eh o acoplamento,
		desta forma vc acopla a interface direto com o banco de dados 
		e isso nï¿½o eh uma boa coisa , a manutencao fica muito complicado, 
		entao vamos usar os padroes de projeto ..nesse caso usaremos o padrao
		DAO. comece criando uma classe para tratar do bando que extende da classe
		SQLiteOpenHelper 
		
		esse parte do cï¿½digo foi substituida pela classe DB, ela que ficarah responsavel
		pelo banco de dados
		
		
		
		StringBuilder strb= new StringBuilder();
		strb.append("CREATE TABLE  IF NOT EXISTS [clientes] (");
		strb.append("[ID_CLIENTE] INTEGER PRIMARY KEY AUTOINCREMENT,");
		strb.append("  [NOME] VARCHAR(30),");
		strb.append("[EMAIL] VARCHAR(40), ");
		strb.append(" [ENDERECO] VARCHAR(50),");
		strb.append("[NUMERO] VARCHAR(10));");
		db.execSQL(strb.toString());
		*/
		
		
		
		/*comeï¿½ando a trabalhar com captura de eventos 
		comece recuperando os elementos do layout como botoes 
		campos de texto e etc.
		*/
		
			
		//agora vc deve implementar os metodos de captura de eventos 
		
		btn_sobre_main.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//esse comando chama outra activity
				startActivity(new Intent(getBaseContext(),GuiSobre.class));//corrigir a classe 
				
			}
		});
		
		btn_politico_main.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(getBaseContext(),"Nao implementado", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		
		btn_pesquisar_parlamentar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//esse comando chama outra activity
				startActivity(new Intent(getBaseContext(),GuiBuscarParlamentar.class));
				
			}
		});
		
		btn_teste.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				performRequest();				
			}
		});
		
	}
	
	private void performRequest() {
		
		final ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
			
			public String handleResponse(HttpResponse response) throws IOException{
				StatusLine status = response.getStatusLine();

				HttpEntity entity = response.getEntity();
				String result = null;
				//todo: refatorar, extrair mÃ©todo/objeto
				
				BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
				StringBuilder sb = new StringBuilder();
				String line = null;
				
				while ((line = br.readLine()) != null){
					sb.append(line + "\n");
				}
				
				br.close();
				result = sb.toString();
				
				Message message = handler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putString("RESPONSE", result);
				message.setData(bundle);
				handler.sendMessage(message);
				
				return result;				
			}
		};
		
		this.progressDialog = ProgressDialog.show(this, "Aguarde", "Fazendo Requisição...");
		
		new Thread(){
			
			public void run(){
				try{
					DefaultHttpClient client = new DefaultHttpClient();
					HttpGet httpMethod = new HttpGet("http://192.168.1.4:8080/OlhaMinhaMesada/cota?id=54373");
					client.execute(httpMethod, responseHandler);					
					
				}catch (ClientProtocolException e){
					//do sth
				}catch (IOException e){
					//do sth else
				}
			}
		}.start();
	}

	private final Handler handler = new Handler() {

		@Override
		public void handleMessage(final Message msg) {
			progressDialog.dismiss();			
			String bundleResult = msg.getData().getString("RESPONSE");
			
			List<CotaParlamentar> ceaps = JSONHelper.listaCotaParlamentarFromJSON(bundleResult);
			
			String valor = "" + ceaps.get(0).getValorAgosto();
			
			output.setText(valor);
		}
	};
}
