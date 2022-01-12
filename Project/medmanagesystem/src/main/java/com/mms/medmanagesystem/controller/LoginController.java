/* package com.mms.medmanagesystem.controller;

import com.mms.medmanagesystem.model.LoginCredentials;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class LoginController {
/* 
  @ModelAttribute("loginCredentials")
  public LoginCredentials loginCredentialsAttribute() {
    return new LoginCredentials();
  }

  @GetMapping(value="/login") 
  @ResponseBody
  public String login(Model model) {
    return "login";
  }

  @PostMapping("/{user}")
  public String loginChecking(@ModelAttribute LoginCredentials loginCredentials, Model model) {
    String medicoId = loginCredentials.getMedicoid();
    String password = loginCredentials.getPassword();
    if (password.equals("password")) {
      return "index";
    }
    else {
      model.addAttribute("error", "Dados de sessão inválidos!");
      return "login";
    }
  }
} */