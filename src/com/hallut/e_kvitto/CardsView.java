package com.hallut.e_kvitto;


import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Activity which displays a list of credit cards which the current user has registered. 
 *
 */
public class CardsView extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards_view);

		setInfo();
		
	}
	
	/**
	 * Get credit card information from HomeBackend and set this information to the layout.
	 */
	private void setInfo(){
		LinkedList<CreditCard> cards = HomeBackend.getHomeBackend().getUsersCards();
		ListView lv = (ListView) findViewById(R.id.cardlist);
        lv.setAdapter(new CardAdapter (this, cards));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	// If a card in the list is clicked, set the current card to that card and
        	// return to Home page.
        	public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {
               
        		CreditCard card = (CreditCard) arg0.getItemAtPosition(position);
                HomeBackend.getHomeBackend().setCurrentCard(card);
                Toast.makeText(getApplicationContext(), card.getType()+" valt", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
	}

	
}
