package com.ksc.moonville;

import android.util.Log;
import android.view.SurfaceHolder;

public class MainGameThread extends Thread {
	//constants
	private static final String TAG = "MainGameThread";
	
	//variables
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private MainGameView gameView;
	
	public MainGameThread(SurfaceHolder surfaceHolder, MainGameView view)
	{
		super();
		this.surfaceHolder = surfaceHolder;
		gameView = view;
	}
	
	public void setRunning(boolean running)
	{
		this.running = running;
	}
	
	public void run()
	{
		//timming variables
		long tickCount = 0L;
		
		Log.d(TAG, "Starting The loop");
		while (running)
		{
			//Log.d(TAG, "Running");
			++tickCount;

			
			//update
			//render
		}
		
		Log.d(TAG, "Ending Game after: " + tickCount + " ticks");
	}
}
