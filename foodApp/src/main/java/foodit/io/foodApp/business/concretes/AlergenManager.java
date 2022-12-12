package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.AlergenService;
import foodit.io.foodApp.dataAccess.abstracts.AlergenRepository;
import foodit.io.foodApp.entites.concretes.Alergen;

@Service
public class AlergenManager implements AlergenService{

	private AlergenRepository alergenRepository;
	
	@Autowired
	public AlergenManager(AlergenRepository alergenRepository) {
		this.alergenRepository = alergenRepository;
	}
	
	@Override
	public List<Alergen> getAllAlergen() {
		return alergenRepository.findAll();
	}

	@Override
	public Alergen getOneAlergen(int id) {
		return alergenRepository.findById(id).orElseThrow();
	}

	@Override
	public Alergen postOneAlergen(Alergen alergen) {
		return alergenRepository.save(alergen);
	}

	@Override
	public Alergen putOneAlergen(Alergen alergen, int id) {
		Alergen newAlergen = new Alergen();
		newAlergen = alergenRepository.findById(id).orElseThrow();
		
		if(alergen == null)
		return null;
		
		else {
			newAlergen.setId(alergen.getId());
			newAlergen.setName(alergen.getName());
			
			return alergenRepository.save(newAlergen);
		}
	}

	@Override
	public void deleteOneAlergen(int id) {
		getOneAlergen(id);
		alergenRepository.deleteById(id);
	}
}
