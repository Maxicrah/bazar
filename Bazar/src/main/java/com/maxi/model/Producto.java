package com.maxi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo_producto;
	private String nombre;
	private String marca;
	private Double costo;
	private Double cantidad_disponible;
	//@JoinColumn(name="codigo_venta")
	@JsonIgnore
    //@JsonBackReference // Evita la recursión infinita al serializar
	@ManyToMany(mappedBy = "listaProductos")
	private List<Venta> ventas;
	
}
