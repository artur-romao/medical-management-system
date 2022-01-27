package com.mms.medmanagesystem.controller;

import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.ProfissionalService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
  
  @Autowired
  ProfissionalService profissionalService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/index")
  public ModelAndView index(Model model) throws NumberFormatException, ResourceNotFoundException {
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

    boolean admin = false;
    if (profissional.getPro().equals("Admin")) { admin = true; }
    model.addAttribute("admin", admin);
    
    model.addAttribute("name", profissional.getPessoa().getName());

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }

}