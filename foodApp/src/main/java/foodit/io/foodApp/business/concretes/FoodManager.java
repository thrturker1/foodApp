package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.FoodService;
import foodit.io.foodApp.dataAccess.abstracts.FoodRepository;
import foodit.io.foodApp.entites.concretes.Food;

@Service
public class FoodManager implements FoodService{

	private FoodRepository foodRepository;
	
	@Autowired
	public FoodManager(FoodRepository foodRepository)
	{
		this.foodRepository = foodRepository;
	}
	
	@Override
	public List<Food> getAllFood() {
		
		return foodRepository.findAll();
	}

	@Override
	public Food getOneFood(int id) {
		Food food = foodRepository.findById(id).orElseThrow();
		return food;
	}

	@Override
	public Food postOneFood(Food food) {
		
		return foodRepository.save(food);
	}

	@Override
	public Food putOneFood(Food food, int id) {
		Food newFood = new Food();
		newFood = foodRepository.findById(id).orElseThrow();
		
		if(food == null)
			return null;
		
		else {
			newFood.setId(food.getId());
			newFood.setName(food.getName());
			newFood.setCount(food.getCount());
			newFood.setPrize(food.getPrize());
			newFood.setCompanyName(food.getCompanyName());
			newFood.setAlergens(food.getAlergens());
			newFood.setFoodType(food.getFoodType());
			newFood.setImage(food.getImage());
			
			return foodRepository.save(newFood);
		}
		
	}

	@Override
	public void deleteOneFood(int id) {
		getOneFood(id);
		foodRepository.deleteById(id);
		
	}

}
