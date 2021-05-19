package com.example.appabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class EscritosActivity extends AppCompatActivity {

    EditText editTextCasos;
    Spinner spinnerClientes, spinnerAbogados, spinnerEscritos;
    ArrayList arrayList;
    ListView listViewEscritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escritos);
        editTextCasos = (EditText) findViewById(R.id.edit_casos);
        spinnerClientes = (Spinner) findViewById(R.id.spinner_clientes);
        spinnerAbogados = (Spinner) findViewById(R.id.spinner_abogados);
        spinnerEscritos = (Spinner) findViewById(R.id.spinner_escritos);
        listViewEscritos = (ListView) findViewById(R.id.listView_escritos);
        // llenar los spiner con los nombres de clientes y abogados con la logica que implementaste
        arrayList = new ArrayList();
        // enviar el list al adapter o como lo hayas implementado

    }
    public void setAddAbogados(View view){
        String caso = editTextCasos.getText().toString();
        // llama a la function add de tu helper o repository
        // llamar a la funcion a listar
    }
}