package repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Collections;

import clases.Cliente;
import interfaces.Mapper;
import interfaces.Repository;
import util.ClienteToMapper;

public class ClienteRepository implements Repository<Cliente> {

    public class ClienteHelper extends SQLiteOpenHelper {

        public ClienteHelper(@Nullable Context context) {
            super(context, "cliente", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    private final String table = "cliente";

    private final SQLiteOpenHelper openHelper;

    private final Mapper<Cliente, ContentValues> toContentValuesMapper;

    public ClienteRepository(Context context) {
        //this.openHelper = openHelper;
        this.openHelper = new ClienteHelper(context);
        this.toContentValuesMapper = new ClienteToMapper();
    }

    @Override
    public void add(Cliente item) {
        final SQLiteDatabase database = openHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            final ContentValues contentValues = toContentValuesMapper.map(item);

            database.insert(table, null, contentValues);

            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }

    @Override
    public void update(Cliente item) {

    }

    @Override
    public void remove(Cliente item) {

    }
}
