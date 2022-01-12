package com.mms.medmanagesystem.controller;

import com.mms.medmanagesystem.service.PacienteService;
import com.mms.medmanagesystem.model.Paciente;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class PacienteController {

  @AutoWired private PacienteService service;
  
  @RequestMapping("/pacientes")
  public String showListPacientes(Model model) {
    
    List<Paciente> listaPacientes = service.getPacientes();
    model.addAttribute("listaPacientes", listaPacientes);
    return "login";
    
  }
  

/* 
  @RequestMapping(value="name", method= {RequestMethod.GET})
  public String name(@RequestParam String name, Model model){
      String name =   
  } */
  

}