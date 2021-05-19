package repositories;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import clases.Caso;
import interfaces.Mapper;
import interfaces.Repository;
import util.CasoToMapper;

public class CasoRepository implements Repository<Caso> {
    private final String table = "caso";

    private final SQLiteOpenHelper openHelper;

    private final Mapper<Caso, ContentValues> toContentValuesMapper;

    public CasoRepository(SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;

        this.toContentValuesMapper = new CasoToMapper();
    }

    @Override
    public void add(Caso item) {
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
    public void update(Caso item) {

    }

    @Override
    public void remove(Caso item) {

    }
}
