package com.mitha.ver2mvicall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class OTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        verificationFragment bottomSheetFragment = new verificationFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }
}
