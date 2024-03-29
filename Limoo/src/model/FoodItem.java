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
    private double amount;
    private String foodName;
    private FoodUnit unit;
    private String createdAt;
    public FoodItem()
    {}

    /*
     Constructor
     */
    public FoodItem(String _foodName, FoodUnit _unit, double _amount, String time)
    {
        this.foodName = _foodName;
        this.unit = _unit;
        this.amount = _amount;
    }
     

    /*
     Get the amount of the meal user has taken, this value should be in the base unit of each food type
     */
    public double getAmount()
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
    
    public String getCreatedAt()
    {
    	return this.createdAt;
    }
    
    public void setCreationTime(String time)
    {
    	this.createdAt = time;
    }
}


