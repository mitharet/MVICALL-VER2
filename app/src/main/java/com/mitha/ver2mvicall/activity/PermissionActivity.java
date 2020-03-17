package com.mitha.ver2mvicall.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mitha.ver2mvicall.MainActivity;
import com.mitha.ver2mvicall.R;

public class PermissionActivity extends AppCompatActivity {

    Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        lanjut=findViewById(R.id.button3);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PermissionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
