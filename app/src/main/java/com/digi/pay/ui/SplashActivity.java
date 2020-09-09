package com.digi.pay.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.digi.pay.R;
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

    @AfterViews
    public void init() {
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.montserrat_semibold);
        txt_dig.setTypeface(typeface);
        txt_dig.setAnimationListener(hTextView -> {
            Intent intent = new Intent(this, SignInActivity_.class);
            startActivity(intent);
        });
        txt_dig.animateText("DigiPay");
    }
}
