package com.maxi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Producto {

	private Long codigo_producto;
	private String nombre;
	private String marca;
	private Double costo;
	private Double cantidad_disponible;
}
