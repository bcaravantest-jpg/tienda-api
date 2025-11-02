package com.umg.tienda.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "productos")
public class Producto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nombre;

    @NotNull @Min(0)
    private Double precio;

    @NotNull @Min(0)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonIgnoreProperties({"productos"}) // evita que serialize la colección de vuelta
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

