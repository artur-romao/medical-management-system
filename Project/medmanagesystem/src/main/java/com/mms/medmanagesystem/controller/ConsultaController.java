package com.mms.medmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultaController {

  @GetMapping("/consultas")
  public String consulta(Model model) {
    return "consultas";
  }

}