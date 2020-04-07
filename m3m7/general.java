package com.example.m3m7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class general extends AppCompatActivity {
    String [] array_noms = new String [50];
    int[] array_nota1 = new int[50];
    int[] array_nota2 = new int[50];
    int[] array_nota3 = new int[50];
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        final Button añadir = findViewById(R.id.añadir);
        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goToafegirAlumne();
            }
        });
        Intent returnIntent = new Intent();
        returnIntent.putExtra("array_noms", array_noms);
        setResult(RESULT_OK, returnIntent);

        final Button aprobar = findViewById(R.id.aprobar);
        aprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goToaprobado();
            }
        });
        returnIntent = new Intent();
        returnIntent.putExtra("array_noms", array_noms);
        setResult(RESULT_OK, returnIntent);


        final Button help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goTohelp();
            }
        });

        final Button listar = findViewById(R.id.RelativeLayout);
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goTolistado();
            }
        });

    }

    private void  goToafegirAlumne() {
        Intent afegir = new Intent(  this, afegirAlumne.class);
        afegir.putExtra("array_noms", array_noms);
        afegir.putExtra("array_nota1", array_nota1);
        afegir.putExtra("array_nota2", array_nota2);
        afegir.putExtra("array_nota3", array_nota3);
        afegir.putExtra("contador", contador);
        startActivityForResult(afegir, 1);
    }

    private void goToaprobado() {
        Intent aprobar = new Intent( this, aprobado.class);
        aprobar.putExtra("array_noms", array_noms);
        aprobar.putExtra("array_nota1", array_nota1);
        aprobar.putExtra("array_nota2", array_nota2);
        aprobar.putExtra("array_nota3", array_nota3);
        aprobar.putExtra("contador", contador);
        startActivityForResult(aprobar, 1);
    }
    private void  goTolistado() {
        Intent listar = new Intent(  this, afegirAlumne.class);
        listar.putExtra("array_noms", array_noms);
        listar.putExtra("array_nota1", array_nota1);
        listar.putExtra("array_nota2", array_nota2);
        listar.putExtra("array_nota3", array_nota3);
        listar.putExtra("contador", contador);
        startActivity(listar);
    }
    private void  goTohelp() {
        Intent help = new Intent(this, ayuda.class);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if(resultCode==RESULT_OK) {
                array_noms=data.getStringArrayExtra("array_noms");
                array_nota1 = data.getIntArrayExtra("array_nota1");
                array_nota2 = data.getIntArrayExtra("array_nota2");
                array_nota3 = data.getIntArrayExtra("array_nota3");
                contador = data.getIntExtra("contador", 0);
            }
        }
    }
}
