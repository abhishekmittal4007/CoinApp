package com.digi.pay.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@SuppressLint("Registered")
@EActivity(R.layout.sign_in_activity)
public class SignInActivity extends AppCompatActivity {

    @Click(R.id.txt_forgot)
    public void forgotPass() {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ForgotPasswordActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.btn_singin)
    public void btnSignIn() {
        Intent intent = new Intent(this, MainActivity_.class);
        startActivity(intent);
    }
}
