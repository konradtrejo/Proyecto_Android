package com.example.appabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ClientesActivity extends AppCompatActivity {

    EditText editTextNombres, editTextApellidos, editTextDNI, editTextCelular,editTextEdad, editTextDirrecion;
    ListView listViewClientes;
    ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        editTextApellidos =(EditText) findViewById(R.id.edit_apellidos);
        editTextCelular = (EditText) findViewById(R.id.edit_celular);
        editTextDirrecion = (EditText) findViewById(R.id.edit_direccion);
        editTextDNI = (EditText) findViewById(R.id.edit_dni);
        editTextEdad = (EditText) findViewById(R.id.edit_edad);
        editTextNombres = (EditText) findViewById(R.id.edit_nombres);
        listViewClientes = (ListView) findViewById(R.id.listView_clientes);

        // llenar los spiner con los nombres de clientes y abogados con la logica que implementaste
        arrayList = new ArrayList();
        // enviar el list al adapter o como lo hayas implementado
    }
    public void setAddClientes(View view){
        String nombres = editTextNombres.getText().toString();
        String apellidos = editTextApellidos.getText().toString();
        String direccion =editTextDirrecion.getText().toString();
        String dni = editTextDNI.getText().toString();
        String edad = editTextEdad.getText().toString();
        String celular = editTextCelular.getText().toString();
        // llama a la function add de tu helper o repository

    }
}