package com.maxi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.dto.VentaDTO;
import com.maxi.model.Producto;
import com.maxi.model.Venta;
import com.maxi.service.VentaService;

@RestController
@RequestMapping("ventas")
public class VentaController {

	@Autowired
	private VentaService ventaServ;
	
	@PostMapping("crear")
	public String saveVenta(@RequestBody Venta venta) {
		
		ventaServ.saveVenta(venta);
		return "Venta creada";
	}
	
	@GetMapping
	@ResponseBody
	public List<Venta> listaVentas(){
		
		return ventaServ.findVentas();
	}
	
	@GetMapping("{codigo_venta}")
	@ResponseBody
	public Venta findVenta(@PathVariable Long codigo_venta) {
		return ventaServ.findVenta(codigo_venta);
	}
	
	@DeleteMapping("eliminar/{codigo_venta}")
	public String deleteVenta(@PathVariable Long codigo_venta) {
		
		ventaServ.deleteVenta(codigo_venta);
		return "Venta eliminada";
	}
	
	@PutMapping("editar/{codigo_venta}")
	public void editVenta(@PathVariable Long codigo_venta, Venta ventaModificada) {
		
		ventaServ.editVenta(codigo_venta, ventaModificada);
	}
	
	@GetMapping("productos/{codigo_venta}")
	@ResponseBody
	public List<Producto> productosVenta(@PathVariable Long codigo_venta) {
		
		
		return ventaServ.ventaProducts(codigo_venta);
	
	}
	
	@GetMapping("total/{fecha_venta}")
	@ResponseBody
	public void totalVentas(@PathVariable LocalDate fecha_venta) {
		
		ventaServ.totalVentas(fecha_venta);
	}
	
	@GetMapping("mayor_venta")
	public ResponseEntity<VentaDTO> ventaMasAlta() {
		VentaDTO ventaMasAlta = ventaServ.obtenerVentaMasAlta();
		return ResponseEntity.ok(ventaMasAlta);
		
	}
	
	
}
