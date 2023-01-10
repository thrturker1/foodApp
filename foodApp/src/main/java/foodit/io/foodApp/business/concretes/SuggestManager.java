package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.SuggestService;
import foodit.io.foodApp.dataAccess.abstracts.SuggestRepository;
import foodit.io.foodApp.entites.concretes.Suggest;

@Service
public class SuggestManager implements SuggestService{

	private SuggestRepository suggestRepository;
	
	@Autowired
	public SuggestManager(SuggestRepository suggestRepository) {
		this.suggestRepository = suggestRepository;
	}
	
	@Override
	public List<Suggest> getAllSuggest(){
		return this.suggestRepository.findAll();
	}
	
	@Override
	public Suggest getOneSuggest(int id) {
		
		Suggest suggest = this.suggestRepository.findById(id).orElseThrow(null);
		return suggest;
	}
	
	@Override
	public Suggest postOneSuggest(Suggest suggest) {
		return suggestRepository.save(suggest);
	}
	
	@Override
	public Suggest putOneSuggest(Suggest suggest, int id) {
		Suggest newSuggest = new Suggest();
		newSuggest = suggestRepository.findById(id).orElseThrow(null);
		
		if(suggest == null) {
			return null;
		}
		else {
			newSuggest.setId(suggest.getId());
			newSuggest.setSuggestName(suggest.getSuggestName());
			newSuggest.setAlergens(suggest.getAlergens());
			newSuggest.setFoodType(suggest.getFoodType());
			newSuggest.setDate(suggest.getDate());
			newSuggest.setMessage(suggest.getMessage());
			
			return suggestRepository.save(newSuggest);
		}
	}

	@Override
	public void deleteOneSuggest(int id) {
		getOneSuggest(id);
		suggestRepository.deleteById(id);
	}
	
	
}
