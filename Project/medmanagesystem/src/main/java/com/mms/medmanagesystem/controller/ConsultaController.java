package com.mms.medmanagesystem.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {

  @GetMapping("/consultas")
  public String consulta(Model model) {
    return "consultas";
  }

}