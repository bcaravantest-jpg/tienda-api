package com.umg.tienda.memory;

import com.umg.tienda.domain.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMemoryRepo  extends InMemoryBase<Categoria> {
	public Categoria save(Categoria c) {
	    if (c.getId() == null) c.setId(nextId());
	    data.put(c.getId(), c);
	    return c;
	  }
	}
