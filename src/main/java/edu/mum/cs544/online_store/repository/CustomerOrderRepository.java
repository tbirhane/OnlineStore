package edu.mum.cs544.online_store.repository;

import edu.mum.cs544.online_store.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
}
