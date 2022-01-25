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

public class PerfilController {

  @Autowired
  ProfissionalService profissionalService;
  
  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/perfil")
  public ModelAndView perfil(Model model) throws NumberFormatException, ResourceNotFoundException {
    
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

    model.addAttribute("id", profissional.getId());
    model.addAttribute("area", profissional.getArea().getName());
    model.addAttribute("name", profissional.getPessoa().getName());
    model.addAttribute("telemovel", profissional.getPessoa().getTelemovel());
    model.addAttribute("morada", profissional.getPessoa().getMorada());
    model.addAttribute("datanascimento", profissional.getPessoa().getDatanascimento());

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("perfil");
    return modelAndView;
  }

}