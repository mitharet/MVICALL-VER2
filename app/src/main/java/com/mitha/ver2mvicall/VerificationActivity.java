package com.mitha.ver2mvicall;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mitha.ver2mvicall.activity.PermissionActivity;
import com.mitha.ver2mvicall.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerificationActivity extends BaseActivity {

    @BindView(R.id.buttonNext)
    Button lanjut;
    @BindView(R.id.parent_view)
    ConstraintLayout mParentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        ButterKnife.bind(this);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerificationActivity.this, PermissionActivity.class);
                startActivity(intent);
            }
        });
        initView();
    }

    private void initView (){
        setKeyboard(mParentLayout);
    }
}
