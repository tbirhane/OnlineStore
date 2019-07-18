package edu.mum.cs544.online_store.repository;

import edu.mum.cs544.online_store.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

   // @Query("select a from Account a where a.userName=email")
   // public Account findByUserName(String email);
    public Account findAccountByUsername(String username);

}
