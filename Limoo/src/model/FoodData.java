package model;

import java.util.ArrayList;

/**
 * Created by Erfan on 7/8/2014.
 */
/*
 * This class contains data for each food. Each food has a name, has a base unit and a list of other additional units.
 */
public class FoodData
{
    private String foodName;
    private FoodUnit baseUnit;
    /*
     List of units for this type of food, this list excludes the base unit
     */
    private ArrayList<FoodUnit> units;


    /*
     Default constructor
     */
    private FoodData() { }

    /*
     Constructor without adding a list of additional units
     */
    public FoodData(String foodName, FoodUnit unit, boolean isBaseUnit)
    {
        this.foodName = foodName;
        if(isBaseUnit)
        {
        	this.baseUnit = baseUnit;
        	this.units = new ArrayList<>();        	
        }
        else
        {
        	this.units = new ArrayList<>();
        	this.units.add(unit);
        }
    }
    
    /*
     Constructor with adding a list of additional units
     */
    public FoodData(String foodName, FoodUnit baseUnit, ArrayList<FoodUnit> additionalUnits)
    {
        this.foodName = foodName;
        this.baseUnit = baseUnit;
        if(!additionalUnits.equals(null) && additionalUnits.size() > 0)
            this.units = additionalUnits;
        else
            this.units = new ArrayList<>();
    }

    public String getFoodName()
    {
    	return this.foodName;
    }
    
    public FoodUnit getBaseUnit()
    {
        return this.baseUnit;
    }

    /*
     Add a new unit to the list of units
     */
    public void addAdditionalUnit(FoodUnit unit, boolean isBaseUnit)
    {
        if(!unit.equals(null))
            return;
        if(isBaseUnit)
        	this.baseUnit = unit;
        else
        	this.units.add(unit);        	
    }

    /*
     get the list of additional units
     */
    public ArrayList<FoodUnit> getAdditionalUnits()
    {
        return this.units;
    }

    /*
     get all the units of the food, including the base unit
     */
    public ArrayList<FoodUnit> getAllUnits()
    {
        ArrayList<FoodUnit> allUnits = new ArrayList<>();
        allUnits.add(baseUnit);
        allUnits.addAll(this.units);
        return allUnits;
    }
}
