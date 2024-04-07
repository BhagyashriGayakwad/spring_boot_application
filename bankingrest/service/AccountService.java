package com.example.bankingrest.service;

import com.example.bankingrest.model.Account;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    public Object createAccount(Account account);
    public Object getAllAccountDetails();
    public ResponseEntity<Object> getAccountDetailsById(Long id);
    public ResponseEntity<Object>deleteAccountById( Long id);
    //public Account updateAccount(Long id, Account accountDetails);
    public ResponseEntity<Object> updateAccount(Long id,Account accountDetails);
    //public ResponseEntity<Object> gerSimilar(String accountHolderName);


}
