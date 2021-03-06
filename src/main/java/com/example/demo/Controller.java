package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	
	private final Logger logger = LogManager.getLogger();
	
	@RequestMapping(value = "/allproducts", method = RequestMethod.GET)
	public List<Product> getAllProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	@RequestMapping(value = "/ordersofuser_{user}", method = RequestMethod.GET)
	public List<Order> getOrderOfUser(@PathVariable Long user){
		return orderRepository.findByUser(userRepository.findById(user.longValue()));
	}
	
	@RequestMapping(value = "/getuser_{user}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long user){
		return userRepository.findById(user.longValue());
	}
	
	@RequestMapping(value = "/deleteuser_{user}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long user){
		userRepository.deleteById(user);
	}
	
	@RequestMapping(value = "/createproduct/{name}_{price}", method = RequestMethod.POST)
	public void createProduct(@PathVariable String name, @PathVariable Float price){
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		productRepository.save(p);
	}
	
	@RequestMapping(value = "/allorders", method = RequestMethod.GET)
	public List<Order> getAllOrders(){
		return (List<Order>) orderRepository.findAll();
	}
	
	@RequestMapping(value = "/createorder/{user}", method = RequestMethod.POST)
	public void createProduct(@PathVariable Long user){
		Order o = new Order();
		o.setCreate_at(LocalDateTime.now());
		o.setOrder_sum(0f);
		o.setUser(userRepository.findById(user.longValue()));
		o.setProducts(new ArrayList<Product>());
		orderRepository.save(o);
	}
	
	@RequestMapping(value = "/addproducttoorder/{product}_{order}", method = RequestMethod.POST)
	public void addProductToOrder(@PathVariable Long product, @PathVariable Long order) {
		Order o = orderRepository.findById(order.longValue());
		Product p = productRepository.findById(product.longValue());
		logger.info(o + " " + p);
		o.getProducts().add(p);
		float sum_price = 0;
		for(Product l: o.getProducts()) {
			sum_price += l.getPrice();
		}
		o.setOrder_sum(sum_price);
		orderRepository.save(o);
	}
	
	@RequestMapping(value = "/createuser/{fullname}_{login}_{password}", method = RequestMethod.POST)
	public void createUser(@PathVariable String fullname, @PathVariable String login, @PathVariable String password){
		User u = new User();
		u.setFullname(fullname);
		u.setLogin(login);
		u.setPassword(password);
		userRepository.save(u);
	}
}
