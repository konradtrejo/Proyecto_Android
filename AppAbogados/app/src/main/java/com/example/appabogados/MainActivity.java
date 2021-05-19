package com.example.appabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button layoutCliente = (Button) findViewById(R.id.btn_layout_clientes);
        Button layoutAbogados = (Button) findViewById(R.id.btn_layout_abogados);
        Button layoutEscritos = (Button) findViewById(R.id.btn_layout_escritos);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();

        layoutCliente.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ClientesActivity.class);
                startActivityForResult(intent,0);
            }
        });

        layoutAbogados.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),AbogadosActivity.class);
                startActivityForResult(intent,0);
            }
        });

        layoutEscritos.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),EscritosActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

}