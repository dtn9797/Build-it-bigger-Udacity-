package com.example.showjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jokeproviderlib.MyClass;

public class DetailActivity extends AppCompatActivity {

    TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        jokeTv = findViewById(R.id.joke_tv);
        jokeTv.setText(getIntent().getStringExtra("joke"));
    }
}
