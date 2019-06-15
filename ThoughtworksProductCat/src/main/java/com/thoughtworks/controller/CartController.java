package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.requests.AddProductRequest;
import com.requests.DeleteProductRequest;
import com.thoughtwork.service.CartService;
import com.thoughtworks.entity.Cart;

@RestController
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public ResponseEntity addProduct(@RequestBody AddProductRequest addPRoduct) {
		 try {
			 cartService.addProduct(addPRoduct.getProductID(),addPRoduct.getUserId());
		 }
		 catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 return ResponseEntity.ok().build();
	 }
	
	@RequestMapping(value = "/product", method = RequestMethod.DELETE)
	public ResponseEntity removeProduct(@RequestBody DeleteProductRequest deleteProductReq) {
		 try {
			 cartService.deleteProduct(deleteProductReq.getProductId(),deleteProductReq.getUserId());
		 }
		 catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Cart> view(@RequestParam(value="userID") Integer userID) {
		 try {
			return ResponseEntity.ok().body(cartService.getCart(userID));
		 }
		 catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
}
