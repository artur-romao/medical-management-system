package com.mms.medmanagesystem.controller;

import java.util.ArrayList;
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
import com.mms.medmanagesystem.repository.InternamentoRepository;
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
  @Autowired InternamentoRepository internamentoRepository;


  @Autowired ObjectFactory<HttpSession> httpSessionFactory;


  @GetMapping("/internados")
  public ModelAndView internado(Model model) throws NumberFormatException, ResourceNotFoundException {

    ModelAndView modelAndView = new ModelAndView();

    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));
    model.addAttribute("nome", profissional.getPessoa().getName());
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
      model.addAttribute("internadoid", internamento_id);

      modelAndView.setViewName("vitais");
      
      return modelAndView;
      
    } 

    // @GetMapping("/internados/{id}") 
    // public ModelAndView getInternamentosId(@PathVariable(value="id") int internamento_id, Model model) throws ResourceNotFoundException {
      
    //   ModelAndView modelAndView = new ModelAndView();
      
    //   // por aqui as variáveis do internado que são mostradas
      
    //   Paciente paciente = internamentoService.getInternamentoById(internamento_id).getPaciente();
    //   //model.addAttribute("internadoid", id);
      
    //   modelAndView.setViewName("internado");
    //   return modelAndView;
      
    // } 

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
      Paciente internado = pessoaService.getPessoaBycc(Integer.parseInt(paciente_cc)).getPaciente();
      
      
      if (internado != null) {
     
        internamento.setPaciente(internado);
        internamento.setProfissional(profissional);
        internamentoService.saveInternamento(internamento);

      }
  
      return new RedirectView("internados");
    }


    // update or delete ---------------------

  @RequestMapping("internados/edit/{id}")
  public ModelAndView updateInternamento(Model model, @PathVariable(name = "id") int id) throws ResourceNotFoundException {

    ModelAndView modelEdit = new ModelAndView();

    Internamento internamento = internamentoService.getInternamentoById(id);

    model.addAttribute("internamento", internamento);
    model.addAttribute("id", internamento.getId());

    System.out.println("-----internamento to edit---" + internamento);
    modelEdit.setViewName("editinternamento");

    return modelEdit;
  }

  @PostMapping(value = "/editinternado")
  public RedirectView saveInternamento(@ModelAttribute("internamento") Internamento internamento, HttpServletRequest request) throws NumberFormatException, ResourceNotFoundException {

    //System.out.println("-----internamento----" + internamento); // ta a dar null fodas e
    
    int id = internamento.getId();
    System.out.println("-----id----" + id);
    
    String button = request.getParameter("button");
    if ("Guardar".equals(button)) {
      internamentoService.updateInternamento(id, internamento);
    } else if ("Eliminar Internamento".equals(button)) {
      internamentoService.deleteInternamento(internamento);
    }

    return new RedirectView("internados");
  }



    // --------- delete

/*     @RequestMapping(value = "deleteinternamento/{id}", method = RequestMethod.GET)
    public RedirectView handleDeleteInternamento(@PathVariable String id) throws NumberFormatException, ResourceNotFoundException {
      internamentoService.deleteInternamento(Integer.parseInt(id));
      
      return new RedirectView("/internados");
    }
 */

    @GetMapping("/api/internados/{pessoacc}")
    public @ResponseBody Map<Integer,List<Object>>getInternamentosId(@PathVariable int pessoacc) throws ResourceNotFoundException {
      Paciente pac = pessoaService.getPessoaBycc(pessoacc).getPaciente();
      int pacid= pac.getId();

      Internamento inter = internamentoService.getInternamentoById(pacid);
      Paciente npac= inter.getPaciente();

      List<Object> a = new ArrayList<Object>(); 
      a.add(inter);
      a.add(npac);
      Map<Integer,List<Object>> b =new HashMap<Integer,List<Object>>();
      b.put(pessoacc,a);
      return b;
  }

}