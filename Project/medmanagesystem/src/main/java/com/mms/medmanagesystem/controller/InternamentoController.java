package com.mms.medmanagesystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.InternamentoService;
import com.mms.medmanagesystem.service.PacienteService;
import com.mms.medmanagesystem.service.PessoaService;
import com.mms.medmanagesystem.service.ProfissionalService;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class InternamentoController {
  
  @Autowired ProfissionalService profissionalService;
  @Autowired PacienteService pacienteService;
  @Autowired InternamentoService internamentoService;
  @Autowired PessoaService pessoaService;

  @Autowired ObjectFactory<HttpSession> httpSessionFactory;


  @GetMapping("/internados")
  public ModelAndView internado(Model model) throws NumberFormatException, ResourceNotFoundException {

    ModelAndView modelAndView = new ModelAndView();

    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

    model.addAttribute("name", profissional.getPessoa().getName());

    List<Internamento> listaInternamentos = internamentoService.getInternamentosByProfissionalId(Integer.parseInt(profissionalid));

    modelAndView.addObject("listaInternamentos", listaInternamentos);
    modelAndView.setViewName("tables/internados");

    return modelAndView;
  }

  @GetMapping("/internados/{pessoacc}") 
    public ModelAndView getInternamentosId(@PathVariable(value="pessoacc") int pessoacc, Model model) throws ResourceNotFoundException {
      
      ModelAndView modelAndView = new ModelAndView();
      
      Paciente internado = pessoaService.getPessoaBycc(pessoacc).getPaciente();

      int internamento_id = internamentoService.getInternamentoIdByPaciente(internado.getId());

      // por aqui as variáveis do internado que são mostradas
      internamentoService.getInternamentoById(internamento_id).getPaciente();
      //model.addAttribute("internadoid", id);
      
      modelAndView.setViewName("internado");
      
      return modelAndView;
      
    } 

    // add --------------------------

    @GetMapping("internados/add")
    public ModelAndView addInternamentoForm(Model model) throws NumberFormatException, ResourceNotFoundException {
  
      ModelAndView modelAndView = new ModelAndView();
  
      Internamento internamento = new Internamento();
      model.addAttribute("internamento", internamento);
      
      modelAndView.setViewName("addinternamento");
  
      return modelAndView;
    }

    @PostMapping(value = "/saveinternado")
    public RedirectView saveNewInternamento(@ModelAttribute("internamento") Internamento internamento, HttpServletRequest request) throws NumberFormatException, ResourceNotFoundException {   

      HttpSession session = httpSessionFactory.getObject();
      String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
      Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

      internamento.setId(internamentoService.getInternamentos().size()+1);
      
      String paciente_cc = request.getParameter("paciente_cc");
      Pessoa internado = pessoaService.getPessoaBycc(Integer.parseInt(paciente_cc));
      
      
      if (internado.getPaciente() != null) {
     
        internamento.setPaciente(internado.getPaciente());
        internamento.setProfissional(profissional);

        System.out.println(internamento);
        internamentoService.saveInternamento(internamento);

      }
  
      return new RedirectView("internados");
    }


    // --------- delete

    @RequestMapping(value = "deleteinternamento/{id}", method = RequestMethod.GET)
    public RedirectView handleDeleteInternamento(@PathVariable String id) throws NumberFormatException, ResourceNotFoundException {
      internamentoService.deleteInternamento(Integer.parseInt(id));
      
      return new RedirectView("/internados");
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