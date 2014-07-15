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
	public static final String COLUMN_TIME_YEAR = "time_year";
	public static final String COLUMN_TIME_MONTH = "time_month";
	public static final String COLUMN_TIME_DAY = "time_day";
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
	private static final String CREATE_DB = "create table "
			+ TBL_MEALENTRY + "(" 
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_TIME_YEAR + " integer not null, "
			+ COLUMN_TIME_MONTH + " integer not null, "
			+ COLUMN_TIME_DAY + " integer not null, "
			+ COLUMN_AMOUNT + " real not null, "
			+ COLUMN_FOODNAME + " string not null, "
			+ COLUMN_UNITNAME + " string not null, "
			+ COLUMN_ENERGY + " real not null, "
			+ COLUMN_MULTIPLIER + " real not null"
			+ COLUMN_MEALTYPE + " integer not null"
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
