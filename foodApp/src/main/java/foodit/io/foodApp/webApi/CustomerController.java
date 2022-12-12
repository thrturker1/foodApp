package foodit.io.foodApp.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodit.io.foodApp.business.abstracts.CustomerService;
import foodit.io.foodApp.entites.concretes.Customer;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getOneCustomer(@PathVariable(required = true) int id) {
		return customerService.getOneCustomer(id);
	}
	
	@PostMapping()
	public Customer postOneCustomer(@RequestBody(required = true)Customer customer) {
		return customerService.postOneCustomer(customer);
	}

	@PutMapping("/{id}")
	public Customer putOneCustomer(@RequestBody(required = true)Customer customer, @PathVariable(required = true) int id) {
		return customerService.putOneCustomer(customer, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneCustomer(@PathVariable(required = true) int id) {
		customerService.deleteOneCustomer(id);
	}
}
