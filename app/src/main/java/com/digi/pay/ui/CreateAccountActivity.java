package com.digi.pay.ui;

import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.digi.pay.R;
import com.digi.pay.custom.StepperIndicator;
import com.digi.pay.fragments.FragmentCreateAccount;
import com.digi.pay.fragments.FragmentCreateAccount_;
import com.digi.pay.utils.Utility;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_createacc)
public class CreateAccountActivity extends AppCompatActivity {

    @ViewById(R.id.step_indicator)
    public StepperIndicator step_indicator;

    @AfterViews
    public void init() {
        Utility.showFragment(this, new FragmentCreateAccount_()
                , R.id.main_frame, null, FragmentCreateAccount.class.getSimpleName());
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}