package com.maxi.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo_venta;
	private LocalDate fecha_venta;
	private Double total;
	//@JsonManagedReference
	@JsonIgnore
	@ManyToMany
	@JoinTable(
	        name = "venta_producto",
	        joinColumns = @JoinColumn(name = "venta_id"),
	        inverseJoinColumns = @JoinColumn(name = "producto_id")
	    )
	//@JoinColumn(name="codigo_producto")
	private List<Producto> listaProductos;
	@OneToOne
	@JoinColumn(name="id_cliente")
	private Cliente unCliente;
}
