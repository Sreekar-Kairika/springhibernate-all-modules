package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() + " : Doing my DB work ::" +
                " Add an account");
    }

    public void doWork( ){
        System.out.println(getClass() + " Doing Work  " );
    }

}
