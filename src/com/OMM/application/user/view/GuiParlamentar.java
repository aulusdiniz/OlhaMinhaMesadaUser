package com.OMM.application.user.view;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GuiParlamentar extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_parlamentar);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Button btn = (Button)findViewById(R.id.button1);
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                    	
                        mp.start();
                    	Intent mudarTela = new Intent(GuiParlamentar.this, GuiMain.class);
            		    startActivity(mudarTela);
            		    GuiParlamentar.this.finish();
                    }
                });
        
        Button bt = (Button)findViewById(R.id.button2);
        final MediaPlayer mpl = MediaPlayer.create(this, R.raw.click);
        bt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                    	
                        mpl.start();
                    	Intent mudarTela = new Intent(GuiParlamentar.this, GuiSobre.class);
            		    startActivity(mudarTela);
            		    GuiParlamentar.this.finish();
                    }
                });
	}
	
	
	

}
