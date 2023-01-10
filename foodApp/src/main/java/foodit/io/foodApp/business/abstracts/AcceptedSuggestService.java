package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.AcceptedSuggest;

public interface AcceptedSuggestService {

	public List<AcceptedSuggest> getAllAcceptedSuggest();
	public AcceptedSuggest getOneAcceptedSuggest(int id);
	public AcceptedSuggest postOneAcceptedSuggest(AcceptedSuggest acceptedSuggest);
	public AcceptedSuggest putOneAcceptedSuggest(AcceptedSuggest acceptedSuggest, int id);
	public void deleteOneAcceptedSuggest(int id);
}
