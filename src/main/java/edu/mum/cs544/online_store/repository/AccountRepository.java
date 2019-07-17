package edu.mum.cs544.online_store.repository;

import edu.mum.cs544.online_store.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("from Account where userName=email")
    public Account findByUserName(String email);
}
