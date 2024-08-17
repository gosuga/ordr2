package com.onlineorder.Onlineord.ERCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class OrderController {

	private OrderService orderService;
	@Autowired
	public OrderController(OrderService ord) {
		this.orderService=ord;		
	}
	// private ProductRepo productRepo;
	@PostMapping("/post")

	public String ordctrl(@RequestParam Long id, @RequestParam int ordqty) {

		return orderService.placeord(id, ordqty);

	}
	@PostMapping("/prod")
	
	public String plcprd(@RequestBody Product pro) {
	 return orderService.placeprod(pro);	 
 }

}
