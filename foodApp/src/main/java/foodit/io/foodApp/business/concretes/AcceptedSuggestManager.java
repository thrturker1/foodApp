package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.AcceptedSuggestService;
import foodit.io.foodApp.dataAccess.abstracts.AcceptedSuggestRepository;
import foodit.io.foodApp.entites.concretes.AcceptedSuggest;

@Service
public class AcceptedSuggestManager implements AcceptedSuggestService{

	private AcceptedSuggestRepository acceptedRepository;
	
	@Autowired
	public AcceptedSuggestManager(AcceptedSuggestRepository acceptedRepository) {
		this.acceptedRepository = acceptedRepository;
	}
	
	@Override
	public List<AcceptedSuggest> getAllAcceptedSuggest() {
		return acceptedRepository.findAll();
	}
	
	@Override
	public AcceptedSuggest getOneAcceptedSuggest(int id) {
		AcceptedSuggest acceptedSuggest = this.acceptedRepository.findById(id).orElseThrow(null);
		return acceptedSuggest;
	}
	
	@Override
	public AcceptedSuggest postOneAcceptedSuggest(AcceptedSuggest acceptedSuggest) {
		return acceptedRepository.save(acceptedSuggest);
	}
	
	@Override
	public AcceptedSuggest putOneAcceptedSuggest(AcceptedSuggest acceptedSuggest, int id) {
		AcceptedSuggest tempSuggest = new AcceptedSuggest();
		tempSuggest = acceptedRepository.findById(id).orElseThrow(null);
		
		if(tempSuggest == null) {
			return null;
		}
		else {
			tempSuggest.setId(acceptedSuggest.getId());
			tempSuggest.setAcceptedName(acceptedSuggest.getAcceptedName());
			tempSuggest.setAcceptedAlergen(acceptedSuggest.getAcceptedAlergen());
		}
		return acceptedRepository.save(tempSuggest);
	}
	
	@Override
	public void deleteOneAcceptedSuggest(int id) {
		getOneAcceptedSuggest(id);
		acceptedRepository.deleteById(id);
	}
}
