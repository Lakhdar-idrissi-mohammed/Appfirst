package com.example.firsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpinnerActivity extends AppCompatActivity {

    LuckyWheel spinner;
    List<WheelItem> wheelItemList = new ArrayList<>();
    String points;

    private int diamondsCount;
    Button diamondField;

    //    SharedPreferences
    SharedPreferences globalDiamCount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        this.diamondsCount=0;
        diamondField = findViewById(R.id.spinnerDiamCount);

        //        initializing shared pref
        try {
            globalDiamCount = getApplicationContext().getSharedPreferences("diamCountFile", MODE_PRIVATE);
            String data = globalDiamCount.getString("diam","0");
            diamondsCount = Integer.parseInt(data);
            diamondField.setText("💎 "+String.valueOf(this.diamondsCount));
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        spinner = findViewById(R.id.luckyWheel);
        WheelItem wItem1 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.spinnerOrange,null),
                BitmapFactory.decodeResource(getResources(), R.drawable.spinner_diamond), "0");
        WheelItem wItem2 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.spinnerRed,null),
                BitmapFactory.decodeResource(getResources(), R.drawable.spinner_diamond), "10");
        WheelItem wItem3 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.spinnerYellow,null),
                BitmapFactory.decodeResource(getResources(), R.drawable.spinner_diamond), "100");
        WheelItem wItem4 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.spinnerRed,null),
                BitmapFactory.decodeResource(getResources(), R.drawable.spinner_diamond), "200");
        WheelItem wItem5 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.spinnerOrange,null),
                BitmapFactory.decodeResource(getResources(), R.drawable.spinner_diamond), "1000");
        WheelItem wItem6 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.spinnerYellow,null),
                BitmapFactory.decodeResource(getResources(), R.drawable.spinner_diamond), "1500");
        WheelItem wItem7 = new WheelItem(ResourcesCompat.getColor(getResources(),R.color.spinnerRed,null),
                BitmapFactory.decodeResource(getResources(), R.drawable.spinner_diamond), "2000");
        wheelItemList.add(wItem1);
        wheelItemList.add(wItem2);
        wheelItemList.add(wItem3);
        wheelItemList.add(wItem4);
        wheelItemList.add(wItem5);
        wheelItemList.add(wItem6);
        wheelItemList.add(wItem7);
        spinner.addWheelItems(wheelItemList);

        spinner.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                WheelItem itemSelected = wheelItemList.get(Integer.parseInt(points) -1);
                String points_amount = itemSelected.text.toString().trim();
                int diamonds = Integer.parseInt(points_amount);
                diamondsCount += diamonds;
                Toast.makeText(SpinnerActivity.this, " لقد ربحت "+points_amount+" 💎 ", Toast.LENGTH_SHORT).show();
                saveDataToSharedPref(String.valueOf(diamondsCount));
                diamondField.setText("💎 "+String.valueOf(diamondsCount));


            }
        });

    }

    public void BtnClick(View v){
        Random random = new Random();
        points = String.valueOf(random.nextInt(10));
        if (points.equals("0")){
            points = String.valueOf(1);
        }
        spinner.rotateWheelTo(Integer.parseInt(points));
    }


    private void saveDataToSharedPref (String d) {
        try {
            globalDiamCount.edit().putString("diam",d).apply();
        }catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

    }






}