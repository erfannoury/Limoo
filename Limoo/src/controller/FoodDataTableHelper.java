package controller;

import model.FoodData;
import model.FoodUnit;
import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class FoodDataTableHelper extends SQLiteOpenHelper
{
	/*
	 * Strings defining the table
	 */
	public static final String TBL_FOODDATA = "FoodData";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_FOODNAME = "foodname";
	public static final String COLUMN_ISBASEUNIT = "isbaseunit";
	public static final String COLUMN_UNITNAME = "unitname";
	public static final String COLUMN_ENERGY = "energy";
	public static final String COLUMN_MULTIPLIER = "multiplier";
	
	private static final String DB_NAME = "fooddata.db";
	private static final int DB_VERSION = 1;
	
	/*
	 * Database creation sql statement
	 */
	private static final String CREATE_DB = "create table "
			+ TBL_FOODDATA + "(" 
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_FOODNAME + "string not null, "
			+ COLUMN_ISBASEUNIT + "integer not null, "
			+ COLUMN_UNITNAME + "string not null, "
			+ COLUMN_ENERGY + "real not null, "
			+ COLUMN_MULTIPLIER + "real not null"
			+ ");";
	 
	
	/*
	 * Constructor which states the database name and version
	 */
	public FoodDataTableHelper(Context context) 
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
		db.execSQL("DROP TABLE IF EXISTS " + TBL_FOODDATA);
	    onCreate(db);
	}

}
