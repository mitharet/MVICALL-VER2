package com.mitha.ver2mvicall;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chaos.view.PinView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class verificationFragment extends BottomSheetDialogFragment {

    public Button lanjut;
    public PinView otp;
    public TextView tv_Warning;

    public verificationFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style. AppBottomSheetDialogTheme);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_verifivation, container);

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        //        //set to adjust screen height automatically, when soft keyboard appears on screen
        //        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        tv_Warning = rootView.findViewById(R.id.tv_warning);
        otp = rootView.findViewById(R.id.pinViewCode);
        lanjut = rootView.findViewById(R.id.buttonNext);
        lanjut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (otp == null) {
                    tv_Warning.setVisibility(View.INVISIBLE);
                } else {
                    startActivity(new Intent(getActivity(), PermissionActivity.class));
                }
            }
        });

        return rootView;
    }
}