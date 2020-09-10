package com.digi.pay.custom.textviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RegularTextView extends androidx.appcompat.widget.AppCompatTextView {
    public RegularTextView(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_regular.ttf");
        this.setTypeface(typeface);
    }

    public RegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_regular.ttf");
        this.setTypeface(typeface);
    }

    public RegularTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_regular.ttf");
        this.setTypeface(typeface);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
