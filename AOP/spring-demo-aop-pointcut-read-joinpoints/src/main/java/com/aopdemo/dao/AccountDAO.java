package com.aopdemo.dao;

import com.aopdemo.Account;
//import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.stereotype.Component;

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

}
