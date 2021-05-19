package util;

import android.content.ContentValues;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import clases.Escrito;
import interfaces.Mapper;

public class EscritoToMapper implements Mapper<Escrito, ContentValues> {

    @Override
    public ContentValues map(Escrito escrito) {

        HashMap<String, Object> map = new HashMap<>();
        for (Field field : escrito.getClass().getDeclaredFields()) {
            field.setAccessible(true); // if you want to modify private fields
            try {
                map.put(field.getName(), field.get(escrito));
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
