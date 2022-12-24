package com.example.devinette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList id, nom, score;
    CustomAdapter(Context context, ArrayList id,ArrayList nom, ArrayList score){
        this.context = context;
        //this.id = id;
        this.nom = nom;
        this.score = score;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
      View view =   inflater.inflate(R.layout.myrow, parent, false);
        return  new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

      //  holder.id_text.setText(String.valueOf(id.get(position)));
        holder.nom_text.setText(String.valueOf(nom.get(position)));
        holder.score_text.setText(String.valueOf(score.get(position)));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id_text, nom_text, score_text;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
       // id_text = itemView.findViewById(R.id.id);
        nom_text = itemView.findViewById(R.id.nomj);
        score_text = itemView.findViewById(R.id.scorej);


    }
}
}
