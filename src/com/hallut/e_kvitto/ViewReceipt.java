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
		String company = in.getStringExtra("company");
		Log.i("company", company);
		TextView companyText = (TextView) findViewById(R.id.compName);
		companyText.setText(company);
	}

}
