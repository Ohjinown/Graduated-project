//package com.example.test1;
//
//import android.icu.text.SimpleDateFormat;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.Date;
//
//
//@RequiresApi(api = Build.VERSION_CODES.N)
//public class GpsCheck extends AppCompatActivity {
//
//
//    long now = System.currentTimeMillis();
//    Date date = new Date(now);
//    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    String formatDate = sdfNow.format(date);
//    TextView tv1;
//    Button bu;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gps);
//
//        tv1 = findViewById(R.id.tv1);
//        bu = findViewById(R.id.bu);
//        tv1.setText(formatDate);
//
//        bu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),formatDate,Toast.LENGTH_LONG).show();
//            }
//        });
//
//
//    }
//}
