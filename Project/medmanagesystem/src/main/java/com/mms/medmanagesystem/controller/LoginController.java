package com.mms.medmanagesystem.controller;

import javax.servlet.http.HttpSession;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.LoginCredentials;
import com.mms.medmanagesystem.model.Medico;
import com.mms.medmanagesystem.service.MedicoService;

import org.springframework.beans.factory.ObjectFactory; // is this it?
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

  @Autowired
  private MedicoService medicoService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("loginCredentials")
  public LoginCredentials loginCredentialsAttribute() {
    return new LoginCredentials();
  }

  @GetMapping("/") 
  @ResponseBody
  public ModelAndView login(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
  }

  @PostMapping("/")
  public ModelAndView loginChecking(@ModelAttribute LoginCredentials loginCredentials, Model model) throws NumberFormatException, ResourceNotFoundException {
    HttpSession session = httpSessionFactory.getObject();
    String medicoid = loginCredentials.getMedicoid();
    String password = loginCredentials.getPassword();
    ModelAndView modelAndView = new ModelAndView();
    
    Medico medico = medicoService.getMedicoByIDMedico(Integer.parseInt(medicoid));
    
    if (medico.getPassword().equals(password)) {
      session.setAttribute("id_medico", medicoid);
      session.setAttribute("pessoa_cc", medico.getMedico().getCC());
      model.addAttribute("id", medico.getId());
      model.addAttribute("area", medico.getArea().getName());
      model.addAttribute("nome", medico.getMedico().getNome());
      model.addAttribute("telemovel", medico.getMedico().getTelemovel());
      model.addAttribute("morada", medico.getMedico().getMorada());
      model.addAttribute("datanascimento", medico.getMedico().getDataNascimento());
      modelAndView.setViewName("index");
      return modelAndView;
    }
    else {
      model.addAttribute("error", "Dados de sessão inválidos!"); // Isto é suposto ser uma MsgBox
      modelAndView.setViewName("login");
      return modelAndView;    
    }
  }
}