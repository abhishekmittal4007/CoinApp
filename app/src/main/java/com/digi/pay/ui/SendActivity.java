package com.digi.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.R;
import com.digi.pay.adapters.RecentSendAdapter;
import com.digi.pay.view_models.RecentSendData;
import com.google.zxing.integration.android.IntentIntegrator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import java.util.ArrayList;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.send_activity)
public class SendActivity extends AppCompatActivity {

    @ViewById(R.id.recent_sends)
    RecyclerView recent_sends;

    @ViewById(R.id.enter_account_number)
    EditText enter_account_number;

    ArrayList<RecentSendData> myListData;

    @AfterViews
    public void init() {
        myListData = new ArrayList<>();

        myListData.add(new RecentSendData("David Warner", "4589865986", "www.google.com"));
        myListData.add(new RecentSendData("Mitch", "5898565852", "www.google.com"));
        myListData.add(new RecentSendData("Warne", "2545868965", "www.google.com"));
        myListData.add(new RecentSendData("Clay Jenson", "4578956852", "www.google.com"));
        myListData.add(new RecentSendData("Ajit Singh", "3568598568", "www.google.com"));
        myListData.add(new RecentSendData("Ramveer", "5847125689", "www.google.com"));
        myListData.add(new RecentSendData("Ankita", "2145897956", "www.google.com"));
        myListData.add(new RecentSendData("Shaurya", "8856458925", "www.google.com"));
        myListData.add(new RecentSendData("Tom Benton", "4576892535", "www.google.com"));
        myListData.add(new RecentSendData("Justin Folley", "1459798652", "www.google.com"));

        RecentSendAdapter adapter = new RecentSendAdapter(SendActivity.this, myListData);
        recent_sends.setHasFixedSize(true);
        recent_sends.setLayoutManager(new LinearLayoutManager(SendActivity.this));
        recent_sends.setAdapter(adapter);
    }

    @Click(R.id.continue_btn)
    public void setBtnContinue() {
        if (enter_account_number.length() > 0) {
            if (enter_account_number.length() >= 10) {
                Bundle basket = new Bundle();
                basket.putString("account_number", enter_account_number.getText().toString());
                basket.putString("account_name", "Keran Grant");
                Intent i = new Intent(this, SendConfirmActivity_.class);
                i.putExtras(basket);
                startActivity(i);
            } else {
                Toast.makeText(this, "Account Number must be 10 digit or up", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please Enter Account Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Click(R.id.scan_qr_btn)
    public void setScanBtn() {
        //intializing scan object
        IntentIntegrator qrScan = new IntentIntegrator(this);
        //initiating the qr code scan
        qrScan.initiateScan();
        qrScan.setOrientationLocked(true);
    }

    @Click(R.id.btn_back)
    public void setBtnBack() {
        finish();
    }
}
