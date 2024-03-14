package com.octaviookumu.orderservice.repository;

import com.octaviookumu.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
