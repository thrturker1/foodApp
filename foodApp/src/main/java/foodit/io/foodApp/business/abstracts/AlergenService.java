package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.Alergen;

public interface AlergenService {

	public List<Alergen> getAllAlergen();
	public Alergen getOneAlergen(int id);
	public Alergen postOneAlergen(Alergen alergen);
	public Alergen putOneAlergen(Alergen alergen, int id);
	public void deleteOneAlergen(int id);
}
