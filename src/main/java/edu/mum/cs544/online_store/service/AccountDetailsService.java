package edu.mum.cs544.online_store.service;

import edu.mum.cs544.online_store.model.Account;
import edu.mum.cs544.online_store.model.CustomAccountDetails;
import edu.mum.cs544.online_store.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountDetailsService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findAccountByUsername(username);
//		try {
//			account.orElseThrow(() -> new UsernameNotFoundException("User name not found"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		if(account == null){
			throw new UsernameNotFoundException("User name not found");
		}else
		return new CustomAccountDetails(account);
		
	}
}
	