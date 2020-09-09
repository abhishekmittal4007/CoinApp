package com.digi.pay.custom.textviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.core.content.res.ResourcesCompat;

import com.digi.pay.R;

public class ExtraBoldTextView extends androidx.appcompat.widget.AppCompatTextView {
    public ExtraBoldTextView(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_extrabold.ttf");
        this.setTypeface(typeface);
    }

    public ExtraBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_extrabold.ttf");
        this.setTypeface(typeface);
    }

    public ExtraBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_extrabold.ttf");
        this.setTypeface(typeface);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
