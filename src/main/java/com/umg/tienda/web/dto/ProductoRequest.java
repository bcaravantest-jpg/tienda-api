package com.umg.tienda.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductoRequest {
	@NotBlank
	  private String nombre;

	  @NotNull @Min(0)
	  private Double precio;

	  @NotNull @Min(0)
	  private Integer stock;

	  @NotNull
	  private Long categoriaId;

	  // getters/setters
	  public String getNombre() { return nombre; }
	  public void setNombre(String nombre) { this.nombre = nombre; }
	  public Double getPrecio() { return precio; }
	  public void setPrecio(Double precio) { this.precio = precio; }
	  public Integer getStock() { return stock; }
	  public void setStock(Integer stock) { this.stock = stock; }
	  public Long getCategoriaId() { return categoriaId; }
	  public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
	}
