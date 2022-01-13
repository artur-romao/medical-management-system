package com.mms.medmanagesystem.controller;

import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Medico;
import com.mms.medmanagesystem.service.MedicoService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
  
  @Autowired
  MedicoService medicoService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/index")
  public ModelAndView index(Model model) throws NumberFormatException, ResourceNotFoundException {
    HttpSession session = httpSessionFactory.getObject();
    String medicoid = (String.valueOf(session.getAttribute("id_medico")));
    Medico medico = medicoService.getMedicoByID(Integer.parseInt(medicoid));
    model.addAttribute("id", medico.getId());
    model.addAttribute("area", medico.getArea().getName());
    model.addAttribute("nome", medico.getMedico().getNome());
    model.addAttribute("telemovel", medico.getMedico().getTelemovel());
    model.addAttribute("morada", medico.getMedico().getMorada());
    model.addAttribute("datanascimento", medico.getMedico().getDatanascimento());
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }

  @PostMapping("/index")
  public ModelAndView indexDistribution(Model model) throws NumberFormatException, ResourceNotFoundException {
    /* HttpSession session = httpSessionFactory.getObject();
    String medicoid = (String.valueOf(session.getAttribute("id_medico")));
    Medico medico = medicoService.getMedicoByIDMedico(Integer.parseInt(medicoid));
    model.addAttribute("id", medico.getId());
    model.addAttribute("area", medico.getArea().getName());
    model.addAttribute("nome", medico.getMedico().getNome());
    model.addAttribute("telemovel", medico.getMedico().getTelemovel());
    model.addAttribute("morada", medico.getMedico().getMorada());
    model.addAttribute("datanascimento", medico.getMedico().getDataNascimento()); */
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }
}