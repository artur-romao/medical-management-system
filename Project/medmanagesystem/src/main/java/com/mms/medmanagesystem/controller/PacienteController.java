package com.mms.medmanagesystem.controller;

import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.service.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PacienteController {
  
  @Autowired private PacienteService service;

  @GetMapping("/pacientes")
  public ModelAndView paciente(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    List<Paciente> listaPacientes = service.getPacientes();
    //List<Pessoa> listaPessoas = 
    modelAndView.addObject("listaPacientes", listaPacientes);
    modelAndView.setViewName("tables/pacientes");

    return modelAndView;
  }
  

/* 
  @RequestMapping(value="name", method= {RequestMethod.GET})
  public String name(@RequestParam String name, Model model){
      String name =   
  } */
  

}