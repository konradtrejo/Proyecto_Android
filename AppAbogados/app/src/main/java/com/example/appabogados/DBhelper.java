package com.example.appabogados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "miembros";
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String NOMBRES = "nombres";
    public static final String APELLIDOS = "apellidos";
    public static final String EDAD = "edad";
    public static final String COLEGIATURA = "colegiatura";
    public static final String DESPACHO = "despacho";
    public static final String DNI = "dni";
    public static final String CELULAR = "celular";
    public static final String DIRECCION = "direccion";

    public static final String IDABOGADO = "id_abagado";
    public static final String IDCLIENTE = "id_cliente";
    public static final String IDESCRITO = "id_escrito";
    //Informacion de la BD
    static final String NOMBRE_BD = "DBMIEMBROS";
    static final int _VERSION = 1;

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOMBRES + " VARCHAR(100) NOT NULL, " +
                    APELLIDOS + " VARCHAR(100) NOT NULL, " +
                    EDAD + " VARCHAR(3) NOT NULL, " +
                    CELULAR + " VARCHAR(9) NOT NULL, " +
                    COLEGIATURA + " VARCHAR(20) NOT NULL, " +
                    DESPACHO + " VARCHAR(30) NOT NULL);";

    private static final String CREATE_ABOGADOS_TABLE =
            "CREATE TABLE abogado (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOMBRES + " VARCHAR(100) NOT NULL, " +
                    APELLIDOS + " VARCHAR(100) NOT NULL, " +
                    EDAD + " VARCHAR(3) NOT NULL, " +
                    CELULAR + " VARCHAR(9) NOT NULL, " +
                    COLEGIATURA + " VARCHAR(20) NOT NULL, " +
                    DESPACHO + " VARCHAR(30) NOT NULL);";

    private static final String CREATE_CLIENTES_TABLE =
            "CREATE TABLE clientes (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOMBRES + " VARCHAR(100) NOT NULL, " +
                    APELLIDOS + " VARCHAR(100) NOT NULL, " +
                    DNI + " VARCHAR(7) NOT NULL, " +
                    EDAD + " VARCHAR(3) NOT NULL, " +
                    CELULAR + " VARCHAR(9) NOT NULL, " +
                    DIRECCION + " VARCHAR(100) NOT NULL);";

    private static final String CREATE_ESCRITOS_TABLE =
            "CREATE TABLE escritos (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOMBRE + " VARCHAR(100) NOT NULL);";

    private static final String CREATE_CASOS_TABLE =
            "CREATE TABLE casos (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOMBRE + " VARCHAR(100) NOT NULL, " +
                    " FOREIGN KEY ("+IDABOGADO+") REFERENCES abogados ("+ID+"), " +
                    " FOREIGN KEY ("+IDCLIENTE+") REFERENCES clientes ("+ID+"), " +
                    " FOREIGN KEY ("+IDESCRITO+") REFERENCES escritos ("+ID+");";

    public DBhelper(@Nullable Context context) {
        super(context, NOMBRE_BD, null, _VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("HOLA EL INICIO DEL CODIGO SQL AQUI: " + CREATE_ABOGADOS_TABLE);
        db.execSQL(CREATE_ABOGADOS_TABLE);
        System.out.println("HOLA EL INICIO DEL CODIGO SQL AQUI: " + CREATE_CLIENTES_TABLE);
        db.execSQL(CREATE_CLIENTES_TABLE);
        System.out.println("HOLA EL INICIO DEL CODIGO SQL AQUI: " + CREATE_ESCRITOS_TABLE);
        db.execSQL(CREATE_ESCRITOS_TABLE);
        //System.out.println("HOLA EL INICIO DEL CODIGO SQL AQUI: " + CREATE_CASOS_TABLE);
        //db.execSQL(CREATE_CASOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }
}
