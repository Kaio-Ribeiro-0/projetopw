package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.*;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final AuthService authService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            AddressRepository addressRepository,
                            ProductRepository productRepository,
                            AuthService authService) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.authService = authService;
    }

    @Override
    @Transactional
    public Order save(Order order) {
        User user = authService.getAuthenticatedUser();

        Address address = addressRepository
                .findByIdAndUserId(order.getAddress().getId(), user.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Endereço não encontrado para este usuário"));

        order.setUser(user);
        order.setAddress(address);
        order.setDateTime(LocalDateTime.now());

        for (OrderItems item : order.getOrderItems()) {
            Long productId = item.getProduct().getId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Produto não encontrado: " + productId));
            item.setProduct(product);
            item.setPrice(product.getPrice());
            item.setOrder(order);
        }

        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findByAuthenticatedUser() {
        return orderRepository.findByUserIdOrderByDateTimeDesc(
                authService.getAuthenticatedUser().getId());
    }

    @Override
    @Transactional(readOnly = true)
    public Order findByIdAndAuthenticatedUser(Long id) {
        return orderRepository
                .findByIdAndUserId(id, authService.getAuthenticatedUser().getId())
                .orElse(null);
    }
}