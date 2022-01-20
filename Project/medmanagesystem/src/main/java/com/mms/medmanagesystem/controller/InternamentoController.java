package com.mms.medmanagesystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.InternamentoService;
import com.mms.medmanagesystem.service.ProfissionalService;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InternamentoController {
  
  @Autowired
  ProfissionalService profissionalService;
  
  @Autowired 
  InternamentoService internamentoService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/internados")
  public ModelAndView internado(Model model) throws NumberFormatException, ResourceNotFoundException {
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));
    model.addAttribute("name", profissional.getPessoa().getName());
    List<Internamento> listaInternamentos = internamentoService.getInternamentosByProfissionalId(Integer.parseInt(profissionalid));
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("listaInternamentos", listaInternamentos);
    modelAndView.setViewName("tables/internados");
    return modelAndView;
  }

  @GetMapping("/internado/{id}") 
    public ModelAndView getInternamentosId(@PathVariable(value="id") int internamento_id, Model model) throws ResourceNotFoundException {
      ModelAndView modelAndView = new ModelAndView();
      // por aqui as variáveis do internado que são mostradas
      Paciente paciente = internamentoService.getInternamentoById(internamento_id).getPaciente();
      //model.addAttribute("internadoid", id);
      modelAndView.setViewName("internado");
      return modelAndView;
      
    } 
  @GetMapping("/api/internado/{id}")
    public @ResponseBody Map<Internamento,Paciente> getInternamentosId(@PathVariable String id) throws ResourceNotFoundException {
      Internamento inter = internamentoService.getInternamentoById(Integer.parseInt(id));
      Paciente pac = inter.getPaciente();
      Map<Internamento,Paciente> a = new HashMap<Internamento,Paciente>(); 
      a.put(inter,pac);
      return a;
  }

}