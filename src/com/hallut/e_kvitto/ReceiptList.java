package com.hallut.e_kvitto;


import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ReceiptList extends Activity {
	
	Database db = Database.getDatabase();
	LinkedList<Receipt> rec = db.getReceipts(HomeBackend.getHomeBackend().getCurrentCard());
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiptlist);
		//fillReceipts();
		ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(new ReceiptAdapter (this, rec));
        Log.i("liststorlek", "" + rec.size());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView <?> arg0, View view, int position, long id) {
                // Test click. Show message when clicked.

                Toast.makeText(getApplicationContext(), ("pos"+position) , 
                    Toast.LENGTH_SHORT).show();
            }
        });
	}
	
}

