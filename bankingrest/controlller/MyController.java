package com.example.bankingrest.controlller;

import com.example.bankingrest.model.Account;
import com.example.bankingrest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
@Autowired
    private AccountService accountService;
    //to add the Account details using Account Object
    @PostMapping("add")
    public Object createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }
  //  to get all Account Details
    @GetMapping("get")
    public Object getAllAccountDetails(){
        return accountService.getAllAccountDetails();
    }
    @GetMapping("{get}")
    public ResponseEntity<Object> getAccountDetailsById(@PathVariable Long id){
        return accountService.getAccountDetailsById(id);
    }
    //to delete the account by id
    @DeleteMapping("{id}")
    public ResponseEntity<Object>deleteAccountById(@PathVariable Long id){
        return accountService.deleteAccountById(id);
    }
   //to udate Account details by id
    @PutMapping("update/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails){
        return accountService.updateAccount(id, accountDetails);
    }

}
