package controller;

import java.util.ArrayList;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
/**
 * Created by Erfan on 7/8/2014.
 */
public class DBHandler extends SQLiteOpenHelper
{
    private static final int DBVERSION = 1;
    private static final String DBNAME = "MealsDB";

    /*
     Table name (Meals)
     */
    private static final String TBLMEAL = "TBLMeals";
    /*
     TBLMEAL columns
     */
    private static final String TBLMEAL_KEY_ID = "id";
    private static final String TBLMEAL_KEY_FOOD = "food";
    private static final String TBLMEAL_KEY_AMOUNT = "amount";
    private static final String TBLMEAL_KEY_MEALTYPE = "type";
    private static final String TBLMEAL_TIME = "time";

    public DBHandler(Context context)
    {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
