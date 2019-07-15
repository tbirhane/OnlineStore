package edu.mum.cs544.online_store.repository;


import edu.mum.cs544.online_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
