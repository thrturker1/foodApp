package foodit.io.foodApp.business.abstracts;

import java.util.List;

import foodit.io.foodApp.entites.concretes.Order;

public interface OrderService {

	public List<Order> getAllOrder();
	public Order getOneOrder(int id);
	public Order postOneOrder(Order order);
	public Order putOneOrder(Order order, int id);
	public void deleteOneOrder(int id);
}
