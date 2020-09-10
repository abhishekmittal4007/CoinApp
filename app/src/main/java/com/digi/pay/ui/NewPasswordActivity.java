package com.digi.pay.ui;

import android.annotation.SuppressLint;
import android.text.method.PasswordTransformationMethod;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@SuppressLint("Registered")
@EActivity(R.layout.new_password_activity)
public class NewPasswordActivity extends AppCompatActivity {

    @ViewById(R.id.et_new_password)
    TextView et_new_password;
    @ViewById(R.id.et_cnfm_password)
    TextView et_cnfm_password;

    @AfterViews
    public void init() {
        et_new_password.setTransformationMethod(new PasswordTransformationMethod());
        et_cnfm_password.setTransformationMethod(new PasswordTransformationMethod());
    }

    @Click(R.id.btn_back)
    public void setBack() {
        finish();
    }
}
