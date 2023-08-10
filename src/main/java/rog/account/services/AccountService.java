package rog.account.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rog.account.model.Account;
import rog.account.repository.RepositoryAccount;

import java.util.List;
@Service
public class AccountService implements IAccountService{

    @Autowired
    private RepositoryAccount repositoryAccount;


    @Override
    public List<Account> listAccount() {
        return repositoryAccount.findAll();
    }

    @Override
    public Account findAccountById(Integer idAccount) {
            return repositoryAccount.findById(idAccount).orElse(null);
    }

    @Override
    public void saveAccount(Account account) {
        repositoryAccount.save(account);

    }

    @Override
    public void deleteAccount(Account account) {
        repositoryAccount.delete(account);

    }
}
