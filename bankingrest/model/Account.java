package com.example.bankingrest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_info")
public class Account {
    @Id
    private Long id;
    private String accountHolderName;
    private double balance;

    public Account(Long id, String accountHolderName, double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//    @Override
//    public String toString() {
//        return "Account{" +
//                "id=" + id +
//                ", accountHolderName='" + accountHolderName + '\'' +
//                ", balance=" + balance +
//                '}';
 //   }
}
