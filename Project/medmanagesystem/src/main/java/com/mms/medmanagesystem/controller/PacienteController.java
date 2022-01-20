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
  public ModelAndView paciente(Model model, String keyword) throws NumberFormatException, ResourceNotFoundException {
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));
    model.addAttribute("nome", profissional.getProfissional().getNome());
    ModelAndView modelAndView = new ModelAndView();

    List<Paciente> listaPacientes = pacienteService.getPacientes(); //todos os pacientes
    List<Paciente> listaFiltrada = pacienteService.findKeyword(keyword);
    
    if (keyword != null) {
      modelAndView.addObject("listaPacientes", listaFiltrada);
    }
    
    else{

      modelAndView.addObject("listaPacientes", listaPacientes);

    }

    modelAndView.setViewName("tables/pacientes");
    return modelAndView;
  }
  
}