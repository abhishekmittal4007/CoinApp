package com.digi.pay.ui;

import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;
import com.digi.pay.fragments.FragmentSignIn;
import com.digi.pay.fragments.FragmentSignIn_;
import com.digi.pay.utils.Utility;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_signin)
public class SignInActivity extends AppCompatActivity {

    @AfterViews
    public void init() {
        Utility.showFragment(this, new FragmentSignIn_()
                , R.id.main_frame, null, FragmentSignIn.class.getSimpleName());
    }
}