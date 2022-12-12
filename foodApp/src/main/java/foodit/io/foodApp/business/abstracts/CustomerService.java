package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomer();
	public Customer getOneCustomer(int id);
	public Customer postOneCustomer(Customer customer);
	public Customer putOneCustomer(Customer customer, int id);
	public void deleteOneCustomer(int id);
}
