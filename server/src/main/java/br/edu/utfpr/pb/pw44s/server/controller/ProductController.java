package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.ProductDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.ProductMapper;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {

    private final IProductService iProductService;
    private final ProductMapper productMapper;

    public ProductController(IProductService iProductService,
                             ProductMapper productMapper) {
        this.iProductService = iProductService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(
                iProductService.findAll()
                        .stream()
                        .map(productMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = iProductService.findById(id);

        if (product != null) {
            return ResponseEntity.ok(productMapper.toDTO(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("page")
    public ResponseEntity<Page<ProductDTO>> findPage(@RequestParam int page,
                                                     @RequestParam int size,
                                                     @RequestParam(required = false) String order,
                                                     @RequestParam(required = false) Boolean asc) {
        PageRequest pageRequest = PageRequest.of(page, size);

        if (order != null && asc != null) {
            pageRequest = PageRequest.of(page, size,
                    asc ? Sort.Direction.ASC : Sort.Direction.DESC, order);
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                iProductService.findAll(pageRequest).map(productMapper::toDTO));
    }
}