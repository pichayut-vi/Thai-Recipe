package com.example.action;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

public class OnClickExit implements OnClickListener {

	private AlertDialog.Builder alertDialogBuilder;
	private Context context;
	private Activity activity;

	public OnClickExit(Activity activity,
			AlertDialog.Builder alertDialogBuilder, Context context) {
		this.activity = activity;
		this.alertDialogBuilder = alertDialogBuilder;
		this.context = context;
	}

	/**
	 * Call the method confirm to exit application
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		alertDialogBuilder = new AlertDialog.Builder(context);

		// Do something in response to button click
		alertDialogBuilder.setTitle("Confirmation");
		alertDialogBuilder
				.setMessage("Are you sure ?")
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, close
						// current activity
						activity.finish();
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						});

		Dialog dialog = alertDialogBuilder.create();
		dialog.show();
	}
}
