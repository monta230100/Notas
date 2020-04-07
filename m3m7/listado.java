package com.example.m3m7;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class listado extends AppCompatActivity {

    RecyclerView recyclerView;

    String [] array_noms;
    int [] array_nota1;
    int [] array_nota2;
    int [] array_nota3;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        Intent recogerDatos = getIntent();
        array_noms = recogerDatos.getStringArrayExtra("array_noms");
        array_nota1 = recogerDatos.getIntArrayExtra("array_nota1");
        array_nota2 = recogerDatos.getIntArrayExtra("array_nota2");
        array_nota3 = recogerDatos.getIntArrayExtra("array_nota3");
        contador = recogerDatos.getIntExtra("contador",  0);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, array_noms, array_nota1, array_nota2, array_nota3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
    }
}
