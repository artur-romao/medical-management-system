package com.mms.medmanagesystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.service.ProfissionalService;
import com.mms.medmanagesystem.service.PacienteService;
import com.mms.medmanagesystem.service.PessoaService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class PacienteController {
  
  @Autowired PessoaService pessoaService;
  @Autowired ProfissionalService profissionalService;
  @Autowired PacienteService pacienteService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/pacientes")
  public ModelAndView paciente(Model model, String keyword) throws NumberFormatException, ResourceNotFoundException {

    ModelAndView modelAndView = new ModelAndView();
    
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));
        
    boolean medic = false;
    
    if (profissional.getPro().equals("Medico")) {medic = true;}

    model.addAttribute("name", profissional.getPessoa().getName());
    model.addAttribute("medic", medic);

    List<Paciente> listaPacientes = pacienteService.getPacientes(); //todos os pacientes
    List<Paciente> listaFiltrada = pacienteService.findKeyword(keyword);
    
    if (keyword != null) { modelAndView.addObject("listaPacientes", listaFiltrada); }
    else { modelAndView.addObject("listaPacientes", listaPacientes); }

    modelAndView.setViewName("tables/pacientes");
    return modelAndView;
  }

  @GetMapping("pacientes/add")
  public ModelAndView addPacienteForm(Model model) throws NumberFormatException, ResourceNotFoundException {

    ModelAndView modelAndView = new ModelAndView();

    Pessoa pessoa = new Pessoa();
    model.addAttribute("pessoa", pessoa);

    Paciente paciente = new Paciente(pessoa);
    model.addAttribute("paciente", paciente);

    System.out.println("-----------------model------------------ " + model);
    
    modelAndView.setViewName("addpaciente");

    return modelAndView;
  }

  @RequestMapping("/edit/{pessoacc}")
    public ModelAndView updatePaciente(@PathVariable(name="pessoacc") int pessoacc) throws ResourceNotFoundException {
      ModelAndView modelEdit = new ModelAndView();

      Pessoa pessoa = pessoaService.getPessoaBycc(pessoacc);

      Paciente pac = pessoa.getPaciente();


      modelEdit.addObject("pac", pac);

      modelEdit.setViewName("editPaciente");

      return modelEdit;

    }

  @RequestMapping(value = "/editsave", method = RequestMethod.POST)
  
    public RedirectView editNewPaciente(@ModelAttribute("paciente") Paciente paciente) throws NumberFormatException, ResourceNotFoundException {
      
      int id = paciente.getId();
      System.out.println(paciente);
      
      pacienteService.updatePaciente(paciente);

      return new RedirectView("pacientes");
    }
  
  @PostMapping(value = "/save")
                       
  public RedirectView saveNewPaciente(Model model, @ModelAttribute("paciente") Paciente paciente) throws NumberFormatException, ResourceNotFoundException {
    
    Paciente pac = pacienteService.savePaciente(paciente);
    
    Pessoa pes = pessoaService.savePessoa(paciente.getPessoa());

    model.addAttribute("paciente", pac);
    model.addAttribute("pessoa", pes);


    System.out.println("\n-----------------model2------------------ " + model);

    return new RedirectView("pacientes");
  }
  
  
}