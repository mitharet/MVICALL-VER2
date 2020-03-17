package com.mitha.ver2mvicall.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

public class Utils extends AppCompatActivity {

    public static int convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float pixel = dp * ((float) displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) pixel;
    }

    public static int[] getScreenSize(Context context){
        int[] screenSize = new int[2];
        screenSize[0] = context.getResources().getDisplayMetrics().widthPixels;
        screenSize[1] = context.getResources().getDisplayMetrics().heightPixels;
        return screenSize;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

}
