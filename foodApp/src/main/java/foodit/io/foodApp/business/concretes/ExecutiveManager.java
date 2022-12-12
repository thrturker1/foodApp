package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.ExecutiveService;
import foodit.io.foodApp.dataAccess.abstracts.ExecutiveRepository;
import foodit.io.foodApp.entites.concretes.Executive;

@Service
public class ExecutiveManager implements ExecutiveService{
	
	private ExecutiveRepository executiveRepository;
	
	@Autowired
	public ExecutiveManager(ExecutiveRepository executiveRepository) {
		this.executiveRepository = executiveRepository;
	}
	
	@Override
	public List<Executive> getAllExecutive() {
		return executiveRepository.findAll();
	}

	@Override
	public Executive getOneExecutive(int id) {
		return executiveRepository.findById(id).orElseThrow();
	}

	@Override
	public Executive postOneExecutive(Executive executive) {
		return executiveRepository.save(executive);
	}

	@Override
	public Executive putOneExecutive(Executive executive, int id) {
		Executive newExecutive = new Executive();
		newExecutive= executiveRepository.findById(id).orElseThrow();
		
		if(executive == null)
		return null;
		
		else {
			newExecutive.setId(executive.getId());
			newExecutive.setFirstName(executive.getFirstName());
			newExecutive.setLastName(executive.getLastName());
			newExecutive.setEmail(executive.getEmail());
			
			return executiveRepository.save(newExecutive);
		}
	}

	@Override
	public void deleteOneExecutive(int id) {
		getOneExecutive(id);
		executiveRepository.deleteById(id);
	}
}
