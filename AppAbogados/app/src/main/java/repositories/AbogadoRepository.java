package repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Collections;

import clases.Abogado;
import interfaces.Mapper;
import interfaces.Repository;
import util.AbogadoToMapper;

public class AbogadoRepository implements Repository<Abogado> {

    public class AbogadoHelper extends SQLiteOpenHelper {

        public AbogadoHelper(@Nullable Context context) {
            super(context, "abogado", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    private final String table = "abogado";

    private final SQLiteOpenHelper openHelper;

    private final Mapper<Abogado, ContentValues> toContentValuesMapper;

    public AbogadoRepository(Context context) {
        //this.openHelper = openHelper;
        this.openHelper = new AbogadoHelper(context);
        this.toContentValuesMapper = new AbogadoToMapper();
    }

    @Override
    public void add(Abogado item) {
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
    public void update(Abogado item) {

    }

    @Override
    public void remove(Abogado item) {

    }
}
