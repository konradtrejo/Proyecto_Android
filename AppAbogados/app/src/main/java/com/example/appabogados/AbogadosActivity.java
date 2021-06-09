package com.example.appabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import clases.Abogado;
import repositories.AbogadoRepository;

public class AbogadosActivity extends AppCompatActivity {

    EditText editTextNombres, editTextApellidos, editTextColegiatura,
            editTextCelular,editTextEdad, editTextDespacho;
    ArrayList arrayList;
    ListView listViewAbogados;
    Button addAbogado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abogados);
        editTextApellidos =(EditText) findViewById(R.id.edit_apellidosA);
        editTextCelular = (EditText) findViewById(R.id.edit_celularA);
        editTextDespacho = (EditText) findViewById(R.id.edit_despacho);
        editTextColegiatura = (EditText) findViewById(R.id.edit_colegiatura);
        editTextEdad = (EditText) findViewById(R.id.edit_edadA);
        editTextNombres = (EditText) findViewById(R.id.edit_nombresA);
        listViewAbogados = (ListView) findViewById(R.id.listView_abogados);
        addAbogado = (Button) findViewById(R.id.btn_add_abogado);

        // llenar los spiner con los nombres de clientes y abogados con la logica que implementaste
        arrayList = new ArrayList();
        // enviar el list al adapter o como lo hayas implementado

    }


    public void setAddAbogados(View view){
        String nombres = editTextNombres.getText().toString();
        String apellidos = editTextApellidos.getText().toString();
        String despacho =editTextDespacho.getText().toString();
        String colegiatura = editTextColegiatura.getText().toString();
        String edad = editTextEdad.getText().toString();
        String celular = editTextCelular.getText().toString();
        // llama a la function add de tu helper o repository

        Abogado abogado = new Abogado(nombres,apellidos,edad,celular,colegiatura,despacho);
        System.out.println("ABOGADO CREADO: ");
        AbogadoRepository aR = new AbogadoRepository(this);
        aR.add(abogado);
        Intent amain = new Intent(AbogadosActivity.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(amain);
    }
}