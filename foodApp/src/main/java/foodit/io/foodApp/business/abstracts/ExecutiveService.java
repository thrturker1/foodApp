package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.Executive;

public interface ExecutiveService {

	public List<Executive> getAllExecutive();
	public Executive getOneExecutive(int id);
	public Executive postOneExecutive(Executive executive);
	public Executive putOneExecutive(Executive executive, int id);
	public void deleteOneExecutive(int id);
}
