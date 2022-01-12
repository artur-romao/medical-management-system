package com.mms.medmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilController {

  @GetMapping("/perfil")
  public String perfil(Model model) {
    return "perfil";
  }

}
