package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.Food;

public interface FoodService {

	public List<Food> getAllFood();
	public Food getOneFood(int id);
	public Food postOneFood(Food food);
	public Food putOneFood(Food food, int id);
	public void deleteOneFood(int id);
}
