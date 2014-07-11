package model;


/**
 * Created by Erfan on 7/8/2014.
 */

/*
  This class defines the basic FoodItem object type. A FoodItem consists of a food, amount of it, unit of measurement and the time of
  the day this meal had been taken.
 */
public class FoodItem
{
    private int amount;
    private String foodName;
    private FoodUnit unit;

    public FoodItem()
    {}

    /*
     Constructor
     */
    public FoodItem(String _foodName, FoodUnit _unit, int _amount)
    {
        this.foodName = _foodName;
        this.unit = _unit;
        this.amount = _amount;
    }
     

    /*
     Get the amount of the meal user has taken, this value should be in the base unit of each food type
     */
    public int getAmount()
    {
        return this.amount;
    }


    public String getFoodName()
    {
        return this.foodName;
    }
    /*
     Get the unit of the food, this will be the unit of the user input
      */
    public FoodUnit getUnit()
    {
        return this.unit;
    }
    
    /*
     * Get this FoodItem's total energy in kCal
     */
    public double getEnergy()
    {
    	return this.unit.totalEnergy(this.amount);
    }
}


