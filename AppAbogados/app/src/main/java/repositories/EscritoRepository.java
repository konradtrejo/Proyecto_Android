package repositories;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import clases.Escrito;
import interfaces.Mapper;
import interfaces.Repository;
import util.EscritoToMapper;

public class EscritoRepository implements Repository<Escrito> {
    private final String table = "escrito";

    private final SQLiteOpenHelper openHelper;

    private final Mapper<Escrito, ContentValues> toContentValuesMapper;

    public EscritoRepository(SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;

        this.toContentValuesMapper = new EscritoToMapper();
    }

    @Override
    public void add(Escrito item) {
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
    public void update(Escrito item) {

    }

    @Override
    public void remove(Escrito item) {

    }
}
