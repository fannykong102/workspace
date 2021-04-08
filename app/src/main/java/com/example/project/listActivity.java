package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class listActivity extends AppCompatActivity {

    class personAdapter extends RecyclerView.Adapter<personAdapter.personViewHolder>{
        public personAdapter(@NonNull List<personData> personList) {
            this.personList = personList;
        }

        @NonNull

        List<personData> personList;

        @Override
        public personViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bmilist,parent,false);
            return new personViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull personViewHolder holder, int position) {
            personData p = personList.get(position);
            holder.height.setText(String.valueOf(p.getHeight()));
            holder.weight.setText(String.valueOf(p.getWeight()));

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class personViewHolder extends RecyclerView.ViewHolder{

            private final TextView height;
            private final TextView weight;

            public personViewHolder(@NonNull View itemView) {
                super(itemView);
                height = itemView.findViewById(R.id.tvShowHeight);
                weight = itemView.findViewById(R.id.tvShowWeight);
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //List<personData> personDataList = List.of(new personData(180, 80),new personData(150, 52));
        //List<personData> personDataList = new ArrayList<>();
        //personDataList.add();
        RecyclerView recyclerView = findViewById((R.id.rvBMI));
        //personAdapter person_adapter = new personAdapter(personDataList);
        //recyclerView.setAdapter(person_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}