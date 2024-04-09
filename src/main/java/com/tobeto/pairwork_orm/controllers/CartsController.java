package com.tobeto.pairwork_orm.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.pairwork_orm.services.abstracts.CartService;
import com.tobeto.pairwork_orm.services.dtos.cartProductDtos.requests.AddCartProductRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/carts")
public class CartsController {
	private CartService cartService;
	
	public CartsController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/addCartProductToCart")
	@ResponseStatus(HttpStatus.CREATED)
	public void addToCart(@RequestBody @Valid AddCartProductRequest addCartProduct) {
		cartService.addToCart(addCartProduct);
	}
}
