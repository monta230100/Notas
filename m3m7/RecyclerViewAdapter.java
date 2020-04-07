package com.example.m3m7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private String [] array_noms;
    private int [] array_nota1;
    private int [] array_nota2;
    private int [] array_nota3;
    private Context context;

    public RecyclerViewAdapter(Context con, String[] arrN, int[] arrN1, int[] arrN2, int[] arrN3){
        array_noms = arrN;
        array_nota1 = arrN1;
        array_nota2 = arrN2;
        array_nota3 = arrN3;
        context = con;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(array_noms[position]);
        holder.etiquetaNota1.setText(Integer.toString(array_nota1[position]));
        holder.etiquetaNota2.setText(Integer.toString(array_nota2[position]));
        holder.etiquetaNota3.setText(Integer.toString(array_nota3[position]));
    }

    @Override
    public int getItemCount() {
        return array_noms.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom, etiquetaNota1, etiquetaNota2, etiquetaNota3;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.nom);
            etiquetaNota1 = itemView.findViewById(R.id.nota1);
            etiquetaNota2 = itemView.findViewById(R.id.nota2);
            etiquetaNota3 = itemView.findViewById(R.id.nota3);

            layout = itemView.findViewById(R.id.Layout);
        }
    }
}

