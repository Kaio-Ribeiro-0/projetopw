package br.edu.utfpr.pb.pw44s.server.mapper;


import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    @Mapping(target = "id", ignore = true)
    Address toEntity(AddressDTO addressDTO);
    AddressDTO toDTO(Address address);
}
