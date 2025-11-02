package com.umg.tienda.service;

import com.umg.tienda.domain.Categoria;
import com.umg.tienda.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
	private final CategoriaRepository repo;

	  public CategoriaService(CategoriaRepository repo) { this.repo = repo; }

	  public List<Categoria> listar() { return repo.findAll(); }

	  public Categoria buscar(Long id) {
	    return repo.findById(id).orElseThrow(() -> new NotFoundException("Categoria no encontrada: " + id));
	  }

	  public Categoria crear(Categoria c) { return repo.save(c); }

	  public Categoria actualizar(Long id, Categoria c) {
	    Categoria db = buscar(id);
	    db.setNombre(c.getNombre());
	    db.setDescripcion(c.getDescripcion());
	    return repo.save(db);
	  }

	  public void eliminar(Long id) { repo.deleteById(id); }
	}
