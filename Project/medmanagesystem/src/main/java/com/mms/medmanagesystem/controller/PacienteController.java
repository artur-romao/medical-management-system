package com.mms.medmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

  @GetMapping("/pacientes")
  public String paciente(Model model) {
    return "tables/pacientes";
  }

}