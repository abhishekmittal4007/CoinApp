package com.digi.pay.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.digi.pay.R;
import com.digi.pay.utils.PreferenceManger;
import com.digi.pay.view_models.SignUpPojo;
import com.hanks.htextview.fade.FadeTextView;
import com.hanks.htextview.typer.TyperTextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@SuppressLint("Registered")
@EActivity(R.layout.splash_activity)
public class SplashActivity extends AppCompatActivity {

    @ViewById(R.id.txt_digi_)
    TyperTextView txt_dig;
    @ViewById(R.id.txt_digi_sub)
    FadeTextView txt_digi_sub;

    @AfterViews
    public void init() {
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.montserrat_semibold);
        txt_dig.setTypeface(typeface);
        txt_digi_sub.setTypeface(typeface);
        txt_dig.setAnimationListener(hTextView -> {
            txt_digi_sub.setVisibility(View.VISIBLE);
            txt_digi_sub.animateText("Digital India | Digital Cash");
        });
        txt_digi_sub.setAnimationListener(hTextView -> {

            SignUpPojo signUpPojo = PreferenceManger.getObject("signup_data");

            if (signUpPojo!=null)
            {
                Intent intent = new Intent(this, MainActivity_.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Intent intent = new Intent(this, SignInActivity_.class);
                startActivity(intent);
                finish();
            }

        });
        txt_dig.animateText("DigiPay");
    }
}
