package com.mms.medmanagesystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.LoginCredentials;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.PessoaService;
import com.mms.medmanagesystem.service.ProfissionalService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LoginController {

  @Autowired private ProfissionalService profissionalService;
  @Autowired private PessoaService pessoaService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("loginCredentials")
  public LoginCredentials loginCredentialsAttribute() {
    return new LoginCredentials();
  }

  @GetMapping("/") 
  @ResponseBody
  public RedirectView login(HttpServletRequest request, Model model) {

    if (request.getSession().getAttribute("id_profissional") == null) {
      return new RedirectView("login");  
    } 
    return new RedirectView("index");
  }

  @GetMapping("/login")
  public ModelAndView viewLogin(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
  }

  @PostMapping("/")
  public RedirectView loginChecking(@ModelAttribute LoginCredentials loginCredentials, Model model) throws NumberFormatException, ResourceNotFoundException {
    HttpSession session = httpSessionFactory.getObject();
    String profissionalcc = loginCredentials.getProfissionalcc();
    String password = loginCredentials.getPassword();
    
    Pessoa profissional = pessoaService.getPessoaBycc(Integer.parseInt(profissionalcc));
    
    if (profissional.getProfissional().getPassword().equals(password)) {
      session.setAttribute("profissional_cc", profissionalcc);
      session.setAttribute("id_profissional", profissional.getProfissional().getId());
      return new RedirectView("index");
    }
    else {
      // model.addAttribute("error", "Dados de sessão inválidos!"); // Isto é suposto ser uma MsgBox
      // modelAndView.setViewName("login");
      return new RedirectView("login");    
    }
  }
}