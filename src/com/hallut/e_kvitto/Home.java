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
		//setInfo();
		
		
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		setInfo();
	}
	
	private void loadInfo(){
		back = HomeBackend.getHomeBackend();
		try{
			String user = this.getIntent().getExtras().getString("user");
			back.loadInfo(user);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void setInfo(){
		TextView text = (TextView) findViewById(R.id.cardnumber);
		try{
			String temp = back.getCurrentCard().getCardNumber();
			StringBuilder cardnumber = new StringBuilder();
			for(int i=0; i<temp.length();i++){
				if(i!=0){
					if((i%4)==0){
						cardnumber.append("  ");
					}
				}
				cardnumber.append(temp.charAt(i));
			}
			text.setText(cardnumber.toString());
		} catch(EmptyStackException e){
			text.setTextSize(18);
			text.setText("Inga tillgängliga kreditkort");
		}
	}
	
	
	public void onClick(View arg){
		switch(arg.getId()){
		//Enter one case per button and control what to happen for each button.
			case R.id.my_receipts:
				if(back.getCurrentCard()!=null){
					Intent receiptListScreen = new Intent(Home.this, ReceiptList.class);
					startActivity(receiptListScreen);
				} else {
					Toast.makeText(getApplicationContext(), "Inget kreditkort valt",
		                    Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.my_cards:
				Intent creditCardScreen = new Intent(Home.this, CardsView.class);
				startActivity(creditCardScreen);
				break;
			
			default:
		}
	}



}
