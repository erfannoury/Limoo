package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.FoodUnit;
import model.FoodData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.*;

public class FoodDataSource 
{
	private SQLiteDatabase db;
	private FoodDataTableHelper tblHelper;
	private String[] allcolumns = { FoodDataTableHelper.COLUMN_ID, FoodDataTableHelper.COLUMN_FOODNAME,
			FoodDataTableHelper.COLUMN_ISBASEUNIT, FoodDataTableHelper.COLUMN_UNITNAME,
			FoodDataTableHelper.COLUMN_ENERGY, FoodDataTableHelper.COLUMN_MULTIPLIER };
	
	/*
	 * Constructor
	 */
	public FoodDataSource(Context context)
	{
		tblHelper = new FoodDataTableHelper(context);
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
	 * This will add a new FoodData object to the data source, one entry for each food unit
	 */
	public long[] addFoodData(FoodData foodData)
	{
		long[] insertIDs = new long[foodData.getAdditionalUnits().size()];
		insertIDs[0] = addFoodData(foodData.getFoodName(), foodData.getBaseUnit().getUnitName(), foodData.getBaseUnit().getEnergy(), foodData.getBaseUnit().getMultiplier(), true);
		int idx = 1;
		for (FoodUnit u : foodData.getAdditionalUnits())
		{
			insertIDs[idx++] = addFoodData(foodData.getFoodName(), u.getUnitName(), u.getEnergy(), u.getMultiplier(), false);
		}
		return insertIDs;
	}
	
	/*
	 * This will add a new row to the data source
	 */
	public long addFoodData(String foodName, String unitName, double energy, double multiplier, boolean isBaseUnit)
	{
		ContentValues val = new ContentValues();
		val.put(FoodDataTableHelper.COLUMN_FOODNAME, foodName);
		val.put(FoodDataTableHelper.COLUMN_UNITNAME, unitName);
		val.put(FoodDataTableHelper.COLUMN_ENERGY, energy);
		val.put(FoodDataTableHelper.COLUMN_MULTIPLIER, multiplier);
		val.put(FoodDataTableHelper.COLUMN_ISBASEUNIT, isBaseUnit ? 1 : 0);
		long insertID = db.insert(FoodDataTableHelper.TBL_FOODDATA, null, val);
		return insertID;
	}
	
	/*
	 * This will delete all the rows where foodname column matches foodName and unitname column matches unitName
	 * If everything goes right, at most 1 row should be deleted
	 * @return number of rows affected by this statement
	 */
	public int deleteFoodData(String foodName, String unitName)
	{
		String whereClause = tblHelper.COLUMN_FOODNAME + " = " + foodName + " and " + tblHelper.COLUMN_UNITNAME + " = " + unitName;
		int rowsDeleted = db.delete(tblHelper.TBL_FOODDATA, whereClause, null);
		return rowsDeleted;
	}
	
	/*
	 * This will delete all the rows corresponding to the given FoodData object, and it will return as an array number of rows deleted
	 * per FoodUnit.
	 * In the correct form, all element of array should be 0 | 1
	 */
	public int[] deleteFoodData(FoodData foodData)
	{
		int[] rowsDeleted = new int[foodData.getAllUnits().size()];
		int idx = 0;
		for (FoodUnit u : foodData.getAllUnits())
		{
			rowsDeleted[idx++] = deleteFoodData(foodData.getFoodName(), u.getUnitName());
		}
		return rowsDeleted;
	}
	
	/*
	 * This will return an ArrayList containing all of the entries in the FoodDataSource
	 */
	public List<FoodData> getAllFoodData()
	{
		HashMap<String, FoodData> allfoods = new HashMap<>();
		
		Cursor cur = db.query(tblHelper.TBL_FOODDATA, allcolumns, null, null, null, null, null);
		cur.moveToFirst();
		
		while(!cur.isAfterLast())
		{
			if(!allfoods.containsKey(cur.getString(1)))
			{
				FoodData newFood = new FoodData(cur.getString(1), new FoodUnit(cur.getString(3), cur.getDouble(4), cur.getDouble(5)), cur.getString(2).equals("1") ? true : false);
				allfoods.put(cur.getString(1), newFood);
			}
			else
			{
				allfoods.get(cur.getString(1)).addAdditionalUnit(new FoodUnit(cur.getString(3), cur.getDouble(4), cur.getDouble(5)), cur.getString(2).equals("1") ? true : false);
			}
			cur.moveToNext();
		}
		cur.close();
		
		
		// Convert values collection to list and return
		List<FoodData> allfoodsList;
		if (allfoods.values() instanceof List)
		  allfoodsList = (List<FoodData>)allfoods.values();
		else
		  allfoodsList = new ArrayList<>(allfoods.values());
		
		return allfoodsList;
	}
	
	/*
	 * Get the FoodData object provided the name of the food
	 * If no entry found, it will throw an exception
	 */
	public FoodData getFoodData(String foodName) throws Exception
	{
		Cursor cur = db.query(tblHelper.TBL_FOODDATA, null, tblHelper.COLUMN_FOODNAME + " = " + foodName, null, null, null, null);
		cur.moveToFirst();
		if(cur.isAfterLast())
			throw new Exception("Now results found for your search on FoodDataSource");
		FoodData foodData = new FoodData(cur.getString(1), new FoodUnit(cur.getString(3), cur.getDouble(4), cur.getDouble(5)), cur.getString(2).equals("1") ? true : false);
		cur.moveToNext();
		while(!cur.isAfterLast())
		{
			foodData.addAdditionalUnit(new FoodUnit(cur.getString(3), cur.getDouble(4), cur.getDouble(5)), cur.getString(2).equals("1") ? true : false);
			cur.moveToNext();
		}
		return foodData;
	}
}
