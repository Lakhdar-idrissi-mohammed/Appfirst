package com.example.firsttry;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.ViewHolder> {
    GuideData[] guideData;
    Context context;
    public GuideAdapter(GuideData[] guideData, activity1 activity) {
        this.guideData = guideData;
        this.context = activity;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.guidelist,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GuideData guideDataList = guideData[position];
        holder.textViewName.setText(guideDataList.getGuideTitle());
        holder.guideImage.setImageResource(guideDataList.getGuideImage());
        holder.imageButton.setImageResource(guideDataList.getGuidebtn());
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,popup1Activity.class);
                context.startActivity(intent);

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, guideDataList.getGuideTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return guideData.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView guideImage;
        TextView textViewName;
        ImageButton imageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guideImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            imageButton = itemView.findViewById(R.id.imageButton);
        }
    }

}

