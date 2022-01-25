package com.mms.medmanagesystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class PacienteController {

  @Autowired
  PessoaService pessoaService;
  @Autowired
  ProfissionalService profissionalService;
  @Autowired
  PacienteService pacienteService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/pacientes")
  public ModelAndView paciente(Model model, String keyword) throws NumberFormatException, ResourceNotFoundException {

    ModelAndView modelAndView = new ModelAndView();

    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

    boolean medic = false;

    if (profissional.getPro().equals("Medico")) {
      medic = true;
    }

    model.addAttribute("name", profissional.getPessoa().getName());
    model.addAttribute("medic", medic);

    List<Paciente> listaPacientes = pacienteService.getPacientes(); // todos os pacientes
    List<Paciente> listaFiltrada = pacienteService.findKeyword(keyword);

    if (keyword != null) {
      modelAndView.addObject("listaPacientes", listaFiltrada);
    } else {
      modelAndView.addObject("listaPacientes", listaPacientes);
    }

    modelAndView.setViewName("tables/pacientes");
    return modelAndView;
  }

  // add ---------------------

  @GetMapping("pacientes/add")
  public ModelAndView addPacienteForm(Model model) throws NumberFormatException, ResourceNotFoundException {

    ModelAndView modelAndView = new ModelAndView();

    Pessoa paciente = new Pessoa();
    model.addAttribute("paciente", paciente);

    modelAndView.setViewName("addpaciente");

    return modelAndView;
  }

  @PostMapping(value = "/savepaciente")
  public RedirectView saveNewPaciente(@ModelAttribute("paciente") Pessoa paciente)
      throws NumberFormatException, ResourceNotFoundException {

    Paciente pac = new Paciente(paciente);
    pacienteService.savePaciente(pac);

    return new RedirectView("pacientes");
  }

  // update or delete ---------------------

  @RequestMapping("pacientes/edit/{pessoacc}")
  public ModelAndView updatePaciente(Model model, @PathVariable(name = "pessoacc") int pessoacc)
      throws ResourceNotFoundException {

    ModelAndView modelEdit = new ModelAndView();

    Pessoa paciente = pessoaService.getPessoaBycc(pessoacc);

    model.addAttribute("paciente", paciente);

    modelEdit.setViewName("editpaciente");

    return modelEdit;
  }

  @PostMapping(value = "/editpaciente")
  public RedirectView savePaciente(@ModelAttribute("paciente") Pessoa paciente, HttpServletRequest request)
      throws NumberFormatException, ResourceNotFoundException {

    String button = request.getParameter("button");
    if ("Guardar".equals(button)) {
      pessoaService.updatePessoa(paciente);
    } else if ("Eliminar Paciente".equals(button)) {
      pessoaService.deletePessoa(paciente);
    }

    return new RedirectView("pacientes");
  }

  // delete ---------------------

/*   @RequestMapping(value = "/pacientes/delete/{pessoacc}")
  public ModelAndView deletePaciente(Model model, @PathVariable(name = "pessoacc") int pessoacc)
      throws ResourceNotFoundException {

    ModelAndView modelEdit = new ModelAndView();

    Pessoa paciente = pessoaService.getPessoaBycc(pessoacc);

    model.addAttribute("paciente", paciente);

    modelEdit.setViewName("deletePaciente");

    return modelEdit;
  } 
   @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public RedirectView editNewPaciente(@ModelAttribute("paciente") Paciente paciente) throws NumberFormatException, ResourceNotFoundException {
      
      int id = paciente.getId();
      System.out.println(paciente);
      
      pacienteService.updatePaciente(paciente);
  
  */

}