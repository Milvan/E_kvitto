package com.hallut.e_kvitto;


import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class CardsView extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards_view);

		setInfo();
		
	}
	
	private void setInfo(){
		LinkedList<CreditCard> cards = HomeBackend.getHomeBackend().getUsersCards();
		ListView lv = (ListView) findViewById(R.id.cardlist);
        lv.setAdapter(new CardAdapter (this, cards));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {
               
        		CreditCard card = (CreditCard) arg0.getItemAtPosition(position);
                HomeBackend.getHomeBackend().setCurrentCard(card);
                finish();
            }
        });
	}

	
}
