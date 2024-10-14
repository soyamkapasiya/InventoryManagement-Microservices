package com.kapasiya.order_service.serviceimpl;

import com.kapasiya.order_service.dto.request.OrderRequestDto;
import com.kapasiya.order_service.dto.response.CustomResponseDto;
import com.kapasiya.order_service.dto.response.OrderResponseDto;
import com.kapasiya.order_service.entities.Order;
import com.kapasiya.order_service.exceptions.custom.OrderException;
import com.kapasiya.order_service.mapper.OrderMapper;
import com.kapasiya.order_service.repository.OrderRepository;
import com.kapasiya.order_service.service.OrderService;
import com.kapasiya.order_service.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public CustomResponseDto<Void> createOrder(OrderRequestDto requestDto){
        log.info("Creating Order With Request: {}",requestDto);
        try{
            Order order = OrderMapper.toEntity(requestDto);
            Long orderId = orderRepository.save(order).getId();
            log.info("Order Created With Id: {}",orderId);
            return ResponseUtil.successMessageResponse(HttpStatus.CREATED,
                    "Order Created Successfully...");
        }catch (OrderException ox){
            log.error("Unexpected Error While Creating Order: {}",ox.getMessage());
            throw ox;
        }catch (Exception ex){
            log.error("Exception Occurred While Creating Order: {}",ex.getMessage());
            throw new OrderException("Exception: "+ex.getMessage());
        }
    }

    @Override
    public CustomResponseDto<List<OrderResponseDto>> getAllOrders(){
        log.info("Getting All Orders...");
        try{
            List<Order> list = orderRepository.findAll();
            List<OrderResponseDto> response = list.stream().map(OrderMapper::toRDto).toList();
            return ResponseUtil.successDataResponse(HttpStatus.OK,
                    "Get All The Order Successfully",response);
        }catch (OrderException ox){
            log.error("Unexpected Error While Getting All The Orders: {}",ox.getMessage());
            throw ox;
        }catch (Exception ex){
            log.error("Exception Occurred While Getting All Orders: {}",ex.getMessage());
            throw new OrderException("Exception: "+ex.getMessage());
        }
    }
}
