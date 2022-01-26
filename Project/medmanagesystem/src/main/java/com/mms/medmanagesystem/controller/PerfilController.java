package com.mms.medmanagesystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.PessoaService;
import com.mms.medmanagesystem.service.ProfissionalService;

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

public class PerfilController {

  @Autowired ProfissionalService profissionalService;
  @Autowired PessoaService pessoaService;
  
  @Autowired ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/perfil")
  public ModelAndView perfil(Model model) throws NumberFormatException, ResourceNotFoundException {
    
    HttpSession session = httpSessionFactory.getObject();
    String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
    Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

    model.addAttribute("id", profissional.getId());
    model.addAttribute("pessoacc", profissional.getPessoa().getPessoacc());
    model.addAttribute("email", profissional.getPessoa().getEmail());
    model.addAttribute("area", profissional.getArea().getName()); 
    model.addAttribute("name", profissional.getPessoa().getName());
    model.addAttribute("telemovel", profissional.getPessoa().getTelemovel());
    model.addAttribute("morada", profissional.getPessoa().getMorada());
    model.addAttribute("datanascimento", profissional.getPessoa().getDatanascimento());

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("perfil");
    return modelAndView;
  }

  // update or delete ---------------------

  @RequestMapping("perfil/edit/{id}")
  public ModelAndView updateProfissional(Model model, @PathVariable(name = "id") int id)
      throws ResourceNotFoundException {

    ModelAndView modelEdit = new ModelAndView();

    Profissional pro = profissionalService.getProfissionalByID(id);

    Pessoa profissional = pro.getPessoa();
    System.out.println(profissional);
    model.addAttribute("profissional", profissional);

    modelEdit.setViewName("editperfil");

    return modelEdit;
  }

  @PostMapping(value = "/editperfil")
  public RedirectView savePerfil(@ModelAttribute("profissional") Pessoa profissional, HttpServletRequest request)
      throws NumberFormatException, ResourceNotFoundException {

    String button = request.getParameter("button");
    if ("Guardar".equals(button)) {
      pessoaService.updatePessoa(profissional);
    } 

    return new RedirectView("perfil");
  }


}