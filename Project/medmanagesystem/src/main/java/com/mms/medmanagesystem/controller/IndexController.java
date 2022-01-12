package com.mms.medmanagesystem.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @GetMapping("/index")
  public String index(Model model) {
    return "index";
  }

}