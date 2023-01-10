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

import foodit.io.foodApp.business.abstracts.SuggestService;
import foodit.io.foodApp.entites.concretes.Suggest;

@CrossOrigin
@RestController
@RequestMapping("/api/suggests")
public class SuggestController {

	private SuggestService suggestService;
	
	@Autowired
	public SuggestController(SuggestService suggestService) {
		this.suggestService = suggestService;
	}
	
	@GetMapping("/getAll")
	public List<Suggest> getAllSuggest(){
		return suggestService.getAllSuggest();
	}
	
	@GetMapping("/{id}")
	public Suggest getOneSuggest(@PathVariable(required = true)int id) {
		return suggestService.getOneSuggest(id);
	}
	
	@PostMapping()
	public Suggest postOneSuggest(@RequestBody(required = true)Suggest suggest) {
		return suggestService.postOneSuggest(suggest);
	}
	
	@PutMapping("/{id}")
	public Suggest putOneSuggest(@RequestBody(required = true) Suggest suggest, @PathVariable(required = true) int id) {
		return suggestService.putOneSuggest(suggest, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneSuggest(@PathVariable(required = true) int id) {
		suggestService.deleteOneSuggest(id);
	}
}
