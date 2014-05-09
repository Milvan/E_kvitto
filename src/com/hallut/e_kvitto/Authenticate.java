package com.hallut.e_kvitto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

public class Authenticate extends Activity {
	
	private TextView mPassView;
	private String mPass = new String();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authenticate);
		mPassView = (TextView) findViewById(R.id.passview);

	}

	public void onClick(View arg){
		switch(arg.getId()){
		//Enter one case per button and control what to happen for each button.
			case R.id.num1:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="1";
				break;
			case R.id.num2:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="2";
				break;
			case R.id.num3:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="3";
				break;
			case R.id.num4:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="4";
				break;
			case R.id.num5:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="5";
				break;
			case R.id.num6:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="6";
				break;
			case R.id.num7:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="7";
				break;
			case R.id.num8:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="8";
				break;
			case R.id.num9:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="9";
				break;
			case R.id.num0:
				mPassView.setText(mPassView.getText()+"*");
				mPass+="0";
				break;
			case R.id.auth:
				setResult(RESULT_OK);
				finish();
				break;
			
			default:
		}
	}

}
