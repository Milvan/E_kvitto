package com.hallut.e_kvitto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ViewReceipt extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewreceipt);
		Intent in = this.getIntent();
		//Article articles[] = (Article[]) in.getSerializableExtra("articles");
		Receipt receipt = (Receipt) in.getSerializableExtra("receipt");
		
		TextView companyText = (TextView) findViewById(R.id.compName);
		TextView receiptDate = (TextView) findViewById(R.id.receiptDate);
		Article[] articles = receipt.getArticles();
		articles[0].getName();
		
		
		receiptDate.setText(receipt.getDate());
		companyText.setText(articles[0].getName());
		
	}

}
