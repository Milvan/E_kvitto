package com.hallut.e_kvitto;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiptList extends Activity {
	
	String receipts[] = { "first receipt", "second receipt", "example" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiptlist);

		ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(new ArrayAdapter < String > (this,
        		android.R.layout.simple_list_item_1, receipts));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {
                // Test click. Show message when clicked.
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                    Toast.LENGTH_SHORT).show();
            }
        });
	}
	
}

