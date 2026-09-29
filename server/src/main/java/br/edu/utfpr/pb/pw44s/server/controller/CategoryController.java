package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.CategoryDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.CategoryMapper;
import br.edu.utfpr.pb.pw44s.server.model.Category;
import br.edu.utfpr.pb.pw44s.server.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final ICategoryService iCategoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(ICategoryService iCategoryService,
                              CategoryMapper categoryMapper) {
        this.iCategoryService = iCategoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return ResponseEntity.ok(
                iCategoryService.findAll()
                        .stream()
                        .map(categoryMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        Category category = iCategoryService.findById(id);

        if (category != null) {
            return ResponseEntity.ok(categoryMapper.toDto(category));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
