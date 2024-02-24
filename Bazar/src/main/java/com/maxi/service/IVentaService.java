package com.maxi.service;

import java.time.LocalDate;
import java.util.List;

import com.maxi.dto.VentaDTO;
import com.maxi.model.Producto;
import com.maxi.model.Venta;

public interface IVentaService {

	//ALTA VENTA
	public Venta saveVenta(Venta venta);
	
	//TRAER VENTAS
	public List<Venta> findVentas();
		
	//TRAER UNA VENTA EN PARTICULAR
	public Venta findVenta(Long id);
		
	//ELIMINAR VENTA
	public void deleteVenta(Long id);
		
	//EDITAR VENTA
	public Venta editVenta(Long id,Venta ventaModificado);
	
	//Obtener la lista de productos de una determinada venta
	public List<Producto> ventaProducts(Long codigo_venta);
	
	//Obtener la sumatoria del monto y tambien la cantidad total de ventas de un determinado dia
	public void totalVentas(LocalDate fecha_venta);
	
	//Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas. 
	public VentaDTO obtenerVentaMasAlta();
		
}
