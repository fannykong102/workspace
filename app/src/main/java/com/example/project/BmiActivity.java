package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BmiActivity extends AppCompatActivity {

    class personDataAdapter extends RecyclerView.Adapter<personDataAdapter.ViewHolder> {
        public personDataAdapter(ArrayList<personData> personDataList){
            this.personDataList = personDataList;
        }

        ArrayList<personData> personDataList;
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bmi,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            double h = Double.parseDouble(String.valueOf(personDataList.get(position).height));
            double w = Double.parseDouble(String.valueOf(personDataList.get(position).weight));
            double bmi = w / ((h / 100.0) * (h / 100.0));

            holder.viewHeight.setText(String.valueOf(h));
            holder.viewWeight.setText(String.valueOf(w));

            if(bmi < 18.5){
                holder.viewImage.setImageResource(R.drawable.bmi1);
            }
            else if (bmi < 25){
                holder.viewImage.setImageResource(R.drawable.bmi2);
            }
            else{
                holder.viewImage.setImageResource(R.drawable.bmi3);
            }

        }

        @Override
        public int getItemCount() {
            return personDataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            private final TextView viewHeight;
            private final TextView viewWeight;
            private final ImageView viewImage;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                viewHeight = itemView.findViewById(R.id.tvHeight2);
                viewWeight = itemView.findViewById(R.id.tvWeight2);
                viewImage = itemView.findViewById(R.id.Ivperson);
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        ArrayList<personData> p = new ArrayList<personData>();
        p.add(new personData(190,90));
        p.add(new personData(160, 53));
        p.add(new personData(170,60));
        p.add(new personData(190,90));
        p.add(new personData(160, 65));
        p.add(new personData(170,55));

        RecyclerView recyclerView = findViewById(R.id.rvBMI);
        personDataAdapter a = new personDataAdapter(p);
        recyclerView.setAdapter(a);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}