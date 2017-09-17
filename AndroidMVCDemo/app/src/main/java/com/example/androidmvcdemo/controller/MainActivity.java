package com.example.androidmvcdemo.controller;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.androidmvcdemo.R;
import com.example.androidmvcdemo.model.Model;

public class MainActivity extends AppCompatActivity implements Model.OnStateChangeListener {
    private Model model;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Model(this);
        model.registerOnStateChangeListener(this);

        imageView = (ImageView)findViewById(R.id.iv_main);
        /*imageView.setImageBitmap(model.getImage());*/
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bnt_main_load:
                model.loadImage();
                break;
            case R.id.bnt_main_clear:
                model.clear();
                break;
            default:
                break;
        }
    }

    @Override
    public void onStateChanged(Bitmap image) {
        imageView.setImageBitmap(image);
    }
}
