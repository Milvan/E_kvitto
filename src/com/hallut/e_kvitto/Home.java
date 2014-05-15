package com.hallut.e_kvitto;

import java.util.EmptyStackException;
import java.util.LinkedList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 *
 */
public class Home extends Activity {
	HomeBackend back;
	LinkedList<Toast> messageQueue = new LinkedList<Toast>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		loadInfo();
		setInfo();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		setInfo();
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		for(Toast t:messageQueue){
			t.cancel();
		}
	}
	
	/**
	 * Tell backend to load the needed info
	 */
	private void loadInfo(){
		back = HomeBackend.getHomeBackend();
		try{
			Server s = Server.getServer();
			String user = s.getLoggedInUser();
			back.loadInfo(user);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Set info from backend to frontend GUI
	 */
	private void setInfo(){
		TextView text = (TextView) findViewById(R.id.cardnumber);
		
			CreditCard currentCard = back.getCurrentCard();
			if(currentCard==null){
				text.setTextSize(18);
				text.setText("Inget kort valt");
				return;
			}
			String temp = currentCard.getCardNumber();
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
		
	}
	
	/**
     * Takes in the view that was clicked in android view and performs actions depending on view Item.
	 * Is called by android:onClick
	 * @param arg The view that was clicked
	 */
	public void onClick(View arg){
		switch(arg.getId()){
		//Enter one case per button and control what to happen for each button.
			case R.id.my_receipts:
				if(back.getCurrentCard()!=null){
					if(Database.getDatabase().getReceipts(back.getCurrentCard()).size()<1){
						Toast message = Toast.makeText(getApplicationContext(), "Det finns inga kvitton på valt kort", Toast.LENGTH_LONG);
						messageQueue.addLast(message);
						message.show();
					} else {
						Intent receiptListScreen = new Intent(Home.this, ReceiptList.class);
						startActivity(receiptListScreen);
					}
					
				} else {
					Toast.makeText(getApplicationContext(), "Inget kreditkort valt",
		                    Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.my_cards:
				if(back.getUsersCards().size()<1){
					Toast.makeText(getApplicationContext(), "Du har inga registrerade kort, vänligen kontakta din bank", Toast.LENGTH_LONG).show();
				} else {
					Intent creditCardScreen = new Intent(Home.this, CardsView.class);
					startActivity(creditCardScreen);
				}
				
				break;
			
			default:
		}
	}



}
