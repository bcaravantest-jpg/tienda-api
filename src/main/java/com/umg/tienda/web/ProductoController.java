package com.umg.tienda.web;

import com.umg.tienda.domain.Producto;
import com.umg.tienda.service.ProductoService;
import com.umg.tienda.web.dto.ProductoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	private final ProductoService service;

	  public ProductoController(ProductoService service) { this.service = service; }

	  @GetMapping
	  public ResponseEntity<List<Producto>> getAll() {
	    return ResponseEntity.ok(service.listar());
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<Producto> getOne(@PathVariable Long id) {
	    return ResponseEntity.ok(service.buscar(id));
	  }

	  @PostMapping
	  public ResponseEntity<Producto> create(@Valid @RequestBody ProductoRequest req) {
	    Producto p = new Producto();
	    p.setNombre(req.getNombre());
	    p.setPrecio(req.getPrecio());
	    p.setStock(req.getStock());
	    Producto saved = service.crear(p, req.getCategoriaId());
	    return ResponseEntity.created(URI.create("/api/productos/" + saved.getId())).body(saved);
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<Producto> update(@PathVariable Long id, @Valid @RequestBody ProductoRequest req) {
	    Producto p = new Producto();
	    p.setNombre(req.getNombre());
	    p.setPrecio(req.getPrecio());
	    p.setStock(req.getStock());
	    return ResponseEntity.ok(service.actualizar(id, p, req.getCategoriaId()));
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<Void> delete(@PathVariable Long id) {
	    service.eliminar(id);
	    return ResponseEntity.noContent().build();
	  }
	}
