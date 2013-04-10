package com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.action.OnClickExit;
import com.example.testandroidadt.R;

public class MainActivity extends Activity {

	private AlertDialog.Builder alertDialogBuilder;
	private Dialog dialog;
	private final Context context = this;
	private final String[] values = new String[] { "Taeyeon", "Android",
			"iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu",
			"Windows7", "Max OS X", "Linux", "OS/2", "Window8", "Nokia" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		alertDialogBuilder = new AlertDialog.Builder(context);
		dialog = alertDialogBuilder.create();

		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.mylist);

		Button button = (Button) findViewById(R.id.exit);
		button.setOnClickListener(new OnClickExit(this, alertDialogBuilder,
				context));

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Assign adapter to ListView
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				// Set title by name in listView
				dialog.setTitle(values[position]);

				if (values[position].equals("Taeyeon")) {
					// Generate new activity and start it
					Intent intent = new Intent(context, ShowImageActivity.class);
					startActivity(intent);
					dialog.cancel();
				} else {
					dialog.show();
				}
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
