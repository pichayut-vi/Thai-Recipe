package com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.testandroidadt.R;
import com.example.util.Util;

public class ShowImageActivity extends Activity {

	private AlertDialog.Builder alertDialogBuilder;
	private final Context context = this;
	private ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.image_item);

		imageView = (ImageView) findViewById(R.id.taeyeon1);

		// The image is coming from resource folder but it could also
		// load from the internet or whatever
		Drawable drawable = getResources().getDrawable(R.drawable.taeyeon);
		Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

		// Get scaling factor to fit the max possible width of the ImageView
		float scalingFactor = this.getBitmapScalingFactor(bitmap);

		// Create a new bitmap with the scaling factor
		Bitmap newBitmap = Util.ScaleBitmap(bitmap, scalingFactor);

		// Set the bitmap as the ImageView source
		this.imageView.setImageBitmap(newBitmap);

	}

	private float getBitmapScalingFactor(Bitmap bm) {
		// Get display width from device
		int displayWidth = getWindowManager().getDefaultDisplay().getWidth();

		// Get margin to use it for calculating to max width of the ImageView
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.imageView
				.getLayoutParams();
		int leftMargin = layoutParams.leftMargin;
		int rightMargin = layoutParams.rightMargin;

		// Calculate the max width of the imageView
		int imageViewWidth = displayWidth - (leftMargin + rightMargin);

		// Calculate scaling factor and return it
		return ((float) imageViewWidth / (float) bm.getWidth());
	}
}
