package com.example.m3m7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class afegirAlumne extends AppCompatActivity {

    String [] array_noms;
    int [] array_nota1;
    int [] array_nota2;
    int [] array_nota3;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_alumne);

        Intent recogerDatos = getIntent();

        array_noms = recogerDatos.getStringArrayExtra("array_noms");
        array_nota1 = recogerDatos.getIntArrayExtra("array_nota1");
        array_nota2 = recogerDatos.getIntArrayExtra("array_nota2");
        array_nota3 = recogerDatos.getIntArrayExtra("array_nota3");
        contador = recogerDatos.getIntExtra("contador",  0);

        final Button guardar = findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {
                EditText nomAlumne = findViewById(R.id.editText);
                EditText nota1 = findViewById(R.id.Nota1);
                EditText nota2 = findViewById(R.id.Nota2);
                EditText nota3 = findViewById(R.id.Nota3);

                String guardar = nomAlumne.getText().toString();
                int guardar_nota1 = Integer.parseInt(nota1.getText().toString());
                int guardar_nota2 = Integer.parseInt(nota2.getText().toString());
                int guardar_nota3 = Integer.parseInt(nota3.getText().toString());

                array_noms[contador] = guardar;
                array_nota1[contador] = guardar_nota1;
                array_nota2[contador] = guardar_nota2;
                array_nota3[contador] = guardar_nota3;
                contador++;

                Toast.makeText(getApplicationContext(), "Alumno añadido correctamente.", Toast.LENGTH_SHORT).show();
            }
        });

        final Button limpiar = findViewById(R.id.clean);
        guardar.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {
                EditText nomAlumne = findViewById(R.id.editText);
                EditText nota1 = findViewById(R.id.Nota1);
                EditText nota2 = findViewById(R.id.Nota2);
                EditText nota3 = findViewById(R.id.Nota3);

                nomAlumne.setText("");
                nota1.setText("");
                nota2.setText("");
                nota3.setText("");
            }
        });
    }
    public void onBackPressed(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("array_noms", array_noms);
        returnIntent.putExtra("array_nota1", array_nota1);
        returnIntent.putExtra("array_nota2", array_nota2);
        returnIntent.putExtra("array_nota3", array_nota3);
        returnIntent.putExtra("contador", contador);
        setResult(RESULT_OK, returnIntent);
    }
}
