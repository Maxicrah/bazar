package com.maxi.dto;

import java.util.List;

import com.maxi.model.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VentaDTO {

	private Long codigo_venta;
	private Double total;
	private int cantidad_productos;
	private String apellidoCliente;
	private String nombreCliente;
	
}
