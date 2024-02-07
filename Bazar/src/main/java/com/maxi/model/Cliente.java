package com.maxi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cliente {

	private Long id_cliente;
	private String nombre;
	private String apellido;
	private String dni;
}
