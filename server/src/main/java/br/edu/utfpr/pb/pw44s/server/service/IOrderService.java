package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Order;

import java.util.List;

public interface IOrderService {

    Order save(Order order);

    List<Order> findAllByUserUsername(String username);

    Order findById(Long id);
}