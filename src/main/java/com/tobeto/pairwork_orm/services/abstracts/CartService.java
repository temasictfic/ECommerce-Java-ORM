package com.tobeto.pairwork_orm.services.abstracts;

import com.tobeto.pairwork_orm.entities.Cart;
import com.tobeto.pairwork_orm.entities.Customer;
import com.tobeto.pairwork_orm.services.dtos.cartProductDtos.requests.AddCartProductRequest;

public interface CartService {
	Cart createCustomerCart(Customer customer);
		
	void addToCart(AddCartProductRequest addCartProduct);
}
