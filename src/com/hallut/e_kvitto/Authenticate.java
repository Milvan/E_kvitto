package com.hallut.e_kvitto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

public class Authenticate extends Activity {
	
	private TextView mPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authenticate);
		mPass = (TextView) findViewById(R.id.view_auth_pass);

	}

	public void onClick(View arg){
		switch(arg.getId()){
		//Enter one case per button and control what to happen for each button.
			case R.id.num1:
				mPass.setText(mPass.getText()+"1");
			break;
			case R.id.num2:
				mPass.setText(mPass.getText()+"2");
				break;
			case R.id.num3:
				mPass.setText(mPass.getText()+"3");
				break;
			case R.id.num4:
				mPass.setText(mPass.getText()+"4");
				break;
			case R.id.num5:
				mPass.setText(mPass.getText()+"5");
				break;
			case R.id.num6:
				mPass.setText(mPass.getText()+"6");
				break;
			case R.id.num7:
				mPass.setText(mPass.getText()+"7");
				break;
			case R.id.num8:
				mPass.setText(mPass.getText()+"8");
				break;
			case R.id.num9:
				mPass.setText(mPass.getText()+"9");
				break;
			case R.id.num0:
				mPass.setText(mPass.getText()+"0");
				break;
			case R.id.auth:
				setResult(RESULT_OK);
				finish();
				break;
			
			default:
		}
	}

}
