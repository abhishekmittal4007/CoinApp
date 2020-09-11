package com.digi.pay.ui;


import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;


@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.receive_activity)
public class ReceiveActivity extends AppCompatActivity {

    @AfterViews
    public void init() {

    }

    @Click(R.id.back_btn)
    public void SetBack() {
        finish();
    }
}
