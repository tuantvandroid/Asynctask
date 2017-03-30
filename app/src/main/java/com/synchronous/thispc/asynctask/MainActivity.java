package com.synchronous.thispc.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.text1);
        new AsynctaskNetwork(this,txt1).execute("http://sieuthithehinh.com.vn/huongdan.html");
        //http://icanhazip.com/
        //http://sieuthithehinh.com.vn/huongdan.html
    }

}
