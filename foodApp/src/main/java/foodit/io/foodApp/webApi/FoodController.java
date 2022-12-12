package foodit.io.foodApp.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodit.io.foodApp.business.abstracts.FoodService;
import foodit.io.foodApp.entites.concretes.Food;

@CrossOrigin
@RestController
@RequestMapping("/api/foods")
public class FoodController {
	private FoodService foodService;
	
	@Autowired
	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}
	
	@GetMapping("/getAll")
	public List<Food> getAllFood(){
		return foodService.getAllFood();
	}
	
	@GetMapping("/{id}")
	public Food getOneFood(@PathVariable(required = true) int id) {
		return foodService.getOneFood(id);
	}
	
	@PostMapping()
	public Food postOneFood(@RequestBody(required = true)Food food) {
		return foodService.postOneFood(food);
	}
	
	@PutMapping("/{id}")
	public Food putOneFood(@RequestBody(required = true)Food food, @PathVariable(required = true) int id) {
		return foodService.putOneFood(food,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneFood(@PathVariable(required = true)int id) {
		foodService.deleteOneFood(id);
	}
}
