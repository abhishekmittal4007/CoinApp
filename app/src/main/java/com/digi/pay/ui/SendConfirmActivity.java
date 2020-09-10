package com.digi.pay.ui;

import android.content.Intent;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;
import com.digi.pay.custom.edittexts.BoldEditText;
import com.digi.pay.custom.edittexts.MediumEditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.send_confirm_activity)
public class SendConfirmActivity extends AppCompatActivity {

    @ViewById(R.id.enter_coin)
    BoldEditText enter_coin;

    @ViewById(R.id.continue_btn)
    TextView continue_btn;

    @ViewById(R.id.et_password)
    MediumEditText et_password;

    @AfterViews
    public void init() {

    }

    @Click(R.id.continue_btn)
    public void sedButtonClicked() {
//        if (enter_coin.length() > 0) {
//            enter_coin.setVisibility(View.GONE);
//
//            continue_btn.setVisibility(View.GONE);
//            et_password.setVisibility(View.VISIBLE);
//        } else {
//            Toast.makeText(this, "You must enter coins to send", Toast.LENGTH_SHORT).show();
//        }
        Intent intent = new Intent(this, StatusActivity_.class);
        startActivity(intent);
    }
}
