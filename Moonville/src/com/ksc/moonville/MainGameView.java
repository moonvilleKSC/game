package com.ksc.moonville;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGameView  extends SurfaceView implements 
	SurfaceHolder.Callback{
	//constants
	private static final String TAG = "MainGameView";
	
	//variables
	private MainGameThread gameThread;
	
	
	public MainGameView(Context context)
	{
		super(context);
		//adding the callback to the surface holder so it can interpret events
		getHolder().addCallback(this);
		//make the game view focusable
		setFocusable(true);
		
		//make new thread
		gameThread = new MainGameThread(getHolder(), this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		
		gameThread.setRunning(true);
		gameThread.start();
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		boolean retry = true;
		while(retry)
		{
			try {
				gameThread.join();
				retry = false;
			} catch (InterruptedException e) {
				//try to shut down thread
			}
		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			if(event.getY() > getHeight() - 50)
			{
				//end the game
				gameThread.setRunning(false); // stops the thread
				((Activity) getContext() ).finish(); //finishes the main activity
			}
			else
			{
				//output the cords
				Log.d(TAG, "Coords: X = " + event.getX() + 
						", y = " + event.getY());
			}
		}
		
		return super.onTouchEvent(event);
	}
	
	@Override
	public void onDraw(Canvas canvas)
	{
		
	}
	
}
