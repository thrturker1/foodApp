package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.AdminService;
import foodit.io.foodApp.dataAccess.abstracts.AdminRepository;
import foodit.io.foodApp.entites.concretes.Admin;

@Service
public class AdminManager implements AdminService{

	private AdminRepository adminRepository;
	
	@Autowired
	public AdminManager(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getOneAdmin(int id) {
		return adminRepository.findById(id).orElseThrow();
	}

	@Override
	public Admin postOneAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin putOneAdmin(Admin admin, int id) {
		Admin newAdmin = new Admin(); 
		newAdmin = adminRepository.findById(id).orElseThrow();
		
		if(admin == null)
		return null;
		
		else {
			newAdmin.setId(admin.getId());
			newAdmin.setFirstName(admin.getFirstName());
			newAdmin.setLastName(admin.getLastName());
			newAdmin.setEmail(admin.getEmail());
			newAdmin.setStatue(admin.getStatue());
			
			return adminRepository.save(newAdmin);
		}
	}

	@Override
	public void deleteOneAdmin(int id) {
		getOneAdmin(id);
		adminRepository.deleteById(id);
	}
}
