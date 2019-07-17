package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.CustomerOrder;

import java.util.List;

public interface ICustomerOrderService {
    public void save(CustomerOrder customerOrder);
    public CustomerOrder findById(Long id);
    public List<CustomerOrder> findAll();
    public void update(CustomerOrder customerOrder);
    public void delete(CustomerOrder customerOrder);
}
