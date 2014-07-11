import model.*;

public class MainActivity 
{
	public static void main(String[] args)
	{
		Meal lunch = new Meal(MealType.DINNER);
		Meal dinner = new Meal(MealType.DINNER);
			
		lunch.addNewFoodItem(new FoodItem(new FoodData("شیر پرچرب", new FoodUnit("لیوان", 0.150)), new FoodUnit("لیوان", 0.150), 5));
		dinner.addNewFoodItem(new FoodItem(new FoodData("املت", new FoodUnit("بزرگ", 0.092)),new FoodUnit("بزرگ", 0.092),1));
	}
}
