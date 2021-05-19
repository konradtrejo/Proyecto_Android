package util;

import android.content.ContentValues;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import clases.Caso;
import interfaces.Mapper;

public class CasoToMapper implements Mapper<Caso, ContentValues> {

    @Override
    public ContentValues map(Caso caso) {

        HashMap<String, Object> map = new HashMap<>();
        for (Field field : caso.getClass().getDeclaredFields()) {
            field.setAccessible(true); // if you want to modify private fields
            try {
                map.put(field.getName(), field.get(caso));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        ContentValues values = new ContentValues();
        for(Map.Entry<String, Object> entry : map.entrySet())
            values.put(entry.getKey(), (Integer) entry.getValue());

        return values;
    }
}
