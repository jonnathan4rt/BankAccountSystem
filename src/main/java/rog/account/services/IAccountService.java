package rog.account.services;

import rog.account.model.Account;
import java.util.List;

public interface IAccountService {
    public List<Account> listAccount();

    public Account findAccountById(Integer idAccount);

    public void saveAccount(Account account);

    public void deleteAccount(Account account);


}
