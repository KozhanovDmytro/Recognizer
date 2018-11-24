package com.example.recognizer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.List;

public class Recognizer{

    private Bitmap bitmap;

    private List<Rect> rectangles;

    private boolean result;



    public boolean recognize() {
        result = false;

        Bitmap bitmap = blackWhite(this.bitmap);

        int count = 0;
        for (Rect rect : rectangles) {
            if(bitmap.getPixel(rect.centerX(), rect.centerY()) < -10000000) {
                count++;
            }
        }

        if(count == rectangles.size()) {
            result = true;
        }

        return result;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setRectangles(List<Rect> rectangles) {
        this.rectangles = rectangles;
    }

    public boolean isResult() {
        return result;
    }

    private Bitmap blackWhite(Bitmap bitmap) {
        Bitmap bmpMonochrome = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpMonochrome);
        ColorMatrix ma = new ColorMatrix();
        ma.setSaturation(0);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(ma));
        canvas.drawBitmap(bitmap, 0, 0, paint);

        return bitmap;
    }
}
