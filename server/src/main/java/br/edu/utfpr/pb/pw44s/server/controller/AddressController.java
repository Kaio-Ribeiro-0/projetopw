package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.AddressMapper;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("addresses")
public class AddressController {

    private final IAddressService iAddressService;
    private final AddressMapper addressMapper;

    public AddressController(IAddressService iAddressService,
                             AddressMapper addressMapper) {
        this.iAddressService = iAddressService;
        this.addressMapper = addressMapper;
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.ok(
                iAddressService.findAll()
                        .stream()
                        .map(addressMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        Address address = iAddressService.findById(id);

        if (address != null) {
            return ResponseEntity.ok(addressMapper.toDTO(address));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}