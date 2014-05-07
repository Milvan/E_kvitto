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
<<<<<<< HEAD
	//move inside oncreate
=======
	
	//TODO: We need something else here. Need to store Receipt objects in some kind of list, responding to graphical list
	// The graphical list will only display a Company name text. could be more than one of the same. So we need to ID the correct receipt
	// either from storing the actual receipt in the graphical view as well or from responding index in backend array.
>>>>>>> branch 'master' of https://github.com/Milvan/E_kvitto
	LinkedList<Receipt> rec = db.getReceipts(HomeBackend.getHomeBackend().getCurrentCard());
<<<<<<< HEAD
	
=======

>>>>>>> branch 'master' of https://github.com/Milvan/E_kvitto
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiptlist);
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/Milvan/E_kvitto
		ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(new ReceiptAdapter (this, rec));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView <?> arg0, View view, int position, long id) {
                // Test click. Show message when clicked.
        		Toast.makeText(getApplicationContext(), ("pos " + position) , 
                        Toast.LENGTH_SHORT).show();
        		Receipt receipt =  (Receipt) arg0.getItemAtPosition(position);
                Intent viewReceipt = new Intent(ReceiptList.this, ViewReceipt.class);
                viewReceipt.putExtra("company", receipt.getCompany());
                viewReceipt.putExtra("ID", receipt.getID());
                viewReceipt.putExtra("date", receipt.getDate());
                viewReceipt.putExtra("time", receipt.getTime());
                viewReceipt.putExtra("sellerID", receipt.getSellerID());
                viewReceipt.putExtra("terminal", receipt.getTerminalID());
                viewReceipt.putExtra("creditCard", receipt.getCard().getCardNumber());
                viewReceipt.putExtra("articles", receipt.getArticles());
                startActivity(viewReceipt);

            }
        });
	}
	
}

