package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.OrderItems;

import java.util.List;

public interface IOrderItemsService {
    List<OrderItems> findAll();

    OrderItems findById(Long id);

    OrderItems save(OrderItems orderItens);
}
