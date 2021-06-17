package com.example.firsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DiamondTasks extends AppCompatActivity {
    private int diamondsCount;
    Button diamondField;

    public int getDiamondsCount() {
        return diamondsCount;
    }

    public void setDiamondsCount(int diamondsCount) {
        this.diamondsCount = diamondsCount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_tasks);
        diamondsCount=0;
        diamondField = findViewById(R.id.ddBtn);

    }
    public void guide(View view) {

        switch (view.getId()) {
            case R.id.instaBtn:
                String url = "https://www.instagram.com/med_lakhdar_idrissi/";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
                diamondsCount += 800;
                diamondField.setText(diamondsCount);
                break;
            case R.id.ytBtn  :
                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse("https://www.youtube.com/channel/UCkRa_3MnkiaBa0Su-1KIJBw"));
                startActivity(j);
                diamondsCount += 800;
                diamondField.setText(diamondsCount);
                break;
            case R.id.task1:
                diamondsCount += 300;
                diamondField.setText(diamondsCount);
                break;
            case R.id.task2:
                diamondsCount += 350;
                diamondField.setText(diamondsCount);
                break;
        }
    }

}