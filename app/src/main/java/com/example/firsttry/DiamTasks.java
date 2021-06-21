package com.example.firsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DiamTasks extends AppCompatActivity {

    private int diamondsCount;
    Button diamondField;

//    SharedPreferences
    SharedPreferences globalDiamCount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diam_tasks);

        this.diamondsCount=0;
        diamondField = findViewById(R.id.ddBtn);

//        initializing shared pref
        try {
            globalDiamCount = getApplicationContext().getSharedPreferences("diamCountFile", MODE_PRIVATE);
            String data = globalDiamCount.getString("diam","0");
            diamondsCount = Integer.parseInt(data);
            diamondField.setText("💎 "+String.valueOf(this.diamondsCount));
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }




    }
    public void guid(View view) {

        switch (view.getId()) {
            case R.id.instaBtn:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/med_lakhdar_idrissi/"));
                startActivity(i);
                this.diamondsCount += 800;
                saveDataToSharedPref(diamondsCount);
                diamondField.setText("💎 "+String.valueOf(this.diamondsCount));
                break;
            case R.id.ytBtn  :
                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse("https://www.youtube.com/channel/UCkRa_3MnkiaBa0Su-1KIJBw"));
                startActivity(j);
                diamondsCount += 800;
                saveDataToSharedPref(diamondsCount);
                diamondField.setText("💎 "+String.valueOf(this.diamondsCount));
                break;
            case R.id.task1:
                diamondsCount += 300;
                saveDataToSharedPref(diamondsCount);
                diamondField.setText("💎 "+String.valueOf(this.diamondsCount));
                break;
            case R.id.task2:
                diamondsCount += 300;
                saveDataToSharedPref(diamondsCount);
                diamondField.setText("💎 "+String.valueOf(diamondsCount));
                break;
        }
    }
    private void saveDataToSharedPref (int d) {
        try {
            globalDiamCount.edit().putString("diam",String.valueOf(d)).apply();
        }catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

    }
}