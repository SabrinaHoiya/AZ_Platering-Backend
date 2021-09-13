package com.example.AZplastering.controller;

import com.example.AZplastering.dto.ChantierRepository;
import com.example.AZplastering.model.Chantier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class GetViewController {
    @Autowired
    private ChantierRepository productRepo;

    @RequestMapping(value = "/addChantier",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnAddChantier()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addChantier");
        //mv.addObject("var", "halim");
        return mv;

    }

    @RequestMapping(value = "/listChantier",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnListProduct()
    {
        ModelAndView mv = new ModelAndView();
        List<Chantier> chantiers = productRepo.findAll();
        mv.setViewName("listChantier");
        mv.addObject("chantiers", chantiers);
        return mv;

    }
}
