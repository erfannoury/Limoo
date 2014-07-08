package org.limoo.limoo.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.IllegalFormatFlagsException;

/**
 * Created by Erfan on 7/8/2014.
 */
public class Food
{
    private String foodName;
    private IFoodUnit baseUnit;
    /*
     List of units for this type of food, this list excludes the base unit
     */
    private ArrayList<IFoodUnit> units;


    /*
     Default constructor
     */
    private Food() { }

    /*
     Constructor without adding a list of additional units
     */
    public Food(String foodName, IFoodUnit baseUnit)
    {
        this.foodName = foodName;
        this.baseUnit = baseUnit;
        this.units = new ArrayList<>();
    }
    /*
     Constructor with adding a list of additional units
     */
    public Food(String foodName, IFoodUnit baseUnit, ArrayList<IFoodUnit> additionalUnits)
    {
        this.foodName = foodName;
        this.baseUnit = baseUnit;
        if(!additionalUnits.equals(null) && additionalUnits.size() > 0)
            this.units = additionalUnits;
        else
            this.units = new ArrayList<>();
    }

    public IFoodUnit getBaseUnit()
    {
        return this.baseUnit;
    }

    /*
     Add an additional unit to the list of additional units
     */
    public void addAdditionalUnit(IFoodUnit unit)
    {
        if(!unit.equals(null))
            return;
        this.units.add(unit);
    }

    /*
     get the list of additional units
     */
    public ArrayList<IFoodUnit> getAdditionalUnits()
    {
        return this.units;
    }

    /*
     get all the units of the food, including the base unit
     */
    public ArrayList<IFoodUnit> getAllUnits()
    {
        ArrayList<IFoodUnit> allUnits = new ArrayList<>();
        allUnits.add(baseUnit);
        allUnits.addAll(this.units);
        return allUnits;
    }
}
