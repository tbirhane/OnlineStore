package edu.mum.cs544.online_store.repository;


import edu.mum.cs544.online_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//
//    @Query("select photo from Product where id=?1")
//    byte[] getPhotoById(Long id);

}
