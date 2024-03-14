package com.octaviookumu.orderservice.service;

import com.octaviookumu.orderservice.dto.OrderLineItemsDto;
import com.octaviookumu.orderservice.dto.OrderRequest;
import com.octaviookumu.orderservice.model.Order;
import com.octaviookumu.orderservice.model.OrderLineItems;
import com.octaviookumu.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        // create an object of type order
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        // map the orderLineItems (from the request as orderLineItemsDto) to the orderLineItems
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

}
