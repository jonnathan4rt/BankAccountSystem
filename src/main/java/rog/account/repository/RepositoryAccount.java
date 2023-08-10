package rog.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rog.account.model.Account;

public interface RepositoryAccount extends JpaRepository<Account, Integer> {



}
