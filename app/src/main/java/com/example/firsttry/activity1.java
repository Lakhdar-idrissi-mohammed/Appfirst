package com.example.firsttry;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GuideData[] guideData = new GuideData[]{
                new GuideData(R.string.book_1_title,R.drawable.headshot,R.drawable.next),
                new GuideData(R.string.book_2_title,R.drawable.charac,R.drawable.next),
                new GuideData(R.string.book_3_title,R.drawable.gun,R.drawable.next),
                new GuideData(R.string.book_4_title,R.drawable.pro,R.drawable.next),
        };

        GuideAdapter guideAdapter = new GuideAdapter(guideData,activity1.this);
        recyclerView.setAdapter(guideAdapter);

    }



}