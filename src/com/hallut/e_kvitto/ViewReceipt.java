package com.hallut.e_kvitto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Activity which display a chosen receipt.
 *
 */
public class ViewReceipt extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewreceipt);
		Intent in = this.getIntent();
		
		Receipt receipt = (Receipt) in.getSerializableExtra("receipt");
		setInfo(receipt);
	}
	
	/**
	 * Get all the required information about the receipt and set that information
	 * to the layout that is shown for this activity.
	 * @param receipt 
	 */
	public void setInfo(Receipt receipt){
		Article articles[] = receipt.getArticles();
		
		//find the textviews in the activity_viewreceipt.xml file
		TextView company = (TextView) findViewById(R.id.compName);
	    TextView date = (TextView) findViewById(R.id.receiptDate);
	    TextView receiptID = (TextView) findViewById(R.id.receiptID);
	    TextView totalsum = (TextView) findViewById(R.id.totalSum);
	    TextView time = (TextView) findViewById(R.id.receiptTime);
	    TextView sellerID = (TextView) findViewById(R.id.sellerId);
	    TextView terminalID = (TextView) findViewById(R.id.terminalId);
	    
	    //set text to the textviews.
		company.setText(receipt.getCompany());
		date.setText(receipt.getDate());
		receiptID.setText("Kvitto: " + String.valueOf(receipt.getID()));
		totalsum.setText("Total: " + String.valueOf(receipt.getTotalSum() + " kr"));
		time.setText("Tid: " + receipt.getTime());
		sellerID.setText("Säljare: " + receipt.getSellerID());
		terminalID.setText("Kassa: " + receipt.getTerminalID());
		
		//set the layout of the listview.
		ListView lv = (ListView) findViewById(R.id.receiptArticle);
        lv.setAdapter(new ArticleAdapter (this, articles));
	}

}
