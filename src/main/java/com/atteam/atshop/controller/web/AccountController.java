package com.atteam.atshop.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.atteam.atshop.model.Account;
import com.atteam.atshop.service.IAccountService;

@Controller
public class AccountController {
	
	@Autowired
	IAccountService accountService;
	
	@GetMapping("/account/register")
	public String register(Model model) {
		model.addAttribute("account", new Account());
		return "web/security/register";
	}
	
    @PostMapping("/account/register")
    public String registerUser(@ModelAttribute Account account) {
        accountService.create(account);     
        return "web/security/register";
    }
    
    @GetMapping("/account/forgot-pass")
    public String forgotPass() {
    	return "web/security/forgot-pass";
    }
    
    // send email
//    @PostMapping("/account/forgot-pass")
//    public String getNewPassword(@PathVariable("email") String email) {
//    	Account account = accountService.resetPassword(email);
//    	if(account != null) {
//    		// emailService lam viec
//    	}
//    }
	
}
