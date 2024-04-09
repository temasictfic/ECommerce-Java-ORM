package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.entities.Cart;
import com.tobeto.pairwork_orm.entities.CartProduct;
import com.tobeto.pairwork_orm.entities.Customer;
import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.entities.Seller;
import com.tobeto.pairwork_orm.repositories.CartProductRepository;
import com.tobeto.pairwork_orm.repositories.CartRepository;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.repositories.SellerRepository;
import com.tobeto.pairwork_orm.services.abstracts.CartService;
import com.tobeto.pairwork_orm.services.dtos.cartProductDtos.requests.AddCartProductRequest;

import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {
	private CartRepository cartRepository;

	private CartProductRepository cartProductRepository;

	private ProductRepository productRepository;

	private SellerRepository sellerRepository;

	//Customer oluştuğunda customer'a ait bir cart oluşturduk.
	@Override
	public Cart createCustomerCart(Customer customer) {
		Cart customerCart = new Cart();
		customerCart.setCustomer(customer);
		return cartRepository.save(customerCart);
	}

	@Override
	public void addToCart(AddCartProductRequest addCartProduct) {
		Cart cart = cartRepository.findById(addCartProduct.getCartId()).orElseThrow();

		Product requestedProduct = productRepository.findById(addCartProduct.getProductId()).orElseThrow();

		Seller requestedSeller = sellerRepository.findById(addCartProduct.getSellerId()).orElseThrow();

		// Sepette aynı Product varsa miktarı artırdık, yoksa yeni bir CartProduct
		// oluşturduk.

		Optional<CartProduct> existingCartProduct = cart.getCartProducts().stream()
				.filter(cartProduct -> cartProduct.getProduct().equals(requestedProduct)).findFirst();

		if (existingCartProduct.isPresent() && existingCartProduct.get().getSeller().equals(requestedSeller)) {
			CartProduct cartProduct = existingCartProduct.get();
			cartProduct.setQuantity(cartProduct.getQuantity() + addCartProduct.getQuantity());
			cartProduct.setTotalPrice(
					cartProduct.getTotalPrice() + (requestedProduct.getUnitPrice() * addCartProduct.getQuantity()));
			cart.getCartProducts().add(cartProduct);
			cartProduct.setCart(cart);
			cartProductRepository.save(cartProduct);
		} else {
			CartProduct cartProduct = new CartProduct();
			cartProduct.setProduct(requestedProduct);
			cartProduct.setSeller(requestedSeller);
			cartProduct.setQuantity(addCartProduct.getQuantity());
			cartProduct.setTotalPrice(requestedProduct.getUnitPrice() * addCartProduct.getQuantity());
			cart.getCartProducts().add(cartProduct);
			cartProduct.setCart(cart);
			cartProductRepository.save(cartProduct); // Oluşturduğumuz CartProduct nesnesini kaydettik.
		}

		cartRepository.save(cart); // Sepeti veritabanına kaydet
	}

}
