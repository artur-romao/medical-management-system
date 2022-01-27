package com.mms.medmanagesystem.controller;
import java.util.*;


import javax.validation.Valid;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.beans.factory.ObjectFactory;


import com.mms.medmanagesystem.exception.*;
import com.mms.medmanagesystem.model.Area;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.AreaService;
import com.mms.medmanagesystem.service.PessoaService;
import com.mms.medmanagesystem.service.ProfissionalService;

@RestController
public class ProfissionalController {

    @Autowired private ProfissionalService profissionalService;
    @Autowired private PessoaService pessoaService;
    @Autowired private AreaService areaService;

    @Autowired ObjectFactory<HttpSession> httpSessionFactory;


     @GetMapping("/profissionais/list")
    public List<Profissional> getAllProfissionais() {
        return profissionalService.getProfissionais();
    }

    @GetMapping("/profissionais")
    public ModelAndView profissional(Model model, String keyword) throws NumberFormatException, ResourceNotFoundException {
  
        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = httpSessionFactory.getObject();
        String profissionalid = (String.valueOf(session.getAttribute("id_profissional")));
        Profissional profissional = profissionalService.getProfissionalByID(Integer.parseInt(profissionalid));

        boolean admin = false;
        if (profissional.getPro().equals("Admin")) { admin = true; }
        model.addAttribute("admin", admin);

        boolean medic = false;
        if (profissional.getPro().equals("Medico")) { medic = true; }
        model.addAttribute("medic", medic);


        model.addAttribute("name", profissional.getPessoa().getName());
    
        List<Profissional> listaProfissionais = profissionalService.getProfissionais(); // todos os pacientes
        
        List<Profissional> finalProfissionais = new ArrayList<Profissional>();
        for (Profissional pro:listaProfissionais){
            if (pro.getPessoa().getPessoacc() != 0){
                finalProfissionais.add(pro);
            }

        }
        List<Profissional> listaFiltrada = profissionalService.findKeyword(keyword);
    
        if (keyword != null) {
            modelAndView.addObject("listaProfissionais", listaFiltrada);
        } else {
            modelAndView.addObject("listaProfissionais", finalProfissionais);
        }
    
        modelAndView.setViewName("tables/profissionais");
        return modelAndView;
    }

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

    @GetMapping("/profissional/{id}")
    public Profissional getProfissionalByID(@PathVariable int id) throws ResourceNotFoundException {
        return profissionalService.getProfissionalByID(id);
    }

    // add ---------------------

    @GetMapping("profissionais/add")
    public ModelAndView addProfissionalForm(Model model) throws NumberFormatException, ResourceNotFoundException {

        ModelAndView modelAndView = new ModelAndView();

        Pessoa pessoa = new Pessoa();

        Profissional profissional = new Profissional(pessoa);
        model.addAttribute("profissional", profissional);


        List<Area> finalAreas = new ArrayList<Area>();
        List<Area> listaAreas = areaService.getAreas();
        for (Area area:listaAreas){
            if (area.getId() != 18){
                finalAreas.add(area);
            }
        }

        model.addAttribute("listaAreas", finalAreas);

        modelAndView.setViewName("addprofissional");

        return modelAndView;
    }

    @PostMapping(value = "/saveprofissional")
    public RedirectView saveNewProfissional(@ModelAttribute("profissional") Profissional profissional,  HttpServletRequest request) throws NumberFormatException, ResourceNotFoundException {
       
        profissional.setId(profissionalService.getProfissionais().size()+1);


        String areaId = request.getParameter("area");
        String pro = request.getParameter("pro");

        Area chosenArea = areaService.getAreaByID(Integer.parseInt(areaId));
        profissional.setArea(chosenArea);
        profissional.setPro(pro);
    

        profissionalService.saveProfissional(profissional);

        return new RedirectView("profissionais");
    }

      // update or delete ---------------------

    @RequestMapping("profissionais/edit/{id}")
    public ModelAndView updateProfissionalAdmin(Model model, @PathVariable(name = "id") int id)
    throws ResourceNotFoundException {

        ModelAndView modelEdit = new ModelAndView();

        Profissional profissional = profissionalService.getProfissionalByID(id);
        model.addAttribute("profissional", profissional);

        List<Area> listaAreas = areaService.getAreas();
        List<Area> finalAreas = new ArrayList<Area>();
        for (Area area:listaAreas){
            if (area.getId() != 18){
                finalAreas.add(area);
            }
        }
        model.addAttribute("listaAreas", finalAreas);

        modelEdit.setViewName("editprofissional");

        return modelEdit;
    }

    @PostMapping(value = "/editprofissional")
    public RedirectView saveProfissionalAdmin(@ModelAttribute("profissional") Profissional profissional, HttpServletRequest request)
        throws NumberFormatException, ResourceNotFoundException {

        int id = profissional.getId();

        String button = request.getParameter("button");

        if ("Guardar".equals(button)) {
            pessoaService.updatePessoa(profissional.getPessoa());
            profissionalService.updateProfissional(id, profissional);
        } else if ("Eliminar Profissional".equals(button)) {
            pessoaService.deletePessoa(profissional.getPessoa());
        }

        return new RedirectView("profissionais");
    }


}