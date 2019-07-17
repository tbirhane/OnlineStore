package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.Product;

import java.sql.Blob;
import java.util.List;

public interface IProductService {
    public void save(Product product);
    public Product findById(Long id);
    public List<Product> findAll();
    public void update(Product product);
    public void deleteById(Long id);
  //  public byte[] getPhotoById(Long id);
}
