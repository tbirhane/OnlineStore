package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.User;
import edu.mum.cs544.online_store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public User findById(long id) {
        return repository.findById(id).get();
    }
}
