package com.digi.pay.ui;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;
import com.digi.pay.custom.textviews.ExtraBoldTextView;
import com.digi.pay.utils.PreferenceManger;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.json.JSONException;
import org.json.JSONObject;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;


@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.receive_activity)
public class ReceiveActivity extends AppCompatActivity {

    @ViewById(R.id.user_qr)
    ImageView user_qr;

    @ViewById(R.id.username)
    ExtraBoldTextView username;

    IntentIntegrator qrScan;

    String User_name;

    boolean isDataAvailable = false;

    @AfterViews
    public void init() {
        //intializing scan object

        if (PreferenceManger.getObject("signup_data")!=null)
        {
            isDataAvailable = true;
            User_name = PreferenceManger.getObject("signup_data").getFullname();
            username.setText(PreferenceManger.getObject("signup_data").getFullname());
        }
        else
        {
            isDataAvailable = false;
        }

        qrScan = new IntentIntegrator(ReceiveActivity.this);
        try {
            Bitmap bitmap;
            if (isDataAvailable)
            {
                 bitmap = encodeAsBitmap("{\"name\":\"Mohit Bhargava\", \"account_number\":\"2938120947\"}");
            }
            else
            {
                 bitmap = encodeAsBitmap("{\"name\":\"Mohit Bhargava\", \"account_number\":\"2938120947\"}");
            }
            user_qr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    @Click(R.id.back_btn)
    public void SetBack() {
        finish();
    }

    @Click(R.id.scanner_btn)
    public void ScanQr() {
        //initiating the qr code scan
//        qrScan.initiateScan();
//        qrScan.setOrientationLocked(true);
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
                    String name = obj.getString("name");
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

    Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, 512, 512, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, 512, 0, 0, w, h);
        return bitmap;
    }
}
