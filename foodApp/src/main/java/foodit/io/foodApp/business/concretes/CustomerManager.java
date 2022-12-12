package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.CustomerService;
import foodit.io.foodApp.dataAccess.abstracts.CustomerRepository;
import foodit.io.foodApp.entites.concretes.Customer;

@Service
public class CustomerManager implements CustomerService{

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerManager(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getOneCustomer(int id) {
		return customerRepository.findById(id).orElseThrow();
	}

	@Override
	public Customer postOneCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer putOneCustomer(Customer customer, int id) {
		Customer newCustomer = new Customer();
		newCustomer = customerRepository.findById(id).orElseThrow();
		
		if(newCustomer == null)
		return null;
		
		else {
			newCustomer.setId(customer.getId());
			newCustomer.setFirstName(customer.getFirstName());
			newCustomer.setLastName(customer.getLastName());
			newCustomer.setEmail(customer.getEmail());
			newCustomer.setAdress(customer.getAdress());
			
			return customerRepository.save(newCustomer);
		}
	}

	@Override
	public void deleteOneCustomer(int id) {
		customerRepository.deleteById(id);
	}
}
