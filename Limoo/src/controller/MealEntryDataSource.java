package controller;

import helper.TimeHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import model.FoodUnit;
import model.Meal;
import model.MealType;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/*
 * This class is for accessing and adding user meal entries
 */
public class MealEntryDataSource
{
	private SQLiteDatabase db;
	private MealEntryTableHelper tblHelper;
	private String[] allcolumns = { MealEntryTableHelper.COLUMN_ID, MealEntryTableHelper.COLUMN_CREATED_AT,
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
	 * Create a new entry and add it to the MealEntryDataSource, since time is not specified, current time will be used instead
	 */
	public long createEntry(String foodName, double amount, String unitName, double energy, double multiplier, MealType mealtype)
	{
		return createEntry(TimeHelper.getCurrentDateTime() , foodName, amount, unitName, energy, multiplier, mealtype);
	}
	
	/*
	 * Create a new entry and add ot to the MealEntryDataSource. In this case, creation time should be provided, too
	 */
	public long createEntry(String createdAt, String foodName, double amount, String unitname, double energy, double multiplier, MealType mealtype)
	{
		SQLiteDatabase wdb = tblHelper.getWritableDatabase();
		
		ContentValues val = new ContentValues();
		val.put(tblHelper.COLUMN_CREATED_AT, createdAt);
		val.put(tblHelper.COLUMN_AMOUNT, amount);
		val.put(tblHelper.COLUMN_FOODNAME, foodName);
		val.put(tblHelper.COLUMN_UNITNAME, unitname);
		val.put(tblHelper.COLUMN_ENERGY, energy);
		val.put(tblHelper.COLUMN_MULTIPLIER, multiplier);
		val.put(tblHelper.COLUMN_MEALTYPE, mealtype.ordinal());
		
		long insertID = wdb.insert(tblHelper.TBL_MEALENTRY, null, val);
		return insertID;
		
	}
	
	public int deleteEntry(String createdAt, String foodName, double amount, String unitName, MealType mealtype)
	{
		String whereClause = tblHelper.COLUMN_CREATED_AT + " = " + "' "+ createdAt + "'" + " and "
				+ tblHelper.COLUMN_FOODNAME + " = " + "'" + foodName + "'" + " and "
				+ tblHelper.COLUMN_AMOUNT + " = " + amount + " and "
				+ tblHelper.COLUMN_UNITNAME + " = " + "'" +  unitName + "'" + " and "
				+ tblHelper.COLUMN_MEALTYPE + " = " + mealtype.ordinal();
		int rowsDeleted = db.delete(tblHelper.TBL_MEALENTRY, whereClause, null);
		return rowsDeleted;
	}
	
	public int deleteEntry(long id)
	{
		SQLiteDatabase wdb = tblHelper.getWritableDatabase();
		String whereClause = tblHelper.COLUMN_ID + " = " + id;
		int rowsDeleted = wdb.delete(tblHelper.TBL_MEALENTRY, whereClause, null);
		return rowsDeleted;
	}
	
	public List<Meal> getAllEntries(String time)
	{
		List<Meal> meals = new ArrayList<>();
		for(int i = 0; i != MealType.values().length; i++)
		{
			meals.add(getMeal(time, MealType.values()[i]));
		}
		return meals;
	}
	
	public Meal getMeal(String time ,MealType type)
	{
		Meal m = new Meal(type);
		SQLiteDatabase rdb = tblHelper.getReadableDatabase();
		
		String query = "SELECT * FROM " + tblHelper.TBL_MEALENTRY + " WHERE " + tblHelper.COLUMN_CREATED_AT + " = " + "'" + time + "'" + 
				" AND " + tblHelper.COLUMN_MEALTYPE + " = " + type.ordinal() + " ORDERY BY " + tblHelper.COLUMN_CREATED_AT;
		
		Cursor cur = rdb.rawQuery(query, null);
		
		if(cur != null)
			cur.moveToFirst();
		
		while(!cur.isAfterLast())
		{
			m.addnewFoodItem(cur.getString(cur.getColumnIndex(tblHelper.COLUMN_FOODNAME)), 
					new FoodUnit(cur.getString(cur.getColumnIndex(tblHelper.COLUMN_UNITNAME)), cur.getDouble(cur.getColumnIndex(tblHelper.COLUMN_ENERGY)), cur.getDouble(cur.getColumnIndex(tblHelper.COLUMN_MULTIPLIER))), 
					cur.getDouble(cur.getColumnIndex(tblHelper.COLUMN_AMOUNT)), cur.getString(cur.getColumnIndex(tblHelper.COLUMN_CREATED_AT)));
		}
		return m;
	}
}
