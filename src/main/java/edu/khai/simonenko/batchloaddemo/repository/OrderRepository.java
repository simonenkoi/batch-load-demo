package edu.khai.simonenko.batchloaddemo.repository;

import edu.khai.simonenko.batchloaddemo.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
