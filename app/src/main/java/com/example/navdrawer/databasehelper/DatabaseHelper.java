package com.example.navdrawer.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "recetas.db";
    private static final int DATABASE_VERSION = 1;
    //columnas
    private static final String TABLE_NAME = "recetas_table";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "receta_titulo";
    private static final String COLUMN_PREP = "receta_prep";
    private static final String COLUMN_INGREDIENTE_1 = "receta_ingrediente_1";
    private static final String COLUMN_INGREDIENTE_2 = "receta_ingrediente_2";
    private static final String COLUMN_INGREDIENTE_3 = "receta_ingrediente_3";
    private static final String COLUMN_INGREDIENTE_4 = "receta_ingrediente_4";
    private static final String COLUMN_INGREDIENTE_5 = "receta_ingrediente_5";
    //SQL QUERY

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_PREP + " TEXT, " +
                COLUMN_INGREDIENTE_1 + " TEXT, " +
                COLUMN_INGREDIENTE_2 + " TEXT, " +
                COLUMN_INGREDIENTE_3 + " TEXT, " +
                COLUMN_INGREDIENTE_4 + " TEXT, " +
                COLUMN_INGREDIENTE_5 + " TEXT);";

        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //metodo para insertar data
    public void addReceta(String title, String prep, String ingrediente1, String ingrediente2, String ingrediente3, String ingrediente4, String ingrediente5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_PREP, prep);
        cv.put(COLUMN_INGREDIENTE_1, ingrediente1);
        cv.put(COLUMN_INGREDIENTE_2, ingrediente2);
        cv.put(COLUMN_INGREDIENTE_3, ingrediente3);
        cv.put(COLUMN_INGREDIENTE_4, ingrediente4);
        cv.put(COLUMN_INGREDIENTE_5, ingrediente5);
        //
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data insertada con exito!", Toast.LENGTH_SHORT).show();

        }
        //db.close();
}
}


