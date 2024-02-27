package com.tienda_m.controller;

import com.tienda_m.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
   
    @Autowired
    private CategoriaService categoriaService;
    
    // "/categoria/listado"
    @GetMapping("/listado")
    public String listado(Model model){
        var lista=categoriaService.getCategorias(false);
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias",lista.size());
        return "/categoria/listado";
    }
}
