package com.digi.pay.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.status_activity)
public class StatusActivity extends AppCompatActivity {

    @AfterViews
    public void init() {

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(StatusActivity.this, MainActivity_.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();

            }
        }, 3000);

    }

}