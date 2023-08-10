package rog.account.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
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
        logger.info("Selected Account object is created for the case of adding");
        this.selectedAccount = new Account();
    }
    // Add Account
    public void saveAccount(){
        logger.info("Account to save: " + this.selectedAccount);
        if (this.selectedAccount.getIdAccount() == null){
            this.accountService.saveAccount(this.selectedAccount);
            this.accounts.add(this.selectedAccount);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Added Account"));
        }
        else { //Modify Account (Update)
            this.accountService.saveAccount(this.selectedAccount);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Updated Account"));
        }
        // we hide the window
        PrimeFaces.current().executeScript("PF('windowModalAccount').hide()");
        // update table
        PrimeFaces.current().ajax().update("shape-accounts:messages",
                "shape-accounts:account-table");

    }


}
