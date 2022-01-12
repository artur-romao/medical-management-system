package com.mms.medmanagesystem.controller;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.LoginCredentials;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

  @Autowired
  private PessoaService pessoaService;

  @ModelAttribute("loginCredentials")
  public LoginCredentials loginCredentialsAttribute() {
    return new LoginCredentials();
  }

  @GetMapping("/") 
  @ResponseBody
  public ModelAndView login(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
  }

  @PostMapping("/")
  public ModelAndView loginChecking(@ModelAttribute LoginCredentials loginCredentials, Model model) throws NumberFormatException, ResourceNotFoundException {
    String cc = loginCredentials.getCC();
    String password = loginCredentials.getPassword();
    ModelAndView modelAndView = new ModelAndView();
    
    Pessoa pessoa = pessoaService.getPessoaByCc(Integer.parseInt(cc));
    if (password.equals("password")) {
      modelAndView.setViewName("index");
      return modelAndView;
    }
    else {
      model.addAttribute("error", "Dados de sessão inválidos!"); // Isto é suposto ser uma MsgBox
      modelAndView.setViewName("index");
      return modelAndView;    
    }
  }
}