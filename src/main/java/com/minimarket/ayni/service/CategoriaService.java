package com.minimarket.ayni.service;

import com.minimarket.ayni.model.entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService  {


    List<Categoria> buscarCategoria();

    Optional<Categoria> buscarCategoria(Long id);

    Categoria guardarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);

    Optional<Categoria> actualizarCategoria(Categoria categoria,Long id);

}
