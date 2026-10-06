package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItems;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemsRepository;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemsRepository orderItemsRepository) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public Order save(Order order) {

        order.setDateTime(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        if (order.getOrderItems() != null) {
            for (OrderItems item : order.getOrderItems()) {
                item.setOrder(savedOrder);
                orderItemsRepository.save(item);
            }
        }

        return savedOrder;
    }

    @Override
    public List<Order> findAllByUserUsername(String username) {
        return orderRepository.findByUserUsername(username);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}