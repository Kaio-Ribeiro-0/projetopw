package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.OrderItems;
import br.edu.utfpr.pb.pw44s.server.repository.OrderItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements IOrderItemsService {
    private final OrderItemsRepository orderItensRepository;

    public OrderItemsServiceImpl(OrderItemsRepository orderItensRepository) {
        this.orderItensRepository = orderItensRepository;
    }

    @Override
    public List<OrderItems> findAll() {
        return orderItensRepository.findAll();
    }

    @Override
    public OrderItems findById(Long id) {
        return orderItensRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItems save(OrderItems orderItens) {
        return this.orderItensRepository.save(orderItens);
    }
}
