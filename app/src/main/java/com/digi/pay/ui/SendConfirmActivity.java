package com.digi.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;
import com.digi.pay.custom.buttons.BoldTextButton;
import com.digi.pay.custom.textviews.BoldTextView;
import com.digi.pay.custom.textviews.RegularTextView;
import com.digi.pay.custom.textviews.SemiBoldTextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.send_confirm_activity)
public class SendConfirmActivity extends AppCompatActivity {

    @ViewById(R.id.enter_coin)
    EditText enter_coin;

    @ViewById(R.id.continue_btn)
    TextView continue_btn;

    @ViewById(R.id.et_password)
    EditText et_password;

    @ViewById(R.id.username)
    SemiBoldTextView username;

    @ViewById(R.id.phone_number)
    RegularTextView accountnumber;

    @ViewById(R.id.confirm_button)
    BoldTextButton confirm_button;

    @ViewById(R.id.total_amount)
    BoldTextView total_amount;

    @AfterViews
    public void init() {

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String account_name = bundle.getString("account_name");
            String account_number = bundle.getString("account_number");

            username.setText(account_name);
            accountnumber.setText(account_number);
        }


    }

    @Click(R.id.continue_btn)
    public void sedButtonClicked() {
        if (enter_coin.length() > 0) {
            enter_coin.setVisibility(View.GONE);
            continue_btn.setVisibility(View.GONE);

            total_amount.setVisibility(View.VISIBLE);
            total_amount.setText("Cn " + enter_coin.getText().toString());
            confirm_button.setVisibility(View.VISIBLE);
            et_password.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "You must enter coins to send", Toast.LENGTH_SHORT).show();
        }
    }

    @Click(R.id.btn_back)
    public void setBtnBack() {
        finish();
    }

    @Click(R.id.confirm_button)
    public void confirmBtn() {
        if (et_password.getText().toString().length() > 0) {
            Intent intent = new Intent(this, StatusActivity_.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }
    }


   /* public void BlurView()
    {

        final View customLayout = getLayoutInflater().inflate(R.layout.aletdialog_password, null);

        new BlurPopupWindow.Builder(SendConfirmActivity.this)
                .setContentView(customLayout)
                .bindClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextView cv = customLayout.findViewById(R.id.textv);
                        if (cv.getText().length()>0)
                        {
                            Toast.makeText(SendConfirmActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, R.id.buttonv)
                .setGravity(Gravity.CENTER)
                .setScaleRatio(0.2f)
                .setBlurRadius(10)
                .setTintColor(0x30000000)
                .build()
                .show();

    }*/


}
