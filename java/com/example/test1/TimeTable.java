package com.example.test1;

import android.app.AppComponentFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TimeTable extends AppCompatActivity {
//    Button bu3;
   ImageView image;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFFFFF));
    };

}
