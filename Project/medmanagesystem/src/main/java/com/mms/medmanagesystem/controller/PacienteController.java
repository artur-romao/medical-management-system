package com.mms.medmanagesystem.controller;

<<<<<<< HEAD
import com.mms.medmanagesystem.service.PacienteService;
import com.mms.medmanagesystem.model.Paciente;

import java.util.List;
import org.springframework.stereotype.Controller;
=======
>>>>>>> 3735c4dad7a8ff2a5a600eb44650e1ed6ef5523e
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PacienteController {

  @GetMapping("/pacientes")
  public ModelAndView paciente(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("tables/pacientes");
    return modelAndView;
  }
  

/* 
  @RequestMapping(value="name", method= {RequestMethod.GET})
  public String name(@RequestParam String name, Model model){
      String name =   
  } */
  

}