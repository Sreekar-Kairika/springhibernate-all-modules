package com.springsecurity.demo.controller;

import com.springsecurity.demo.entity.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        return "fancy-login";
    }

    //access denied page
    @GetMapping("/access-denied")
    public String showAccessDenied(){

        return "access-denied";
    }

    @GetMapping("/signup")
    public String showSignUp(Model theModel){
        UserRegistration user=new UserRegistration();
        theModel.addAttribute("user",user);
        return "fancy-signup";
    }

    @PostMapping("/saveUser")
    public String  saveUser(@ModelAttribute("theUser") UserRegistration myUser){
        System.out.println(myUser);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        User user = new User(myUser.getUsername(),"{noop}"+ myUser.getPassword(), authorities);
        jdbcUserDetailsManager.createUser(user);
        return "redirect:/showMyLoginPage";

    }

}
