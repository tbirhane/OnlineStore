package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.Account;
import edu.mum.cs544.online_store.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account findByUserName(String email) {
        return accountRepository.findByUserName(email);
    }
}
