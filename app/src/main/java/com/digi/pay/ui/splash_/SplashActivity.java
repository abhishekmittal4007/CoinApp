package com.digi.pay.ui.splash_;

import android.annotation.SuppressLint;
import android.graphics.Typeface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.digi.pay.R;
import com.hanks.htextview.typer.TyperTextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class SplashActivity extends AppCompatActivity {

    @ViewById(R.id.txt_digi)
    TyperTextView txt_dig;
    @ViewById(R.id.txt_pay)
    TyperTextView txt_pay;

    @AfterViews
    public void init() {
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.montserrat_extrabold);
        txt_dig.setTypeface(typeface);
        txt_pay.setTypeface(typeface);
        txt_dig.setAnimationListener(hTextView -> txt_pay.animate());
        txt_dig.animate();
//            txt_dig.setTypeface(getResources().getFont(R.font.montserrat_bold));
    }
}
