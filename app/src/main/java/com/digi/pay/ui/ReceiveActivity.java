package com.digi.pay.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;
import org.json.JSONException;
import org.json.JSONObject;


@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.receive_activity)
public class ReceiveActivity extends AppCompatActivity {

    IntentIntegrator qrScan;

    @AfterViews
    public void init() {

        //intializing scan object
        qrScan = new IntentIntegrator(ReceiveActivity.this);

    }

    @Click(R.id.back_btn)
    public void SetBack() {
        finish();
    }

    @Click(R.id.scanner_btn)
    public void ScanQr()
    {
        //initiating the qr code scan
        qrScan.initiateScan();
        qrScan.setOrientationLocked(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(ReceiveActivity.this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    String name  = obj.getString("name");
                    String account_number = obj.getString("account_number");

                    /* Send data to Send Coin Activity*/
                    Bundle basket = new Bundle();
                    basket.putString("account_number", account_number);
                    basket.putString("account_name", name);
                    Intent i = new Intent(this, SendConfirmActivity_.class);
                    i.putExtras(basket);
                    startActivity(i);


                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(ReceiveActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        }


    }
}
