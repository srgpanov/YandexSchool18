package com.srgpanov.yandexschool18;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;

import com.srgpanov.yandexschool18.View.MainActivity;

public class ScreenResolution extends MainActivity {
    public static int getWidthDisplay(Context context){

        Display display = ((WindowManager) context.getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        int width = p.x;
        int height = p.y;
        return width;
    }
    public static int getHeightDisplay(Context context){

        Display display = ((WindowManager) context.getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        int height = p.y;
        return height;
    }
}
