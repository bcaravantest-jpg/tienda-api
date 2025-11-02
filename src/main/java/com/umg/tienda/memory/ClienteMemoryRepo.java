package com.umg.tienda.memory;

import com.umg.tienda.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMemoryRepo extends InMemoryBase<Cliente> {
	 public Cliente save(Cliente c) {
		    if (c.getId() == null) c.setId(nextId());
		    data.put(c.getId(), c);
		    return c;
		  }
		}
