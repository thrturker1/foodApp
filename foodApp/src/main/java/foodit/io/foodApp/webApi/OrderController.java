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

import foodit.io.foodApp.business.abstracts.OrderService;
import foodit.io.foodApp.entites.concretes.Order;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/getAll")
	public List<Order> getAllOrder(){
		return orderService.getAllOrder();
}
	
	@GetMapping("/{id}")
	public Order getOneOrder(@PathVariable(required = true)int id) {
		return orderService.getOneOrder(id);
	}
	
	@PostMapping()
	public Order postOneOrder(@RequestBody(required = true) Order order) {
		return orderService.postOneOrder(order);
	}
	
	@PutMapping("/{id}")
	public Order putOneOrder(@RequestBody(required = true) Order order,@PathVariable(required = true)int id) {
		return orderService.putOneOrder(order, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneOrder(@PathVariable(required = true) int id) {
		orderService.deleteOneOrder(id);
	}
	
}
