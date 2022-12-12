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

import foodit.io.foodApp.business.abstracts.ExecutiveService;
import foodit.io.foodApp.entites.concretes.Executive;

@CrossOrigin
@RestController
@RequestMapping("/api/executives")
public class ExecutiveController {

	private ExecutiveService executiveService;
	
	@Autowired
	public ExecutiveController(ExecutiveService executiveService) {
		this.executiveService = executiveService;
	}
	
	@GetMapping("/getAll")
	public List<Executive> getAllExecutive(){
		return executiveService.getAllExecutive();
	}
	
	@GetMapping("/{id}")
	public Executive getOneExecutive(@PathVariable(required = true)int id) {
		return executiveService.getOneExecutive(id);
	}
	
	@PostMapping()
	public Executive postOneExecutive(@RequestBody(required = true) Executive executive) {
		return executiveService.postOneExecutive(executive);
	}
	
	@PutMapping("/{id}")
	public Executive putOneExecutive(@RequestBody(required = true) Executive executive, @PathVariable(required = true)int id) {
		return executiveService.putOneExecutive(executive, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneExecutive(@PathVariable(required = true)int id) {
		executiveService.deleteOneExecutive(id);
	}
}
