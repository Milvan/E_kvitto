package com.hallut.e_kvitto;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Activity which is being displayed in the beginning when the application is started.
 *
 */
public class StartingSplash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting_splash);
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				} catch (InterruptedException e){
					e.printStackTrace();
				} finally {
					Intent openHomeScreen = new Intent("com.hallut.e_kvitto.LOGIN");
					startActivity(openHomeScreen);
				}
			}
		};
		timer.start();
	}
	
	@Override
	public void onPause(){
		super.onPause();
		finish();
	}

}
