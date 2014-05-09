package com.hallut.e_kvitto;


import java.util.LinkedList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ReceiptList extends Activity {
	
	Database db = Database.getDatabase();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiptlist);

		setInfo();
	}
	
	private void setInfo(){
		LinkedList<Receipt> rec = db.getReceipts(HomeBackend.getHomeBackend().getCurrentCard());
		ListView lv = (ListView) findViewById(R.id.receiptList);
        lv.setAdapter(new ReceiptAdapter (this, rec));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView <?> arg0, View view, int position, long id) {
                // Test click. Show message when clicked.
        		Toast.makeText(getApplicationContext(), ("pos " + position) , 
                        Toast.LENGTH_SHORT).show();
        		Receipt receipt =  (Receipt) arg0.getItemAtPosition(position);
                sendInfo(receipt);

            }
        });
	}
	
	private void sendInfo(Receipt receipt){
		Intent viewReceipt = new Intent(ReceiptList.this, ViewReceipt.class);
		viewReceipt.putExtra("receipt", receipt);
//		viewReceipt.putExtra("articles", receipt.getArticles());
//		viewReceipt.putExtra("company", receipt.getCompany());
//        viewReceipt.putExtra("ID", receipt.getID());
//        viewReceipt.putExtra("date", receipt.getDate());
//        viewReceipt.putExtra("time", receipt.getTime());
//        viewReceipt.putExtra("sellerID", receipt.getSellerID());
//        viewReceipt.putExtra("terminal", receipt.getTerminalID());
//        viewReceipt.putExtra("creditCard", receipt.getCard().getCardNumber());
//        
        startActivity(viewReceipt);
	}
	
}

