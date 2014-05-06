package com.hallut.e_kvitto;


import java.util.Iterator;
import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ReceiptList extends Activity {
	
	Database db = Database.getDatabase();
	
	//TODO: We need something else here. Need to store Receipt objects in some kind of list, responding to graphical list
	// The graphical list will only display a Company name text. could be more than one of the same. So we need to ID the correct receipt
	// either from storing the actual receipt in the graphical view as well or from responding index in backend array.
	String receipts[];
	LinkedList<Receipt> rec = db.getReceipts(HomeBackend.getHomeBackend().getCurrentCard());
	
	private void fillReceipts(){
		int size = rec.size();
		receipts = new String[size];
		Iterator<Receipt> it = rec.iterator();
		int index = 0;
		while(it.hasNext()){
			receipts[index] = it.next().getCompany();
			index++;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiptlist);
		//fillReceipts();
		ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(new ReceiptAdapter (this, rec));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {
                // Test click. Show message when clicked.

                Toast.makeText(getApplicationContext(), ("test") , 
                    Toast.LENGTH_SHORT).show();
            }
        });
	}
	
}

