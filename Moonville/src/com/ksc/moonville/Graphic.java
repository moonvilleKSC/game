package com.ksc.moonville;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Graphic {
    //variables
    float xPos, yPos;
    
    Depth depth;
    
    private Bitmap image;
    
    /*
     * Constructors
     */
    public Graphic(Bitmap bitmap)
    {
        image = bitmap;
    }
    
    public Graphic(Bitmap bitmap, float x, float y)
    {
        
    }
    
    //draw function
    void Draw(Canvas canvas)
    {
        canvas.drawBitmap(image, xPos, yPos, null);
    }
    
}
