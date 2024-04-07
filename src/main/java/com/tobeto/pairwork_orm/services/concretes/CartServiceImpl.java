package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CartServiceImpl {
    private CartRepository cartRepository;

   /* @Override
    public AddProductToCartResponse addProductToCart(AddProductToCartRequest request) {
        Customer requestedCustomer = customerRepository.findById(request.getCustomerId()).orElseThrow();

        Product requestedProduct = productRepository.findById(request.getProductId()).orElseThrow();

        Cart cart = CartMapper.INSTANCE.mapAddProductToCartRequestToCart(request); // Müşterinin sepetini al
        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(requestedCustomer);
            cartRepository.save(cart);
        }

        Optional<CartProduct> existingCartProduct = cart.getCartProducts().stream()
                .filter(cartProduct -> cartProduct.getProduct().equals(requestedProduct))
                .findFirst();

        if (existingCartProduct.isPresent()) {
            CartProduct cartProduct = existingCartProduct.get();
            cartProduct.setQuantity(cartProduct.getQuantity() + request.getQuantity());
            cartProduct.setTotalPrice(cartProduct.getTotalPrice() + (requestedProduct.getUnitPrice() * request.getQuantity()));
        } else {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setProduct(requestedProduct);
            cartProduct.setSeller(cartProduct.getSeller()); // Örnek olarak ilk satıcıyı al
            cartProduct.setQuantity(request.getQuantity());
            cartProduct.setTotalPrice(requestedProduct.getUnitPrice() * request.getQuantity());
            cart.getCartProducts().add(cartProduct);
        }

        cartRepository.save(cart); // Sepeti veritabanına kaydet

        return null;
    }*/
}
