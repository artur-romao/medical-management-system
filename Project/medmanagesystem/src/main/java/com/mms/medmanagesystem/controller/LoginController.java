package com.mms.medmanagesystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.LoginCredentials;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.ProfissionalService;

import org.springframework.beans.factory.ObjectFactory;
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
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LoginController {

  @Autowired
  private ProfissionalService profissionalService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("loginCredentials")
  public LoginCredentials loginCredentialsAttribute() {
    return new LoginCredentials();
  }

  @GetMapping("/") 
  @ResponseBody
  public RedirectView login(HttpServletRequest request, Model model) {
    System.out.println(request.getSession().getAttribute("id_profissional")); 
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
    String profissionalid = loginCredentials.getProfissionalid();
    String password = loginCredentials.getPassword();
    
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));
    
    if (profissional.getPassword().equals(password)) {
      session.setAttribute("id_Profissional", profissionalid);
      session.setAttribute("pessoa_cc", profissional.getProfissional().getPessoacc());
      return new RedirectView("index");
    }
    else {
      // model.addAttribute("error", "Dados de sessão inválidos!"); // Isto é suposto ser uma MsgBox
      // modelAndView.setViewName("login");
      return new RedirectView("login");    
    }
  }
}