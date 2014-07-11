package model;
import java.util.ArrayList;

import model.MealType;
import model.FoodItem;


/*
 * A meal consists of a group of FoodItems, and it has a MealType tag.
 */
public class Meal 
{
	private ArrayList<FoodItem> foodItemsGroup;
	private MealType type;
	
	public Meal(MealType type)
	{
		this.type = type;
		this.foodItemsGroup = new ArrayList<>();
	}
	
	/*
	 * Add a new FoodItem to the list of FoodItems of this meal
	 */
	public void addNewFoodItem(FoodItem item)
	{
		this.foodItemsGroup.add(item);
	}
	
	/*
	 * Get all the FoodItems
	 */
	public ArrayList<FoodItem> getFoodItems()
	{
		return this.foodItemsGroup;
	}
	
	/*
	 * Get the type of this meal
	 */
	public MealType getMealType()
	{
		return this.type;
	}
}
