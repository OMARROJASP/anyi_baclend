package com.minimarket.ayni.service;

import com.minimarket.ayni.model.entities.Categoria;
import com.minimarket.ayni.repositories.CategoriaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepositories categoriaRepositories;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> buscarCategoria() {
        return (List<Categoria>) categoriaRepositories.findAll();
    }

    @Override
    public Optional<Categoria> buscarCategoria(Long id) {
        return categoriaRepositories.findById(id);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepositories.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepositories.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Categoria> actualizarCategoria(Categoria categoria, Long id) {
        Optional<Categoria> optional = this.buscarCategoria(id);
        Categoria categoriaOptional = null;
        if(optional.isPresent()){
            Categoria categoriaDB = optional.orElseThrow();
            categoriaDB.setTitulo(categoria.getTitulo());
            categoriaDB.setDescripcion(categoria.getDescripcion());
            categoriaOptional = this.guardarCategoria(categoriaDB);

        }
        return Optional.ofNullable(categoriaOptional);
    }
}
