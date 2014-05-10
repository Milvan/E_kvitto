package com.hallut.e_kvitto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ViewReceipt extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewreceipt);
		Intent in = this.getIntent();
		
		Receipt receipt = (Receipt) in.getSerializableExtra("receipt");
		Article articles[] = receipt.getArticles();
		ListView lv = (ListView) findViewById(R.id.receiptArticles);
        lv.setAdapter(new ArticleAdapter (this, articles));
		
		TextView company = (TextView) findViewById(R.id.compName);
	    TextView date = (TextView) findViewById(R.id.receiptDate);
	    TextView receiptID = (TextView) findViewById(R.id.receiptID);
	    TextView totalsum = (TextView) findViewById(R.id.totalsum);
	    TextView time = (TextView) findViewById(R.id.time);
	    TextView sellerID = (TextView) findViewById(R.id.sellerID);
	    TextView terminalID = (TextView) findViewById(R.id.terminalID);
	    
		company.setText(receipt.getCompany());
		date.setText(receipt.getDate());
		receiptID.setText("Kvitto: " + String.valueOf(receipt.getID()));
		totalsum.setText("Total: " + String.valueOf(receipt.getTotalSum()));
		time.setText("Tid: " + receipt.getTime());
		sellerID.setText("Säljare: " + receipt.getSellerID());
		terminalID.setText("Kassa: " + receipt.getTerminalID());
		
	}

}
