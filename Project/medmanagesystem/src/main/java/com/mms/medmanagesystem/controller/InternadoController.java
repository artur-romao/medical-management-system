package com.mms.medmanagesystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Profissional;
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
  InternamentoService internamentoService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/internados")
  public ModelAndView internado(Model model) throws NumberFormatException, ResourceNotFoundException {
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));
    model.addAttribute("id", profissional.getId());
    List<Internamento> listaInternamentos = internamentoService.getInternamentosByProfissionalId(Integer.parseInt(profissionalid));
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("listaInternamentos", listaInternamentos);
    modelAndView.setViewName("tables/internados");
    return modelAndView;
  }

}