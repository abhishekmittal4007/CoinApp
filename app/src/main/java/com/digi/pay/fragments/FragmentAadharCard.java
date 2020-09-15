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
@EFragment(R.layout.fragment_adhar_card)
public class FragmentAadharCard extends Fragment {

    @AfterViews
    public void init() {
        ((CreateAccountActivity) requireActivity()).step_indicator.setCurrentStep(1);
    }

    @Click(R.id.btn_back)
    public void setBack() {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    @Click(R.id.btn_cntn)
    public void setSendOtp() {
        Utility.showFragment(getActivity(), new Fragment_Verification_()
                , R.id.main_frame, null, Fragment_Verification.class.getSimpleName());
    }
}
