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

import foodit.io.foodApp.business.abstracts.AcceptedSuggestService;
import foodit.io.foodApp.entites.concretes.AcceptedSuggest;

@CrossOrigin
@RestController
@RequestMapping("/api/acceptedsuggests")
public class AcceptedSuggestController {

	private AcceptedSuggestService acceptedService;
	
	@Autowired
	public AcceptedSuggestController(AcceptedSuggestService acceptedService) {
		this.acceptedService = acceptedService;
	}
	
	@GetMapping("/getAll")
	public List<AcceptedSuggest> getAllAcceptedSuggest() {
		return acceptedService.getAllAcceptedSuggest();
	}
	
	@GetMapping("/{id}")
	public AcceptedSuggest getOneAcceptedSuggest(@PathVariable(required = true) int id) {
		return acceptedService.getOneAcceptedSuggest(id);
	}
	
	@PostMapping()
	public AcceptedSuggest postOneAcceptedSuggest(@RequestBody(required = true) AcceptedSuggest acceptedSuggest) {
		return acceptedService.postOneAcceptedSuggest(acceptedSuggest);
	}
	
	@PutMapping("/{id}")
	public AcceptedSuggest putOneAcceptedSuggest(@RequestBody(required = true) AcceptedSuggest acceptedSuggest, @PathVariable(required = true) int id) {
		return acceptedService.putOneAcceptedSuggest(acceptedSuggest, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneAcceptedSuggest(@PathVariable(required = true) int id) {
		acceptedService.deleteOneAcceptedSuggest(id);
	}
}
