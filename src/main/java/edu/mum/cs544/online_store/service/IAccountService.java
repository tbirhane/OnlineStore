package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    public Account findById(Long id);
    public void save(Account account);
    public List<Account> findAll();
    public void delete(Account account);
    public Account findByUserName(String email);
}
