package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.CustomerOrder;
import edu.mum.cs544.online_store.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerOrderService implements ICustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Override
    public void save(CustomerOrder customerOrder) {
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public CustomerOrder findById(Long id) {
        return customerOrderRepository.findById(id).get();
    }

    @Override
    public List<CustomerOrder> findAll() {
        return customerOrderRepository.findAll();
    }

    @Override
    public void update(CustomerOrder customerOrder) {
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public void delete(CustomerOrder customerOrder) {
        customerOrderRepository.delete(customerOrder);
    }
}
