package com.umg.tienda.service;

import com.umg.tienda.domain.Categoria;
import com.umg.tienda.domain.Producto;
import com.umg.tienda.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
	private final ProductoRepository repo;
	  private final CategoriaService categoriaService;

	  public ProductoService(ProductoRepository repo, CategoriaService categoriaService) {
	    this.repo = repo;
	    this.categoriaService = categoriaService;
	  }

	  public List<Producto> listar() { return repo.findAll(); }

	  public Producto buscar(Long id) {
	    return repo.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado: " + id));
	  }

	  public Producto crear(Producto p, Long categoriaId) {
	    Categoria cat = categoriaService.buscar(categoriaId);
	    p.setCategoria(cat);
	    return repo.save(p);
	  }

	  public Producto actualizar(Long id, Producto p, Long categoriaId) {
	    Producto db = buscar(id);
	    Categoria cat = categoriaService.buscar(categoriaId);
	    db.setNombre(p.getNombre());
	    db.setPrecio(p.getPrecio());
	    db.setStock(p.getStock());
	    db.setCategoria(cat);
	    return repo.save(db);
	  }

	  public void eliminar(Long id) { repo.deleteById(id); }
	}
