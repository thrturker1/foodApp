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

import foodit.io.foodApp.business.abstracts.AlergenService;
import foodit.io.foodApp.entites.concretes.Alergen;

@CrossOrigin
@RestController
@RequestMapping("/api/alergens")
public class AlergenController {

	private AlergenService alergenService;
	
	@Autowired
	public AlergenController(AlergenService alergenService) {
		this.alergenService = alergenService;
	}
	
	@GetMapping("/getAll")
	public List<Alergen> getAllAlergen(){
		return alergenService.getAllAlergen();
	}
	
	@GetMapping("/{id}")
	public Alergen getOneAlergen(@PathVariable(required = true) int id) {
		return alergenService.getOneAlergen(id);
	}
	
	@PostMapping()
	public Alergen postOneAlergen(@RequestBody(required = true) Alergen alergen) {
		return alergenService.postOneAlergen(alergen);
	}
	
	@PutMapping("/{id}")
	public Alergen putOneAlergen(@RequestBody(required = true) Alergen alergen, @PathVariable(required = true) int id) {
		return alergenService.putOneAlergen(alergen, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneAlergen(@PathVariable(required = true) int id) {
		alergenService.deleteOneAlergen(id);
	}
}
