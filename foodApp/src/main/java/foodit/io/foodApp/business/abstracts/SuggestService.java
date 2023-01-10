package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.Suggest;

public interface SuggestService {
	
	public List<Suggest> getAllSuggest();
	public Suggest getOneSuggest(int id);
	public Suggest postOneSuggest(Suggest suggest);
	public Suggest putOneSuggest(Suggest suggest, int id);
	public void deleteOneSuggest(int id);
}
