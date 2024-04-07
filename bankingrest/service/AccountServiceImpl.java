package com.example.bankingrest.service;

import com.example.bankingrest.model.Account;
import com.example.bankingrest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Object createAccount(Account account) {
         if(accountRepository.existsById(account.getId())){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
         }
         return accountRepository.save(account);
    }

    @Override
    public Object getAllAccountDetails() {
        List<Account> accounts = accountRepository.findAll();
        if(accounts.isEmpty()){
            return null;
        } else {
            return accounts;
        }
    }

    @Override
    public ResponseEntity<Object> getAccountDetailsById(Long id) {
        Optional<Account> accountFetch = accountRepository.findById(id);
        if(accountFetch.isPresent()){
            accountRepository.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(200);
        } else {
         return ResponseEntity.status(HttpStatus.OK).body(400);
        }
    }

    @Override
    public ResponseEntity<Object> deleteAccountById(Long id) {
        Optional<Account> accountFetch = accountRepository.findById(id);
        if (accountFetch.isPresent()){
            accountRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(200);

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }
    }
    @Override
    public ResponseEntity<Object> updateAccount(Long id, Account accountDetails) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account existingAccount = optionalAccount.get();
        if(existingAccount.getId() == id){
            existingAccount.setAccountHolderName(accountDetails.getAccountHolderName());
            existingAccount.setBalance(accountDetails.getBalance());
            Account saveAccountDetails = accountRepository.save(existingAccount);
            return ResponseEntity.ok(saveAccountDetails);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }
    }
}
