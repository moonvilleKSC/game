package com.ksc.moonville;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	//constants
	private static final String TAG = "MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//requesting to turn the title off
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//make the game full screen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//set our main game view as the view
		setContentView(new MainGameView(this));
		Log.d(TAG, "View added");
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/
	
	@Override
	protected void onDestroy()
	{
		Log.d(TAG, "Destroy it all!!!");
		super.onDestroy();
	}
	
	@Override
	protected void onStop()
	{
		Log.d(TAG, "Stopping...");
		super.onStop();
	}


}
