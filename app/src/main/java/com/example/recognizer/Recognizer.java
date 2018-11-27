package com.example.recognizer;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import java.util.List;

public class Recognizer {

    private Bitmap bitmap;

    private List<Rect> rectangles;

    private List<Point> whitePoints;

    public Recognizer(Bitmap bitmap, List<Rect> rectangles, List<Point> whitePoints) {
        this.bitmap = bitmap;
        this.rectangles = rectangles;
        this.whitePoints = whitePoints;
    }

    public boolean recognize() {
        boolean result = false;

        if(bitmap == null || rectangles == null) {
            throw new IllegalArgumentException();
        }


        Log.e("Recognize", "Start recognizing");
//        convertArgbToOneColor(this.bitmap);

//        System.out.println(bitmap.getPixel(rectangles.get(0).left, rectangles.get(0).top));

        int countRect = 0;
        for (Rect rect : rectangles) {
            if(bitmap.getPixel(rect.centerX(), rect.centerY()) < -10000000) {
                countRect++;
            }
        }

        int countWhitePoint = 0;
        for (Point point : whitePoints) {
            if(bitmap.getPixel(point.x, point.y) > -10000000) {
                countWhitePoint++;
            }
        }

        if(countRect == rectangles.size() && countWhitePoint == whitePoints.size()) {
            result = true;
        }

        Log.e("Recognize", "End recognizing");

        return result;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setRectangles(List<Rect> rectangles) {
        this.rectangles = rectangles;
    }

    private void convertArgbToOneColor (Bitmap bitmap) {
        int k = 0;

        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++, k++) {
                int pixel = bitmap.getPixel(x, y);

                int R = Color.red(pixel);
                int G = Color.green(pixel);
                int B = Color.blue(pixel);

                R = (int) (0.299 * R + 0.587 * G + 0.114 * B);

                if (R < 128) {
                    bitmap.setPixel(x, y, 0);
                } else {
                    bitmap.setPixel(x, y, 1);
                }
            }
        }
    }
}
