package com.rilixtech.widget.countrycodepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.FrameLayout;

public class RoundCornerLayout extends FrameLayout {

    private float CORNER_RADIUS = 50.0f;
    private float cornerRadius;
    private Paint paint;
    private Paint maskPaint;
    private DisplayMetrics metrics;

    public RoundCornerLayout(Context context)
    {
        super(context);
        init(context, null, 0);
    }

    public RoundCornerLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RoundCornerLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr)
    {
        metrics = context.getResources().getDisplayMetrics();

        cornerRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, CORNER_RADIUS, metrics);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        maskPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

        setWillNotDraw(false);
    }

    @Override
    public void draw(Canvas canvas)
    {
        Bitmap offscreenBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas offscreenCanvas = new Canvas(offscreenBitmap);

        super.draw(offscreenCanvas);
        Bitmap maskBitmap = createMask(canvas.getWidth(), canvas.getHeight());
        if (maskBitmap != null)
        {
            offscreenCanvas.drawBitmap(maskBitmap, 0f, 0f, maskPaint);
            canvas.drawBitmap(offscreenBitmap, 0f, 0f, paint);
        }

    }

    private Bitmap createMask(int width, int height)
    {
        Bitmap mask = Bitmap.createBitmap(width,height, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(mask);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);

        canvas.drawRect(0, 0, width, height, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawRoundRect(new RectF(0, 0, width, height), cornerRadius, cornerRadius, paint);

        return mask;
    }

    public void setCornerRadius(float myCornerRadius)
    {
        CORNER_RADIUS = myCornerRadius;
        cornerRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, CORNER_RADIUS, metrics);
        this.invalidate();
    }

}
