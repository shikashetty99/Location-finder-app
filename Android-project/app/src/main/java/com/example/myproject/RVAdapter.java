package com.example.myproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolderClass> {
    ArrayList<ModelClass> objectModelClassList;
    public RVAdapter(ArrayList<ModelClass> objectModelClassList) {
        this.objectModelClassList = objectModelClassList;
    }



    @NonNull
    @Override
    public RVViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RVViewHolderClass(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.single_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolderClass holder, int position) {
        ModelClass objectModel=objectModelClassList.get(position);
        holder.t1.setText(objectModel.getImageName());
        holder.i1.setImageBitmap(objectModel.getImage());

    }

    @Override
    public int getItemCount() {
        return objectModelClassList.size();
    }

    public static class RVViewHolderClass extends RecyclerView.ViewHolder
    {
        TextView t1;
        ImageView i1;

        public RVViewHolderClass(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.imageDetailesTV);
            i1=itemView.findViewById(R.id.imageIV);
        }
    }
}
