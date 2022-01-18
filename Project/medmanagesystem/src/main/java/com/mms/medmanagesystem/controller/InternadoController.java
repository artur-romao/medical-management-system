package com.mms.medmanagesystem.controller;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.service.InternamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InternadoController {
  @Autowired
  private InternamentoService service;
  
  @GetMapping("/internados")
  public ModelAndView internado(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("tables/internados");
    return modelAndView;
  }
  /*   public Internamento getInternamentosId(@PathVariable(value="id") int internamento_id) throws ResourceNotFoundException {
    Internamento Internamentos = service.getInternamentoById(internamento_id);
    return Internamentos;
    
  } */
  @GetMapping("/internados/{id}")
  public @ResponseBody Internamento
    getInternamentosId(@PathVariable String id) throws ResourceNotFoundException {
      Internamento Internamentos = service.getInternamentoById(Integer.parseInt(id));
      return Internamentos;
  }
}