package com.mms.medmanagesystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.service.ProfissionalService;
import com.mms.medmanagesystem.service.PacienteService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PacienteController {
  
  @Autowired
  ProfissionalService profissionalService;

  @Autowired 
  PacienteService pacienteService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;


  @GetMapping("/pacientes")
  public ModelAndView paciente(Model model) throws NumberFormatException, ResourceNotFoundException {
    List<Paciente> listaPacientes = pacienteService.getPacientes();
    ModelAndView modelAndView = new ModelAndView();
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