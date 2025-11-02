package com.umg.tienda.service;

import com.umg.tienda.domain.Cliente;
import com.umg.tienda.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
	private final ClienteRepository repo;

	  public ClienteService(ClienteRepository repo) { this.repo = repo; }

	  public List<Cliente> listar() { return repo.findAll(); }

	  public Cliente buscar(Long id) {
	    return repo.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado: " + id));
	  }

	  public Cliente crear(Cliente c) { return repo.save(c); }

	  public Cliente actualizar(Long id, Cliente c) {
	    Cliente db = buscar(id);
	    db.setNombre(c.getNombre());
	    db.setEmail(c.getEmail());
	    db.setTelefono(c.getTelefono());
	    return repo.save(db);
	  }

	  public void eliminar(Long id) { repo.deleteById(id); }
	}
