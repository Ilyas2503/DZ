package com.example.dz1_35;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText rsk,theme,mess;
    private Button camera, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListeners();

    }

    private void initListeners() {
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{rsk.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,theme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,mess.getText().toString());
                startActivity(intent);
            }
        });


    }


    private void initView() {
        rsk = findViewById(R.id.rsk_ET);
        theme = findViewById(R.id.theme_ET);
        mess = findViewById(R.id.mes_id);
        camera = findViewById(R.id.camera_btn);
        next = findViewById(R.id.next_bt);
    }


}