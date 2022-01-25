package com.mms.medmanagesystem.controller;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.ObjectFactory;


import com.mms.medmanagesystem.exception.*;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.ProfissionalService;

@RestController
public class ProfissionalController {

    @Autowired private ProfissionalService profissionalService;
    @Autowired ObjectFactory<HttpSession> httpSessionFactory;
    
    @GetMapping("/profissionais")
    public ModelAndView profissional(Model model, String keyword) throws NumberFormatException, ResourceNotFoundException {
  
        ModelAndView modelAndView = new ModelAndView();
    
        HttpSession session = httpSessionFactory.getObject();
        String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
        Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

        model.addAttribute("name", profissional.getPessoa().getName());

        List<Profissional> listaProfissionais = profissionalService.getProfissionais(); // todos os profissionais
        List<Profissional> listaFiltrada = profissionalService.findKeyword(keyword);

        if (keyword != null) {
          modelAndView.addObject("listaProfissionais", listaFiltrada);
        } else {
          modelAndView.addObject("listaProfissionais", listaProfissionais);
        }
    
        modelAndView.setViewName("tables/profissionais");

        return modelAndView;
    }

  
  

    //TODO FAZER ADD DE MEDICO profissionais/add
    

    @PostMapping("/profissional")
    public Profissional createProfissional(@Valid @RequestBody Profissional pro){
        return profissionalService.saveProfissional(pro);
    }

  
    @PutMapping("/profissional/{id}")
    public Profissional updateProfissional(@PathVariable("id") int id, @RequestBody Profissional pro) throws ResourceNotFoundException {
       return profissionalService.updateProfissional(id, pro);
    }

    
    @DeleteMapping("/profissional/{id}")
    public Map<String, Boolean> deleteProfissional(@PathVariable int id) throws ResourceNotFoundException {
        return profissionalService.deleteProfissional(id);
    }


}