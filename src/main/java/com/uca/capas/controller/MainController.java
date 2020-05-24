package com.uca.capas.controller;


import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ContribuyenteService contribuyenteService;

    @Autowired
    private ImportanciaService importanciaService;

    @RequestMapping("/inicio")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        Contribuyente contribuyente = new Contribuyente();
        List<Importancia> importancias = null;
        mav.addObject("contribuyente", contribuyente);
        try{
            importancias = importanciaService.findAll();
            mav.addObject("importancia", importancias);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("/insertarContribuyente")
    public ModelAndView insert(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result){
        ModelAndView mav = new ModelAndView();
        List<Importancia> importancias = null;

        if(result.hasErrors()){
            importancias = importanciaService.findAll();
            mav.addObject("importancia", importancias);
            mav.setViewName("index");
        }else{
            contribuyente.setFechaIngreso(new Date());
            try{
                contribuyenteService.save(contribuyente);
                mav.setViewName("exito");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return mav;
    }

    @GetMapping("/listado")
    public ModelAndView lista(){
        ModelAndView mav = new ModelAndView();
        List<Contribuyente> contribuyentes = null;
        try{
            contribuyentes = contribuyenteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("contribuyente", contribuyentes);
        mav.setViewName("listado");
        return mav;
    }
}
