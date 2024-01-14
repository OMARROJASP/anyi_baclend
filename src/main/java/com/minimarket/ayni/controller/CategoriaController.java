package com.minimarket.ayni.controller;

import com.minimarket.ayni.model.entities.Categoria;
import com.minimarket.ayni.service.CategoriaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(originPatterns = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public List<Categoria> buscarCategorias(){
        return categoriaService.buscarCategoria();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCategoria(@PathVariable("id") Long id){
        Optional<Categoria> categoriaOptional = categoriaService.buscarCategoria(id);
         if (categoriaOptional.isPresent()){
             return ResponseEntity.ok(categoriaOptional.orElseThrow());
         }
         return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.guardarCategoria(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCategoria(@RequestBody Categoria categoria, @PathVariable("id") Long id){
        Optional<Categoria> categoriaOptional = categoriaService.actualizarCategoria(categoria,id);
        if (categoriaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.guardarCategoria(categoriaOptional.orElseThrow()));
        }
        return ResponseEntity.notFound().build();
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable("id") Long id){
        Optional<Categoria> categoriaOptional = categoriaService.buscarCategoria(id);
        if (categoriaOptional.isPresent()){
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
     }
}
