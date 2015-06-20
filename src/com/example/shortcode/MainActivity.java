package com.example.shortcode;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	Button btn;
	TextView data, sms, kopa, zawadi, airtime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actbar = getActionBar();
		actbar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.button1);
		data = (TextView) findViewById(R.id.textView1);
		sms = (TextView) findViewById(R.id.textView2);
		kopa = (TextView) findViewById(R.id.textView3);
		zawadi = (TextView) findViewById (R.id.textView4);
		airtime = (TextView) findViewById (R.id.textView5);
		
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showInDialog();
			}
		});

		data.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + "*544" + Uri.encode("#")));
				startActivity(intent);
			}
		});

		sms.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + "*767" + Uri.encode("#")));
				startActivity(intent);
			}
		});

		kopa.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + "*310" + Uri.encode("#")));
				startActivity(intent);
			}
		});
		
		zawadi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + "*326" + Uri.encode("#")));
				startActivity(intent);
			}
		});
		
		airtime.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + "*133" + Uri.encode("#")));
				startActivity(intent);
//				TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//				String nOperatorName = tm.getNetworkOperatorName();
//				String lineNo = tm.getNetworkOperator();		
//				Toast.makeText(getApplicationContext(), nOperatorName , Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	protected void showInDialog() {
		LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
		View promptView = layoutInflater.inflate(R.layout.top_up, null);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				MainActivity.this);
		alertDialogBuilder.setView(promptView);

		final EditText etext = (EditText) promptView
				.findViewById(R.id.editText1);
		alertDialogBuilder.setTitle("Enter Recharge Code");
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("Go", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						String userData = etext.getText()
								.toString().trim();
						if (etext.getText().toString().equals("")
								|| etext.getText().toString().length() < 14) {
							Toast.makeText(
									getApplicationContext(),
									"Enter Recharge Code/Scratch Code is short",
									Toast.LENGTH_SHORT).show();
						} else {
							Intent intent = new Intent(Intent.ACTION_CALL);
							intent.setData(Uri.parse("tel:" + "*122*"
									+ userData + Uri.encode("#")));
							startActivity(intent);
						}
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						});
		// create an alert dialog
		final AlertDialog alert = alertDialogBuilder.create();
		alert.show();
		
		// Initially disable the button
		((AlertDialog) alert).getButton(AlertDialog.BUTTON_POSITIVE)
		        .setEnabled(false);
		
		etext.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable s) {
				
				// Check if edittext is empty
		        if (TextUtils.isEmpty(s)) {
		            // Disable ok button
		            ((AlertDialog) alert).getButton(
		                    AlertDialog.BUTTON_POSITIVE).setEnabled(false);
		        } else {
		            // Something into edit text. Enable the button.
		            ((AlertDialog) alert).getButton(
		                    AlertDialog.BUTTON_POSITIVE).setEnabled(true);
		        }
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
			
		});
		
	}
}
