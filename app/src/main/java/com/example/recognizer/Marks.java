package com.example.recognizer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.List;

public class Marks implements SurfaceHolder.Callback {

    private static String TAG = "Marks";
    
    private Paint visiblePaint = new Paint();
    private Paint invisiblePaint = new Paint();

    private int centimeter = 37;

    private Size size;

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();

        size = new Size(canvas.getWidth(), canvas.getHeight());

        if (canvas == null) {
            Log.e(TAG, "Cannot draw onto the canvas as it's null");
        } else {
            visiblePaint.setColor(Color.argb(150, 100, 20, 50));
            visiblePaint.setStyle(Paint.Style.FILL);

            invisiblePaint.setColor(Color.argb(0, 100, 20, 50));
            invisiblePaint.setStyle(Paint.Style.FILL);

            List<Rect> rectangles = getRectangles();

            for (int i = 0; i < rectangles.size(); i++) {
                if(i == 0 || i == 3) {
                    canvas.drawRect(rectangles.get(i), visiblePaint);
                }
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
        return new Rect((centimeter * 1),
                size.getHeight() - (centimeter * 4),
                (centimeter * 3),
                size.getHeight() - centimeter * 2);
    }

    private Rect getEightth(){
        return new Rect((centimeter * 1),
                size.getHeight() - (centimeter * 8),
                (centimeter * 3),
                size.getHeight() - centimeter * 6);
    }


    private Rect getSecond(){
        return new Rect((centimeter * 4),
                size.getHeight() - (centimeter * 4),
                (centimeter * 6),
                size.getHeight() - centimeter * 2);
    }

    private Rect getSeventh(){
        return new Rect((centimeter * 4),
                size.getHeight() - (centimeter * 8),
                (centimeter * 6),
                size.getHeight() - centimeter * 6);
    }

    private Rect getThird(){
        return new Rect((centimeter * 14),
                size.getHeight() - (centimeter * 4),
                (centimeter * 16),
                size.getHeight() - centimeter * 2);
    }

    private Rect getSixth(){
        return new Rect((centimeter * 14),
                size.getHeight() - (centimeter * 8),
                (centimeter * 16),
                size.getHeight() - centimeter * 6);
    }

    private Rect getFourth(){
        return new Rect((centimeter * 17),
                size.getHeight() - (centimeter * 4),
                (centimeter * 19),
                size.getHeight() - centimeter * 2);
    }

    private Rect getFifth(){
        return new Rect((centimeter * 17),
                size.getHeight() - (centimeter * 8),
                (centimeter * 19),
                size.getHeight() - (centimeter * 6));
    }
    
    public List<Rect> getRectangles() {
        List<Rect> result = new ArrayList<>();
        result.add(getFirst());
        result.add(getSecond());
        result.add(getThird());
        result.add(getFourth());
        result.add(getFifth());
        result.add(getSixth());
        result.add(getSeventh());
        result.add(getEightth());

        return result; 
    }

    public List<Point> getWhitePoints() {
        List<Point> points = new ArrayList<>();

        points.add(new Point(size.getWidth() / 2, size.getHeight() - (centimeter * 2)));

        return points;
    }


}
