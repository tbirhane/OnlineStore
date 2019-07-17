package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.User;

import java.util.List;

public interface IUserService {
    public void save(User user);
    public List<User> findAll();
    public void deleteById(long id);
    public User findById(long id);
}
