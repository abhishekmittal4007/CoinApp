package com.digi.pay.fragments;

import android.annotation.SuppressLint;
import android.text.method.PasswordTransformationMethod;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_new_password)
public class FragmentNewPassword extends Fragment {

    @ViewById(R.id.et_new_password)
    TextView et_new_password;
    @ViewById(R.id.et_cnfm_password)
    TextView et_cnfm_password;

    @AfterViews
    public void init() {
        et_new_password.setTransformationMethod(new PasswordTransformationMethod());
        et_cnfm_password.setTransformationMethod(new PasswordTransformationMethod());
    }

    @Click(R.id.btn_back)
    public void setBack() {
        requireActivity().getSupportFragmentManager().popBackStack();
    }
}
