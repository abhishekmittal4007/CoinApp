package com.digi.pay.fragments;

import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.ui.CreateAccountActivity;
import com.digi.pay.utils.Utility;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_create_an_account)
public class FragmentCreateAccount extends Fragment {

    @AfterViews
    public void init() {
        ((CreateAccountActivity) requireActivity()).step_indicator.setCurrentStep(0);
    }

    @Click(R.id.btn_back)
    public void setBack() {
        requireActivity().finish();
    }

    @Click(R.id.btn_sendOtp)
    public void setSendOtp() {
        Utility.showFragment(getActivity(), new FragmentAadharCard_()
                , R.id.main_frame, null, FragmentAadharCard.class.getSimpleName());
    }
}
