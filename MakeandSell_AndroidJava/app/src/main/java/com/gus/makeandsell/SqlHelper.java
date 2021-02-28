package com.gus.makeandsell;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "components.db";
    private static int DB_VERSION = 1;

    // TABLES CONTENTS

    //Columns of Pizzas
    public static final String TABLE_PIZZAS = "pizzas";
    public static final String COLUMN_PIZZA_ID = "id";
    public static final String COLUMN_PIZZA_NAME = "name";
    public static final String COLUMN_PIZZA_PRICE = "price";
    //Columns of pizza ingredients
    public static final String TABLE_INGREDIENTS = "ingredients";
    //public static final String COLUMN_ING_ID_PIZZA = COLUMN_PIZZA_ID; // Not sure yet
    public static final String COLUMN_ING_ID = "id";
    public static final String COLUMN_ING_NAME = "name";
    public static final String COLUMN_ING_QTY = "qty";
    public static final String COLUMN_ING_PRICE = "price";

    // SQL statement of the ingredients table creation
    private static final String SQL_CREATE_TABLE_INGREDIENTS = "CREATE TABLE " + TABLE_INGREDIENTS + " ("
            + COLUMN_ING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ING_NAME + " TEXT NOT NULL, "
            + COLUMN_ING_QTY + " DOUBLE NOT NULL, "
            + COLUMN_ING_PRICE + " DOUBLE NOT NULL "
            + ");";
    // SQL statement of the pizzas table creation
    private static final String SQL_CREATE_TABLE_PIZZAS = "CREATE TABLE " + TABLE_PIZZAS + " ("
            + COLUMN_PIZZA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PIZZA_NAME + " TEXT NOT NULL, "
            + COLUMN_PIZZA_PRICE + " DOUBLE NOT NULL, "
            + ");";

    /*private static SqlHelper INSTANCE;                        Not sure yet

    static synchronized SqlHelper getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new SqlHelper(context.getApplicationContext());
        return INSTANCE;

    }*/

    SqlHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_INGREDIENTS);
        //db.execSQL(SQL_CREATE_TABLE_PIZZAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    boolean addOne (Ingredient ingredient){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ING_NAME, ingredient.getName());
        values.put(COLUMN_ING_QTY, ingredient.getQty());
        values.put(COLUMN_ING_PRICE, ingredient.getPrice());

        long insert = db.insert(TABLE_INGREDIENTS, null, values);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    boolean deleteOne(Ingredient ingredient) {

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + TABLE_INGREDIENTS + " WHERE " + COLUMN_ING_ID + " = " + ingredient.getId();

        try {
           // db.delete("TABLE_INGREDIENTS", "COLUMN_ING_NAME = ?", new String[]{ingredient.getName()});
            db.execSQL(queryString);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;

        } finally {
            db.close();
        }
    }

    public List<Ingredient> selectAll() {
        List <Ingredient> returnList = new ArrayList<>();

        //get data from the database

        String queryString = "SELECT * FROM " + TABLE_INGREDIENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            //loop through the cursor (result set) and create new item objects. Put them into the return list.
            do {
                int ingredientID = cursor.getInt(0);
                String ingredientName = cursor.getString(1);
                double ingredientQty = cursor.getDouble(2);
                double ingredientPrice = cursor.getDouble(3);

                Ingredient ingredient = new Ingredient(ingredientID, ingredientName, ingredientQty, ingredientPrice);
                returnList.add(ingredient);

            } while (cursor.moveToNext());
        }
        else {
            //failure. do not do anything to the list.
        }

        cursor.close();
        db.close();
        return returnList;
    }


    /* public ArrayList<Ingredient> selectbyID() {
        ArrayList<Ingredient> oneIngredient = new ArrayList<>();

        String selectOne = COLUMN_ING_ID + COLUMN_ING_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor c = db.rawQuery(selectOne, null);
            if (c.moveToFirst()) {
                do {
                    Ingredient i = new Ingredient();
                    i.setId(c.getInt(0));
                    i.setName(c.getString(1));
                    i.setQty(c.getDouble(2));
                    i.setPrice(c.getDouble(3));
                    oneIngredient.add(i);
                } while (c.moveToNext());
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            db.close();
        }

        return oneIngredient;
    } */

/*    Ingredient selectIngredient(int code) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_INGREDIENTS, new String[] {COLUMN_ING_ID, COLUMN_ING_NAME, COLUMN_ING_QTY, COLUMN_ING_PRICE},
                COLUMN_ING_ID + " = ?",
                new String[] {String.valueOf(ingredient.getId())}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Ingredient ingredient1 = new Ingredient (cursor.getInt(0),
                        cursor.getString(1), cursor.getDouble(2),
                        cursor.getDouble(3));
        cursor.close();

        return ingredient1;
    }*/


    void updateIngredient(Ingredient ingredient) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ING_NAME, ingredient.getName());
        values.put(COLUMN_ING_QTY, ingredient.getQty());
        values.put(COLUMN_ING_PRICE, ingredient.getPrice());

        db.update(TABLE_INGREDIENTS, values, COLUMN_ING_ID + " = ?",
                new String[] {String.valueOf(ingredient.getId()) });
    }



}
