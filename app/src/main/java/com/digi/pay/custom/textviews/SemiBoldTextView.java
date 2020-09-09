package com.digi.pay.custom.textviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class SemiBoldTextView extends androidx.appcompat.widget.AppCompatTextView {
    public SemiBoldTextView(Context context) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_semibold.ttf");
//        Typeface typeface = ResourcesCompat.getFont(context.getApplicationContext(), R.font.montserrat_semibold);
        this.setTypeface(typeface);
    }

    public SemiBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_semibold.ttf");
//        Typeface typeface = ResourcesCompat.getFont(context.getApplicationContext(), R.font.montserrat_semibold);
        this.setTypeface(typeface);
    }

    public SemiBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_semibold.ttf");
//        Typeface typeface = ResourcesCompat.getFont(context.getApplicationContext(), R.font.montserrat_semibold);
        this.setTypeface(typeface);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
