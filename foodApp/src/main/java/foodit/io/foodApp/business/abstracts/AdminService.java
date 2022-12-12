package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.Admin;

public interface AdminService {

	public List<Admin> getAllAdmin();
	public Admin getOneAdmin(int id);
	public Admin postOneAdmin(Admin admin);
	public Admin putOneAdmin(Admin admin,int id);
	public void deleteOneAdmin(int id);
}
