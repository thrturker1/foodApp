package foodit.io.foodApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodit.io.foodApp.business.abstracts.OrderService;
import foodit.io.foodApp.dataAccess.abstracts.OrderRepository;
import foodit.io.foodApp.entites.concretes.Order;

@Service
public class OrderManager implements OrderService{

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderManager(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public List<Order> getAllOrder() {
		
		return orderRepository.findAll();
	}

	@Override
	public Order getOneOrder(int id) {
		
		return orderRepository.findById(id).orElseThrow();
	}

	@Override
	public Order postOneOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order putOneOrder(Order order, int id) {
		Order newOrder = new Order();
		newOrder = orderRepository.findById(id).orElseThrow();
		
		if(order == null)
		return null;
		
		else {
			newOrder.setId(order.getId());
			newOrder.setCustomerName(order.getCustomerName());
			newOrder.setProductName(order.getProductName());
			newOrder.setTotalCount(order.getTotalCount());
			newOrder.setTotalPrize(order.getTotalPrize());
			
			return orderRepository.save(newOrder);
		}
	}

	@Override
	public void deleteOneOrder(int id) {
		getOneOrder(id);
		orderRepository.deleteById(id);
	}

}
