package com.digi.pay.ui;

import android.annotation.SuppressLint;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@SuppressLint("Registered")
@EActivity(R.layout.verification_activity)
public class VerificationActivity extends AppCompatActivity {

    @Click(R.id.btn_back)
    public void setBack() {
        finish();
    }
}
