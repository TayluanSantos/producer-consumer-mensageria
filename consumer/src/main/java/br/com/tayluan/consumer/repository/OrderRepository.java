package br.com.tayluan.consumer.repository;

import br.com.tayluan.consumer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
