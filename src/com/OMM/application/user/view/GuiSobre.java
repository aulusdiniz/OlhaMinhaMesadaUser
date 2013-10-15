package com.OMM.application.user.view;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GuiSobre extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gui_sobre);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Button btn = (Button)findViewById(R.id.button1);
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        
                    	mp.start();
                    	Intent mudarTela = new Intent(GuiSobre.this, GuiMain.class);
            		    startActivity(mudarTela);
            		    GuiSobre.this.finish();
                    }
                });
        
        Button bt = (Button)findViewById(R.id.button2);
        final MediaPlayer mpl = MediaPlayer.create(this, R.raw.click);
        bt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        
                    	mpl.start();
                    	Intent mudarTela = new Intent(GuiSobre.this, GuiParlamentar.class);
            		    startActivity(mudarTela);
            		    GuiSobre.this.finish();
                    }
                });
	}
	
	
	

}
