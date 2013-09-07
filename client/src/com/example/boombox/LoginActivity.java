package com.example.boombox;

import com.example.boombox.net.Server;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		//Server s = new Server();
		//TextView tv = (TextView) findViewById(R.id.text);
		//if (s.get("hello/10") == null)
//			tv.setText("hi");
	}
}
