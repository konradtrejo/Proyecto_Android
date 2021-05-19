package com.example.appabogados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControlador {
    private DBhelper dBhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c) {
        ourcontext = c;
    }
    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dBhelper = new DBhelper(ourcontext);
        database = dBhelper.getWritableDatabase();
        return this;
    }
    public void cerrar() {
        dBhelper.close();
    }
    public void insertarDatos(String name){
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.NOMBRES, name);
        database.insert(DBhelper.TABLE_NAME,null,cv);
    }
    public Cursor leerDatos(){
        String[] todasLasColumnas = new String[]{
            DBhelper.ID,
            DBhelper.NOMBRES
        };
        Cursor c = database.query(DBhelper.TABLE_NAME,todasLasColumnas,null,null,null,null,null);
        if (c != null){
            c.moveToFirst();
        }
        return c;
    }
    public int actualizarDatos(long mID,String nombreUpdate){
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.NOMBRES, nombreUpdate);
        int i = database.update(DBhelper.TABLE_NAME,cvActualizar,DBhelper.ID + " = " + mID, null);
        return i;
    }
    public void deleteData(long mID){
        database.delete(DBhelper.TABLE_NAME,DBhelper.ID + " = " + mID, null);
    }
}