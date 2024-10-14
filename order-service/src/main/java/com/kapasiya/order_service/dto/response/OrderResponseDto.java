package com.kapasiya.order_service.dto.response;

import com.kapasiya.order_service.entities.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private Long id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItems;
}
