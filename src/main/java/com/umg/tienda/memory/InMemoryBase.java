package com.umg.tienda.memory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryBase<T> {
	
	protected final Map<Long, T> data = new ConcurrentHashMap<>();
	  protected final AtomicLong seq = new AtomicLong(0);

	  protected Long nextId() { return seq.incrementAndGet(); }

	  public List<T> findAll() { return new ArrayList<>(data.values()); }
	  public Optional<T> findById(Long id) { return Optional.ofNullable(data.get(id)); }
	  public void deleteById(Long id) { data.remove(id); }
	  public void clear() { data.clear(); }
	}
