package com.OMM.application.user.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.OMM.application.user.helper.JSONHelper;
import com.OMM.application.user.model.Parlamentar;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class GuiMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_main);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Button btn = (Button) findViewById(R.id.button1);
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				mp.start();
				Intent mudarTela = new Intent(GuiMain.this,
						GuiParlamentar.class);
				startActivity(mudarTela);
				GuiMain.this.finish();
			}
		});

		Button sobre = (Button) findViewById(R.id.button2);
		final MediaPlayer mpl = MediaPlayer.create(this, R.raw.click);
		sobre.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				mpl.start();
				Intent mudarTela = new Intent(GuiMain.this, GuiSobre.class);
				startActivity(mudarTela);
				GuiMain.this.finish();
			}
		});
		
		
		
		handleIntent(getIntent());
	}

	@Override
	protected void onNewIntent(Intent intent) {

		handleIntent(intent);
	}

	private void handleIntent(Intent intent) {

		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			// use the query to search your data somehow
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.options_menu, menu);

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));

		return true;

	}
}

