package com.umg.tienda.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotBlank
	  @Column(nullable = false)
	  private String nombre;

	  @NotNull @Min(0)
	  private Double precio;

	  @NotNull @Min(0)
	  private Integer stock;

	  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	  @JoinColumn(name = "categoria_id", nullable = false)
	  private Categoria categoria;

	  // getters/setters
	  public Long getId() { return id; }
	  public void setId(Long id) { this.id = id; }
	  public String getNombre() { return nombre; }
	  public void setNombre(String nombre) { this.nombre = nombre; }
	  public Double getPrecio() { return precio; }
	  public void setPrecio(Double precio) { this.precio = precio; }
	  public Integer getStock() { return stock; }
	  public void setStock(Integer stock) { this.stock = stock; }
	  public Categoria getCategoria() { return categoria; }
	  public void setCategoria(Categoria categoria) { this.categoria = categoria; }
	}

