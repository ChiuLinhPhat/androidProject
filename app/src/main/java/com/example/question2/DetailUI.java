package com.example.question2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detail_ui);
    }
}