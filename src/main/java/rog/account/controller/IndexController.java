package rog.account.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rog.account.model.Account;
import rog.account.services.AccountService;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    AccountService accountService;
    private List<Account>accounts;
    private Account selectedAccount;

    private static final Logger logger =
            LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        loadData();
    }
    public void loadData(){
        this.accounts = accountService.listAccount();
        accounts.forEach((account)-> logger.info(account.toString()));
    }
    public void addAccount(){
        this.selectedAccount = new Account();


    }
}
