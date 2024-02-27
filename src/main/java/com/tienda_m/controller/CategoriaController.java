package com.tienda_m.controller;

import com.tienda_m.domain.Categoria;
import com.tienda_m.service.CategoriaService;
import com.tienda_m.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // "/categoria/listado"
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = categoriaService.getCategorias(false);
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias", lista.size());
        return "categoria/listado"; // Corregido
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;

    @PostMapping("/guardar")
    public String guardar(Categoria categoria,
                          @RequestParam("imagenFile") MultipartFile imagenFile) {
        // Aquí va la lógica para guardar la categoría y la imagen
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            String rutaImagen = 
                    firebaseStorageServiceImpl
                            .cargaImagen(imagenFile, 
                                    "categoria", 
                                    categoria.getIdCategoria());
            categoria.setRutaImagen(rutaImagen); // Corregido
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String modifica(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria); // El método correcto es addAttribute en lugar de addAllAttribute
        return "/categoria/modifica"; }// La ruta de retorno es correcta
}

