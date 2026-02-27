package com.training.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.Order;
import com.training.orderservice.dao.OrderRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/order")
@RestController
public class OrderController {

	@Autowired
	OrderRepository repo;
	
	@GetMapping("/greet")
	public String greet(@RequestHeader("service_name") String reqheader) {
		System.out.println("service requested "+reqheader);
		return "Greetings from OrderService Instance TWO ..........";
	}
	
	@GetMapping("/uid/{uid}")
	public List<Order> getOrderByUid(@PathVariable Integer uid){
		return repo.findByUid(uid);
	}
	
	
	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order ord) {
		return repo.save(ord);
	}
	
	@GetMapping("/{oid}")
	public Order getOrder(@PathVariable Integer oid) {
		return repo.findById(oid)
				.orElseThrow(()->new RuntimeException("Order not found "+oid));
	}
	
	@GetMapping("/all")
	public List<Order> getAllOrders(){
		return (List<Order>) repo.findAll();
	}
	
}
