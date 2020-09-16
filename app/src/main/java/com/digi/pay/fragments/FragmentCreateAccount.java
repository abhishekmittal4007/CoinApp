package com.digi.pay.fragments;

import android.annotation.SuppressLint;
import android.text.method.PasswordTransformationMethod;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.custom.edittexts.MediumEditText;
import com.digi.pay.ui.CreateAccountActivity;
import com.digi.pay.utils.Utility;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_create_an_account)
public class FragmentCreateAccount extends Fragment {

    @ViewById(R.id.et_password)
    MediumEditText et_password;

    @ViewById(R.id.et_name)
    MediumEditText et_name;

    @ViewById(R.id.et_number)
    MediumEditText et_number;

    @ViewById(R.id.show_pass_btn)
    ImageView show_pass_btn;

    boolean isShowPassword = false;

    @ViewById(R.id.et_re_password)
    MediumEditText et_re_password;

    @ViewById(R.id.show_repass_btn)
    ImageView showRePassButtoon;

    boolean isShowRePassword;

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
         /* Utility.showFragment(getActivity(), new FragmentAadharCard_()
                , R.id.main_frame, null, FragmentAadharCard.class.getSimpleName());*/
        Validations();
    }


    @Click(R.id.show_pass_btn)
    public void ShowHidePass()
    {
        if (isShowPassword)
        {
         et_password.setTransformationMethod(new PasswordTransformationMethod());
         show_pass_btn.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_eye));
         isShowPassword  = false;
        }
        else
        {
            et_password.setTransformationMethod(null);
            show_pass_btn.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_eye)); // need to replace with cut eye
            isShowPassword  = true;
        }

    }

    @Click(R.id.show_repass_btn)
    public void ShowHideRePass()
    {
        if (isShowRePassword)
        {
            et_re_password.setTransformationMethod(new PasswordTransformationMethod());
            showRePassButtoon.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_eye));
            isShowRePassword  = false;
        }
        else
        {
            et_re_password.setTransformationMethod(null);
            showRePassButtoon.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_eye)); // need to replace with cut eye
            isShowRePassword  = true;
        }

    }

    public void Validations()
    {
        if (et_name.getText().length()>0 && et_number.getText().length()>0 && et_password.getText().length()>0 && et_re_password.getText().length()>0)
        {
            if (et_number.getText().toString().replaceAll("-","").length()!=10)
            {
                Toast.makeText(getActivity(), "Phone Number must be of 10 Digit", Toast.LENGTH_SHORT).show();
            }
            else if (!et_password.getText().toString().equalsIgnoreCase(et_re_password.getText().toString()))
            {
                Toast.makeText(getActivity(), "Password Should Match", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Utility.showFragment(getActivity(), new FragmentAadharCard_()
                        , R.id.main_frame, null, FragmentAadharCard.class.getSimpleName());
            }

        }
        else
        {
            Toast.makeText(getActivity(), "Please Fill-Up All Fields", Toast.LENGTH_SHORT).show();
        }
    }



}
