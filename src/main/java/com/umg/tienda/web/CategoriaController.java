package com.umg.tienda.web;

import com.umg.tienda.domain.Categoria;
import com.umg.tienda.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	private final CategoriaService service;

	  public CategoriaController(CategoriaService service) { this.service = service; }

	  @GetMapping
	  public ResponseEntity<List<Categoria>> getAll() {
	    return ResponseEntity.ok(service.listar());
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<Categoria> getOne(@PathVariable Long id) {
	    return ResponseEntity.ok(service.buscar(id));
	  }

	  @PostMapping
	  public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria c) {
	    Categoria saved = service.crear(c);
	    return ResponseEntity.created(URI.create("/api/categorias/" + saved.getId())).body(saved);
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<Categoria> update(@PathVariable Long id, @Valid @RequestBody Categoria c) {
	    return ResponseEntity.ok(service.actualizar(id, c));
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<Void> delete(@PathVariable Long id) {
	    service.eliminar(id);
	    return ResponseEntity.noContent().build();
	  }
	}