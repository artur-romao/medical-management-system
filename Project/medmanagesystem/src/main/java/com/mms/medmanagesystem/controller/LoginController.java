package com.mms.medmanagesystem.controller;

import com.mms.medmanagesystem.model.LoginCredentials;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @ModelAttribute("loginCredentials")
  public LoginCredentials loginCredentialsAttribute() {
    return new LoginCredentials();
  }

  @GetMapping("/")
  public String login(Model model) {
    return "login";
  }

  @PostMapping("/")
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
}