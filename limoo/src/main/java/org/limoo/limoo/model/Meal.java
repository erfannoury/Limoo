package org.limoo.limoo.model;


import org.limoo.limoo.model.MealType;

/**
 * Created by Erfan on 7/8/2014.
 */

/*
  This class defines the basic Meal object type, a meal consists of a food, amount of it, unit of measurement and the time of
  the day this meal had been taken. MealType can be left out and it will be defaulted to MealType.UNKNOWN
 */
public class Meal
{
    private MealType type;
    private int amount;
    private Food food;
    private IFoodUnit unit;

    public Meal()
    {}

    /*
     Constructor
     */
    public Meal(Food _food, IFoodUnit _unit, int _amount, MealType _type)
    {
        this.food = _food;
        this.unit = _unit;
        this.amount = _amount;
        this.type = _type;
    }
    /*
     Constructor in which MealType is not given as input
     */
    public Meal(Food _food, IFoodUnit _unit, int _amount)
    {
        this.food = _food;
        this.unit = _unit;
        this.amount = _amount;
        this.type = MealType.UNKNOWN;

    }

    /*
     Get the type of the meal, which indicates the time of the day this food has been taken
     */
    public MealType getMealType()
    {
        return this.type;
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
    public IFoodUnit getUnit()
    {
        return this.unit;
    }
}


