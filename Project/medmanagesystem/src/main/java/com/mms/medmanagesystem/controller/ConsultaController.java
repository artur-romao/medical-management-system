package com.mms.medmanagesystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import com.mms.medmanagesystem.exception.ResourceNotFoundException;

import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.service.ConsultaService;
import com.mms.medmanagesystem.service.PacienteService;

import com.mms.medmanagesystem.service.ProfissionalService;
import com.zaxxer.hikari.util.SuspendResumeLock;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ConsultaController {

  @Autowired
  ConsultaService consultaService;

  @Autowired
  ProfissionalService profissionalService;

  @Autowired
  ConsultaService consultaService;

  @Autowired
  PacienteService pacienteService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/consultas")
  public ModelAndView consulta(Model model) throws NumberFormatException, ResourceNotFoundException {

    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

    boolean admin = false;
    if (profissional.getPro().equals("Admin")) { admin = true; }
    model.addAttribute("admin", admin);

    model.addAttribute("name", profissional.getPessoa().getName());
    
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("consultas");
    
    return modelAndView;
  }

  @GetMapping("/agendacomum") 
    public List<Consulta> getAllConsultas() {
      return consultaService.getConsultas();
    
  } 
   
 @GetMapping("consulta/{id}")
  public ModelAndView showConsulta(Model model, @PathVariable(name = "id") int id) throws ResourceNotFoundException {
    Consulta consulta = consultaService.getConsultaByID(id);
    Pessoa paciente = consulta.getPaciente().getPessoa();
    model.addAttribute("consulta", consulta);
    model.addAttribute("paciente", paciente);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("consulta");
    return modelAndView;
  }

  @GetMapping("/listaconsultas")
  public ModelAndView allConsultas(Model model) throws ResourceNotFoundException {
    List <Consulta> lista = getAllConsultas();
    model.addAttribute("listaConsultas", lista);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("tables/consultastable");
    return modelAndView;
  }

  @GetMapping("consultas/add")
    public ModelAndView addConsultaForm(Model model) throws NumberFormatException, ResourceNotFoundException {

        ModelAndView modelAndView = new ModelAndView();

        Consulta consulta = new Consulta();
        List <Profissional> listaProfissionais = profissionalService.getProfissionais();
        model.addAttribute("profissionais", listaProfissionais);

        List<Paciente> listaPacientes = pacienteService.getPacientes();
        model.addAttribute("pacientes", listaPacientes);

        model.addAttribute("consulta", consulta);


        modelAndView.setViewName("addconsulta");
        System.out.println(consulta);
        return modelAndView;
    }

    @PostMapping(value = "/saveconsulta")
    public RedirectView saveNewProfissional(@ModelAttribute("consulta") Consulta consulta,  HttpServletRequest request) throws NumberFormatException, ResourceNotFoundException {
       
        consulta.setId(consultaService.getConsultas().size()+1);
        String pacienteId = request.getParameter("paciente");
        String profissionalId = request.getParameter("profissional");
        consulta.setProfissional(profissionalService.getProfissionalByID(Integer.parseInt(profissionalId)));
        consulta.setPaciente(pacienteService.getPacienteById(Integer.parseInt(pacienteId)));
    
        consultaService.saveConsulta(consulta); 

        return new RedirectView("listaconsultas");
    }


}



  


  @GetMapping("consultas/getconsultas")
  public List<Consulta> getConsultas(Model model) {
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    List<Consulta> listaConsultas = consultaService.getConsultas();
    List<Consulta> listaConsultasProfissional = new ArrayList<Consulta>();
    for (Consulta c : listaConsultas) {
      if (c.getProfissional().getId() == Integer.parseInt(profissionalid)) {
        listaConsultasProfissional.add(c);
      }
    }
    return listaConsultasProfissional;
  }

  @GetMapping("consulta/{id}")
  public ModelAndView showConsulta(Model model, @PathVariable(name = "id") int id, HttpServletRequest request) throws ResourceNotFoundException {
    Consulta consulta = consultaService.getConsultaByID(id);
    Pessoa paciente = consulta.getPaciente().getPessoa();
    model.addAttribute("consulta", consulta);
    model.addAttribute("paciente", paciente);
    model.addAttribute("id", id);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("consulta");
    return modelAndView;
  }

  @PostMapping("consulta/{id}")
  public RedirectView editConsulta(Model model, @ModelAttribute("consulta") Consulta consulta, HttpServletRequest request) throws NumberFormatException, ResourceNotFoundException{
    String button = request.getParameter("button");
    System.out.println(button);
    if ("Guardar".equals(button)) {
      consultaService.updateConsulta(consulta);
    }
    return new RedirectView("../consultas");
  }
}

