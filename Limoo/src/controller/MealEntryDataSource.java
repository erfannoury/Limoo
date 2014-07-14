package controller;

import java.util.Calendar;
import java.util.Date;

import model.MealType;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/*
 * This class is for accessing and adding user meal entries
 */
public class MealEntryDataSource
{
	private SQLiteDatabase db;
	private MealEntryTableHelper tblHelper;
	private String[] allcolumns = { MealEntryTableHelper.COLUMN_ID, MealEntryTableHelper.COLUMN_TIME,
			MealEntryTableHelper.COLUMN_AMOUNT, MealEntryTableHelper.COLUMN_FOODNAME,
			MealEntryTableHelper.COLUMN_UNITNAME, MealEntryTableHelper.COLUMN_ENERGY,
			MealEntryTableHelper.COLUMN_MULTIPLIER, MealEntryTableHelper.COLUMN_MEALTYPE };
	
	/*
	 * Constructor
	 */
	public MealEntryDataSource(Context context)
	{
		tblHelper = new MealEntryTableHelper(context);
	}
	
	/*
	 * This will open the database as writable
	 */
	public void open() throws SQLException
	{
		db = tblHelper.getWritableDatabase();
	}
	
	/*
	 * This will close the currently open database
	 */
	public void close()
	{
		tblHelper.close();
	}
	
	/*
	 * Add new entry to the MealEntryDataSource, since time is not specified, current time will be used instead
	 */
	public long addEntry(String foodName, double amount, String unitName, double energy, double multiplier, MealType mealtype)
	{
		return addEntry(new Date().toString(), foodName, amount, unitName, energy, multiplier, mealtype);
	}
	
	/*
	 * Add new entry to the MealEntryDataSource
	 */
	public long addEntry(String time, String foodName, double amount, String unitName, double energy, double multiplier, MealType mealtype)
	{
		ContentValues val = new ContentValues();
		val.put(tblHelper.COLUMN_TIME, time);
		val.put(tblHelper.COLUMN_AMOUNT, amount);
		val.put(tblHelper.COLUMN_FOODNAME, foodName);
		val.put(tblHelper.COLUMN_UNITNAME, unitName);
		val.put(tblHelper.COLUMN_ENERGY, energy);
		val.put(tblHelper.COLUMN_MULTIPLIER, multiplier);
		val.put(tblHelper.COLUMN_MEALTYPE, mealtype.ordinal());
		
		long insertID = db.insert(tblHelper.TBL_MEALENTRY, null, val);
		return insertID;
	}
	
	
}
