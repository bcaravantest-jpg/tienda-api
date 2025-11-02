package com.umg.tienda.web;

import com.umg.tienda.domain.Cliente;
import com.umg.tienda.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	private final ClienteService service;

	  public ClienteController(ClienteService service) { this.service = service; }

	  @GetMapping
	  public ResponseEntity<List<Cliente>> getAll() {
	    return ResponseEntity.ok(service.listar());
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<Cliente> getOne(@PathVariable Long id) {
	    return ResponseEntity.ok(service.buscar(id));
	  }

	  @PostMapping
	  public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente c) {
	    Cliente saved = service.crear(c);
	    return ResponseEntity.created(URI.create("/api/clientes/" + saved.getId())).body(saved);
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente c) {
	    return ResponseEntity.ok(service.actualizar(id, c));
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<Void> delete(@PathVariable Long id) {
	    service.eliminar(id);
	    return ResponseEntity.noContent().build();
	  }
	}