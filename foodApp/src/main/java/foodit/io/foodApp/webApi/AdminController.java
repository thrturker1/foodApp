package foodit.io.foodApp.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodit.io.foodApp.business.abstracts.AdminService;
import foodit.io.foodApp.entites.concretes.Admin;

@CrossOrigin
@RestController
@RequestMapping("/api/admins")
public class AdminController {

	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/getAll")
	public List<Admin> getAllAdmin(){
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/{id}")
	public Admin getOneAdmin(@PathVariable(required = true) int id) {
		return adminService.getOneAdmin(id);
	}
	
	@PostMapping()
	public Admin postOneAdmin(@RequestBody(required = true) Admin admin) {
		return adminService.postOneAdmin(admin);
	}
	
	@PutMapping("/{id}")
	public Admin putOneAdmin(@RequestBody(required = true) Admin admin, @PathVariable(required = true) int id) {
		return adminService.putOneAdmin(admin, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneAdmin(@PathVariable(required = true) int id) {
		adminService.deleteOneAdmin(id);
	}
}
