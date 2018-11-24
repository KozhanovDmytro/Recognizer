package com.example.recognizer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.List;

public class Marks implements SurfaceHolder.Callback {

    private static String TAG = "Marks";
    
    private Paint paint = new Paint();

    private int centimeter = 37;

    private Size size;

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();

        size = new Size(canvas.getWidth(), canvas.getHeight());

        if (canvas == null) {
            Log.e(TAG, "Cannot draw onto the canvas as it's null");
        } else {
            paint.setColor(Color.argb(150, 100, 20, 50));
            paint.setStyle(Paint.Style.FILL);

            for (Rect rectangle : getRectangles()) {
                canvas.drawRect(rectangle, paint);
            }
            
            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private Rect getFirst(){
        return new Rect((centimeter * 2),
                size.getHeight() - (centimeter * 2),
                (centimeter * 4),
                size.getHeight() - centimeter);
    }
    private Rect getSecond(){
        return new Rect((centimeter * 5),
                size.getHeight() - (centimeter * 2),
                (centimeter * 7),
                size.getHeight() - centimeter);
    }

    private Rect getThird(){
        return new Rect((centimeter * 14),
                size.getHeight() - (centimeter * 2),
                (centimeter * 16),
                size.getHeight() - centimeter);
    }

    private Rect getFourth(){
        return new Rect((centimeter * 17),
                size.getHeight() - (centimeter * 2),
                (centimeter * 19),
                size.getHeight() - centimeter);
    }

    private Rect getFifth(){
        return new Rect((centimeter * 17),
                size.getHeight() - (centimeter * 4),
                (centimeter * 19),
                size.getHeight() - (centimeter * 3));
    }
    
    public List<Rect> getRectangles() {
        List<Rect> result = new ArrayList<>();
        result.add(getFirst());
        result.add(getSecond());
        result.add(getThird());
        result.add(getFourth());
        result.add(getFifth());
        
        return result; 
    }


}
