package controller;

import android.content.Context;
import android.database.sqlite.*;

public class MealEntryTableHelper extends SQLiteOpenHelper
{
	/*
	 * Strings defining the table
	 */
	public static final String TBL_MEALENTRY = "FoodData";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_CREATED_AT = "time";
	public static final String COLUMN_AMOUNT = "amount";
	public static final String COLUMN_FOODNAME = "foodname";
	public static final String COLUMN_UNITNAME = "unitname";
	public static final String COLUMN_ENERGY = "energy";
	public static final String COLUMN_MULTIPLIER = "multiplier";
	public static final String COLUMN_MEALTYPE = "mealtype";
	
	private static final String DB_NAME = "mealentry.db";
	private static final int DB_VERSION = 1;
	
	/*
	 * Database creation sql statement
	 */
	private static final String CREATE_DB = "CREATE TABLE "
			+ TBL_MEALENTRY + "(" 
			+ COLUMN_ID + " INTEGER PRIMARY KEY, "
			+ COLUMN_CREATED_AT + " DATETIME, "
			+ COLUMN_AMOUNT + " REAL, "
			+ COLUMN_FOODNAME + " REAL, "
			+ COLUMN_UNITNAME + " REAL, "
			+ COLUMN_ENERGY + " REAL, "
			+ COLUMN_MULTIPLIER + " REAL, "
			+ COLUMN_MEALTYPE + " INTEGER"
			+ ");";
	 
	
	/*
	 * Constructor which states the database name and version
	 */
	public MealEntryTableHelper(Context context) 
	{
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(CREATE_DB);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("DROP TABLE IF EXISTS " + TBL_MEALENTRY);
	    onCreate(db);
	}
}
