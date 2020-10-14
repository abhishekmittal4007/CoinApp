package com.digi.pay.custom.edittexts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.google.android.material.textfield.TextInputEditText;

public class PassWordET extends TextInputEditText {
    private Context context;
    private AttributeSet attrs;
    private int defStyle;

    public PassWordET(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PassWordET(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        init();
    }

    public PassWordET(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.attrs = attrs;
        this.defStyle = defStyle;
        init();
    }

    private void init() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_medium.ttf");
        this.setTypeface(font);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_medium.ttf");
        super.setTypeface(tf, style);
    }

    @Override
    public void setTypeface(Typeface tf) {
        tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/montserrat_medium.ttf");
        super.setTypeface(tf);
    }
}
