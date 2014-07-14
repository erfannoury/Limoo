package view;
import java.util.Random;

import model.*;
public class TestMeals
{
	static String[] foodNames = {"املت","شیر","قرمه سبزی","کباب برگ", "بادام زمینی"};
	static FoodUnit[] foodUnits = {new FoodUnit("لیوان", 1.5), new FoodUnit("قاشق", 0.5), new FoodUnit("ظرف", 20)};
	
	public static Meal getRandomMeal(MealType type)
	{
		Meal meal = new Meal(type);
		for(int i = 0; i < 5; i++)
		{
			meal.addnewFoodItem(foodNames[new Random().nextInt(foodNames.length)], foodUnits[new Random().nextInt(foodUnits.length)], new Random().nextDouble()*5);
		}
		return meal;
	}
}
