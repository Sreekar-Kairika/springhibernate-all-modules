package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public String  addMember(){
        System.out.println(getClass() + " : Doing my DB work ::" +
                " Adding a Membership Account");
        return "apple";
    }

}
