package com.example.test1;

import android.Manifest;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class menu extends AppCompatActivity {
    TextView textempNo,textid,textpw,textnm;
    Button button, button1;
    String empNo,id,pw,nm;
    JSONObject memberInfo;
//    private GpsTracker gpsTracker;
//    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
//    private static final int PERMISSIONS_REQUEST_CODE = 100;
//    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
            Log.d("lifecycle", "Menu-oncreate");
    setContentView(R.layout.activity_menu);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xC0C0C0C0));
            textempNo = findViewById(R.id.text);
            textid = findViewById(R.id.text1);
            textpw = findViewById(R.id.text2);
            textnm = findViewById(R.id.text3);
            button = findViewById(R.id.but);
            button1 = findViewById(R.id.but1);


            final Intent intent = new Intent(getApplicationContext(),Informationlookup.class);
            intent.putExtra("empNo",empNo);
//            intent.putExtra("id",id);
            intent.putExtra("id",pw);
            intent.putExtra("id",nm);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"로그아웃",Toast.LENGTH_LONG).show();
                    finish();
                }
            });

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent registerIntent = new Intent(menu.this,MainActivity.class);
                    menu.this.startActivity(registerIntent);

                }
            });

}

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
            MenuInflater inflater = getMenuInflater();

            inflater.inflate(R.menu.main_menu, menu);

            return true;
        }
//        @Override
//        public boolean onOptionsItemSelected (MenuItem item) {
//            Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
//
//            switch (item.getItemId()) {
//                case R.id.menu1:
//                    toast.setText("정보 수정");
//                    Intent intent = new Intent(getApplicationContext(), Informationlookup.class);
//                    try {
//                        intent.putExtra("empNo", memberInfo.getString("empNo"));
//                        intent.putExtra("id",memberInfo.getString("id"));
//                        intent.putExtra("pw",memberInfo.getString("pw"));
//                        intent.putExtra("nm",memberInfo.getString("nm"));
//                        startActivity(intent);
//                    }catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//            }
//            toast.show();
//            return super.onOptionsItemSelected(item);
//        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()) {
                case R.id.menu:
                  Toast.makeText(this,"시간표 이동합니다",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(menu.this,TimeTable.class);
                            menu.this.startActivity(intent);
                            break;


            }
            return super.onOptionsItemSelected(item);

    }


    protected void onStart() {
            super.onStart();
            Log.d("lifecycle", "Menu-onStart");

    }

    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "Menu-onResume");

        Intent intent = getIntent();
        String empNo = intent.getExtras().getString("empNo");
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.43.221:8080/mbr/member?empNo="+empNo;

        // Request a string response from the provided URL.

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject result = response.getJSONObject("result");
                            String empNo = result.getString("empNo");
                          //  String id = result.getString("id");
                            String pw = result.getString("pw");
                            String nm = result.getString("nm");
                            textempNo.setText("학번:"+empNo);
                           // textid.setText("아이디:"+id);
                            textpw.setText("비밀번호"+pw);
                            textnm.setText("이름:"+nm);

                            //사용자정보
                            memberInfo = result;
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "Menu-onPause");

    }

    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "Menu-onStop");

    }
}


