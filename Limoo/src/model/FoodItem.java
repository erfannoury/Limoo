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
    private Food food;
    private FoodUnit unit;

    public FoodItem()
    {}

    /*
     Constructor
     */
    public FoodItem(Food _food, FoodUnit _unit, int _amount)
    {
        this.food = _food;
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


    public Food getFood()
    {
        return this.food;
    }
    /*
     Get the unit of the food, this will be the unit of the user input
      */
    public FoodUnit getUnit()
    {
        return this.unit;
    }
}


