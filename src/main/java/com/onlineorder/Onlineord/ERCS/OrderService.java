package com.onlineorder.Onlineord.ERCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
@Autowired
	private OrderRepo orderRepo;

	private ProductRepo productRepo;

	@Autowired
	public OrderService(ProductRepo prd) {
		this.productRepo = prd;
	}
/*	@Autowired
	public OrderService(OrderRepo orderRepo) {
		this.orderRepo=orderRepo;
	}*/

	@Transactional
	public String placeord(Long id, int ordqt) {
		// retrive with id

		Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("id not fpond"));

		// check quantity

		if (product.getQuantity() < ordqt) {
			throw new RuntimeException("no stock");
		}

		// deducting prod
		product.setQuantity(product.getQuantity() - ordqt);
		productRepo.save(product);

		Order ord = new Order();
		ord.setQuantity(ordqt);
		ord.setProductId(id);

		orderRepo.save(ord);
		return "sucsfly plcd";
	}

	public String placeprod(Product prod) {

		try {
			productRepo.save(prod);
			return "placed sucessfully";
		} catch (Exception e) {

			return "fail to palce prd" + e.getMessage();
		}

	}

	@ExceptionHandler(Exceptions.class)
	public ResponseEntity<String> excpetionhandle(Exceptions exe) {
		return ResponseEntity.badRequest().body(exe.getMessage());
	}
}