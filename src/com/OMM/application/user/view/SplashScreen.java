package com.OMM.application.user.view;

import com.OMM.application.user.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;


public class SplashScreen extends Activity {
	
	private final int DURACAO_DA_TELA = 4860;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
		MediaPlayer splashSound = MediaPlayer.create(this, R.raw.splash);
		splashSound.start();
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				
				Intent minhaAcao = new Intent(SplashScreen.this, GuiMain.class);
				
				SplashScreen.this.startActivity(minhaAcao);
				
				SplashScreen.this.finish();
				
			}
			
			}, DURACAO_DA_TELA);
		
		}
		

}