package com.digi.pay.custom.buttons;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.core.content.res.ResourcesCompat;

import com.digi.pay.R;

public class ExtraBoldTextButton extends Button {
    public ExtraBoldTextButton(Context context) {
        super(context);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/montserrat_extrabold.ttf");
        this.setTypeface(face);
    }

    public ExtraBoldTextButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/montserrat_extrabold.ttf");
        this.setTypeface(face);
    }

    public ExtraBoldTextButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/montserrat_extrabold.ttf");
        this.setTypeface(face);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
