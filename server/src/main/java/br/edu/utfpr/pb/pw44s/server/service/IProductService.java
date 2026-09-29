package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Product;

import java.util.List;

public interface IProductService {
    Product save(Product product);
    Product findById(Long id);
    List<Product> findAll();
    void delete(Long id);
}
