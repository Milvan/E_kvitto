package com.hallut.e_kvitto;

import java.util.EmptyStackException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {
	HomeBackend back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// TODO: get info from database here about credit cards
		loadInfo();
		
		setContentView(R.layout.activity_home);
		
		//Set textField to current credit card
		setInfo();
		
		
	}
	
	private void loadInfo(){
		back = new HomeBackend();
		try{
			String user = this.getIntent().getExtras().getString("user");
			back.loadInfo(user);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void setInfo(){
		TextView text = (TextView) findViewById(R.id.infoDisplay);
		try{
			back.getNextCard();
		text.setText(back.getNextCard());
		} catch(EmptyStackException e){
			text.setText("Inga tillgängliga kreditkort");
		}
	}
	
	
	public void onClick(View arg){
		switch(arg.getId()){
		//Enter one case per button and control what to happen for each button.
			case R.id.button1:
				if(back.getCurrentCard()!=null){
					Intent receiptListScreen = new Intent(Home.this, ReceiptList.class);
					startActivity(receiptListScreen);
				} else {
					Toast.makeText(getApplicationContext(), "Inget kreditkort valt",
		                    Toast.LENGTH_SHORT).show();
				}
			break;
			
			default:
		}
	}



}
