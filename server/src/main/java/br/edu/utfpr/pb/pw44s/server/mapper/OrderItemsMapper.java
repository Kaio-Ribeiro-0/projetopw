package br.edu.utfpr.pb.pw44s.server.mapper;

import br.edu.utfpr.pb.pw44s.server.dto.OrderItensDTO;
import br.edu.utfpr.pb.pw44s.server.model.OrderItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemsMapper {
    @Mapping(target = "id", ignore = true)
    OrderItems toEntity(OrderItensDTO dto);
    OrderItensDTO toDTO(OrderItems entity);

}
