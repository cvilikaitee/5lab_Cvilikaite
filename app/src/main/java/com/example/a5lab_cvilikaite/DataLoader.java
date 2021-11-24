package com.example.a5lab_cvilikaite;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class DataLoader extends AsyncTask<Void, Void, ArrayList <String>> {

    protected ArrayList<String> doInBackground(Void... params) {
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return new ArrayList <String>();
        }
    }
}