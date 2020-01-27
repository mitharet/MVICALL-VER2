package com.mitha.ver2mvicall;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mitha.ver2mvicall.base.BaseActivity;


import butterknife.BindView;
import butterknife.ButterKnife;


public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.button2)
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
        setContentView(R.layout.risetotp);

        ButterKnife.bind(this);

        lanjut.setOnClickListener(this);
        image.setOnClickListener(this);
        initView();

    }

    private void initView (){
        setKeyboard(mParentLayout);

    }

    public void enableeditView(View view){
        if(warning!=null){
            warning.setVisibility(View.VISIBLE);
        }
        image.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button2:
                Intent intent = new Intent(RegisterActivity.this, VerificationActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_delete:
                editText.getText().clear();
                break;

            default:
                break;
        }
    }
}
