package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItensDTO {

    private Long id;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;

    private Long productId;
}
