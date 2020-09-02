package com.digi.pay.custom.textviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class BoldTextView extends androidx.appcompat.widget.AppCompatTextView {
    public BoldTextView(Context context) {
        super(context);
        Typeface  face = Typeface.createFromAsset(context.getAssets(), "font/montserrat_bold.ttf");
//        Typeface  face = ResourcesCompat.getFont(context, );
        this.setTypeface(face);
    }

    public BoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/montserrat_bold.ttf");
        this.setTypeface(face);
    }

    public BoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/montserrat_bold.ttf");
        this.setTypeface(face);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
