package com.umg.tienda.memory;

import com.umg.tienda.domain.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMemoryRepo extends InMemoryBase<Producto> {
	public Producto save(Producto p) {
	    if (p.getId() == null) p.setId(nextId());
	    data.put(p.getId(), p);
	    return p;
	  }
	}
