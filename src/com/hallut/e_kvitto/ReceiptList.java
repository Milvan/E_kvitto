package com.hallut.e_kvitto;


import java.util.LinkedList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Activity which displays a list of receipts to a given credit card.
 * 
 *
 */
public class ReceiptList extends Activity {
	
	Database db = Database.getDatabase();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiptlist);

		setInfo();
	}
	
	/**
	 * Used to get and set the receipt information from the database. Gets the receipts that
	 * belongs to one specific card. Also creates the view of the list that contains
	 *  all the receipts
	 */
	private void setInfo(){
		LinkedList<Receipt> rec = db.getReceipts(HomeBackend.getHomeBackend().getCurrentCard());
		ListView lv = (ListView) findViewById(R.id.receiptList);
        lv.setAdapter(new ReceiptAdapter (this, rec));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	// get the receipt on the position which is clicked and send that information
        	// to the next activity
        	public void onItemClick(AdapterView <?> arg0, View view, int position, long id) {
        		Receipt receipt =  (Receipt) arg0.getItemAtPosition(position);
                sendInfo(receipt);

            }
        });
	}
	
	/**
	 * Sends the given receipt to the next activity.
	 * @param receipt The receipt that will be sent to the next activity.
	 */
	private void sendInfo(Receipt receipt){
		Intent viewReceipt = new Intent(ReceiptList.this, ViewReceipt.class);
		viewReceipt.putExtra("receipt", receipt);
        startActivity(viewReceipt);
	}
	
}

