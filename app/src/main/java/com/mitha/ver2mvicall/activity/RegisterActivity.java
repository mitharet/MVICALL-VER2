package com.mitha.ver2mvicall.activity;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mitha.ver2mvicall.R;
import com.mitha.ver2mvicall.VerificationActivity;
import com.mitha.ver2mvicall.base.BaseActivity;
import com.mitha.ver2mvicall.verificationFragment;


import butterknife.BindView;
import butterknife.ButterKnife;


public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.btn_lanjut)
    Button lanjut;
    @BindView(R.id.parent_view)
    ConstraintLayout mParentLayout;
    @BindView(R.id.btn_delete)
    ImageView image;
    @BindView(R.id.tv_warning)
    TextView warning;
    @BindView(R.id.etPhoneNo)
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_aja_constraint);

        ButterKnife.bind(this);

        lanjut.setOnClickListener(this);
        image.setOnClickListener(this);

        initView();

    }

    public void enableeditView(View view){
        if(warning!=null){
            warning.setVisibility(View.VISIBLE);
        }
        image.setVisibility(View.VISIBLE);
    }

    private void initView (){
        setKeyboard(mParentLayout);
    }

    private void closeKeyboard() {
        if (editText != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_lanjut:
//                Intent intent = new Intent(RegisterActivity.this, verificationFragment.class);
//                startActivity(intent);
                View dialogCakra = getLayoutInflater().inflate(R.layout.activity_verification, null);
                BottomSheetDialog dialog = new BottomSheetDialog(this,R.style.AppBottomSheetDialogTheme);
//                BottomSheetDialog dialog = new BottomSheetDialog(this);
                dialog.setContentView(dialogCakra);
                dialog.show();
                break;

            case R.id.btn_delete:
                editText.getText().clear();
                break;

            default:
                break;
        }
    }
}
