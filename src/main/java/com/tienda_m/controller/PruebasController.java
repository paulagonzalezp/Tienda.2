package com.tienda_m.controller;

import com.tienda_m.domain.Categoria;
import com.tienda_m.service.CategoriaService;
import com.tienda_m.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listadoIds(@PathVariable Long idCategoria, Model model) {
        Categoria categoria = categoriaService.getCategoria(idCategoria);
        var productos = categoria.getProductos();
        model.addAttribute("productos", productos);

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "pruebas/listado";
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        return "pruebas/listado2";
    }

    @PostMapping("/query1")
    public String consultaQuery1(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {

        var lista = productoService.metodoJPA(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";
    }
    @PostMapping("/query2")
    public String consultaQuery2(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {

        var lista = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";
    }
    @PostMapping("/query3")
    public String consultaQuery3(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {

        var lista = productoService.metodoSQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";
    }
}
