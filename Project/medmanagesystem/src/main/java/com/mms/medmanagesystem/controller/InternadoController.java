package com.mms.medmanagesystem.controller;

import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.service.InternamentoService;
import com.mms.medmanagesystem.service.ProfissionalService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InternadoController {
  
  @Autowired
  ProfissionalService profissionalService;
  
  @Autowired 
  InternamentoService internadoService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/internados")
  public ModelAndView internado(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("tables/internados");
    return modelAndView;
  }

}