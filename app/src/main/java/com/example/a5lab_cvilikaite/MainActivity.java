package com.example.a5lab_cvilikaite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContent;
    TextView tvContent;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvContent = findViewById(R.id.listView);
        this.tvContent = findViewById(R.id.tvContent);
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Loading...");
        new DataLoader(){
            @Override
            public void onPostExecute(ArrayList<String> result)
            {

                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,result);
                lvContent.setAdapter(adapter);
            }
        }.execute();
        this.tvContent.setText("");
        Toast.makeText(getApplicationContext(), "Data has been downloaded",Toast.LENGTH_LONG).show();

    }
}