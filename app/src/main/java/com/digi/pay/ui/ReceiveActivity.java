package com.digi.pay.ui;


import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.digi.pay.R;
import com.digi.pay.custom.edittexts.BoldEditText;
import com.digi.pay.custom.edittexts.MediumEditText;
import com.digi.pay.custom.textviews.ExtraBoldTextView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;


@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.receive_activity)
public class ReceiveActivity extends AppCompatActivity {

    @AfterViews
    public void init() {

    }

}
