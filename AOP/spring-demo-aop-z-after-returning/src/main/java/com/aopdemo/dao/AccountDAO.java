package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    public String getName() {
        System.out.println(getClass()+" : in name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" : in name");
        this.name = name;

    }

    public String getServiceCode() {
        System.out.println(getClass()+" : in service");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" : in service");
        this.serviceCode = serviceCode;
    }

    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() + " : Doing my DB work ::" +
                " Add an account");
    }

    public void doWork( ){
        System.out.println(getClass() + " Doing Work  " );
    }

    // add a new method :: find Accounts
    public List<Account> findAccounts(){

        List<Account>  myAccounts = new ArrayList<>();

        //create sample Accounts
        Account temp1 = new Account("John","Silver");
        Account temp2 = new Account("Sreekar","Diamond");
        Account temp3 = new Account("John","Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

}
