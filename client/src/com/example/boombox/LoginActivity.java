package com.example.boombox;

import com.example.boombox.net.Server;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

	private Button login;
	private EditText user;
	private EditText pass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		login = (Button) findViewById(R.id.login_button);
		user = (EditText) findViewById(R.id.username);
		pass = (EditText) findViewById(R.id.password);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/*
				Intent i = new Intent();
				user.getText();
				pass.getText();*/
			}
		});
		Server s = new Server();
		TextView tv = (TextView) findViewById(R.id.user_display);
		tv.setText(s.get("hello/10"));
	}
	
	
}
