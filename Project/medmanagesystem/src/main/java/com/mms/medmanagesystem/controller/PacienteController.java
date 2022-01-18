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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    model.addAttribute("id", profissional.getId());
    model.addAttribute("area", profissional.getArea().getName());
    model.addAttribute("nome", profissional.getProfissional().getNome());
    model.addAttribute("telemovel", profissional.getProfissional().getTelemovel());
    model.addAttribute("morada", profissional.getProfissional().getMorada());
    model.addAttribute("datanascimento", profissional.getProfissional().getDatanascimento());
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
    //modelAndView.addObject("nameJs",  profissional.getProfissional().getNome());


    return modelAndView;
  }
 /*    */
 /* @GetMapping("/pacientes/{id}") */
 /*  public Paciente getPessoaBycc(@PathVariable(value="id") int id) throws ResourceNotFoundException { */
 /*      return pacienteService.getPacienteById(id); */
 /*  } */

  /* @GetMapping("/pacientesFiltered")
  public Paciente getPacienteFiltered(@PathVariable(value="id") int id) throws ResourceNotFoundException {
      return pacienteService.getPacienteById(id);
  } */

  /* 
  @RequestMapping(value="name", method= {RequestMethod.GET})
  public String name(@RequestParam String name, Model model){
      String name =   
  } */
  

}