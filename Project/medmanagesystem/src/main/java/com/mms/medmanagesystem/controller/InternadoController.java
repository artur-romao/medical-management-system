package com.mms.medmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternadoController {

  @GetMapping("/internados")
  public String internado(Model model) {
    return "tables/internados";
  }

}