package com.tobeto.pairwork_orm.services.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.pairwork_orm.entities.Order;
import com.tobeto.pairwork_orm.entities.OrderProduct;
import com.tobeto.pairwork_orm.entities.Product;
import com.tobeto.pairwork_orm.repositories.OrderRepository;
import com.tobeto.pairwork_orm.repositories.ProductRepository;
import com.tobeto.pairwork_orm.services.abstracts.OrderService;
import com.tobeto.pairwork_orm.services.dtos.orderDtos.requests.OrderRequest;
import com.tobeto.pairwork_orm.services.dtos.orderDtos.responses.OrderResponse;
import com.tobeto.pairwork_orm.services.dtos.orderProductDtos.requests.OrderProductRequest;
import com.tobeto.pairwork_orm.services.mappers.OrderMapper;
import com.tobeto.pairwork_orm.services.mappers.ProductMapper;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        // Convert OrderRequest to Order entity
        Order order = OrderMapper.INSTANCE.mapOrderRequestToOrder(request);

        // For each OrderProductRequest in the request, create an OrderProduct entity and add it to the order
        for (OrderProductRequest orderProductRequest : request.getOrderProducts()) {
            // Find the product
            Product product = productRepository.findById(orderProductRequest.getProductId()).orElseThrow();

            // Update the product quantity
            product.setQuantity(product.getQuantity() - orderProductRequest.getQuantity());

            // Create an OrderProduct entity and add it to the order
            OrderProduct orderProduct = new OrderProduct();
            // Set orderProduct properties from orderProductRequest
            // ...

            order.getOrderProducts().add(orderProduct);
        }

        // Save the order to the database
        orderRepository.save(order);

        // Convert Order entity to OrderResponse and return it
        OrderResponse response = OrderMapper.INSTANCE.mapOrderToOrderResponse(order);

        return response;
    }
}
