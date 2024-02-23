package com.maxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.model.Producto;
import com.maxi.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productServ;
	
	@PostMapping("productos/crear")
	public String saveProduct(@RequestBody Producto product) {
		
		productServ.saveProduct(product);
		return "Producto creado";
		
	}
	
	@GetMapping("productos")
	@ResponseBody
	public List<Producto> findProducts(){
		
		return productServ.findProducts();
	}
	
	@GetMapping("productos/{codigo_producto}")
	@ResponseBody
	public Producto findProduct(@PathVariable Long codigo_producto) {
		
		return productServ.findProduct(codigo_producto);
		
	}
	
	@DeleteMapping("productos/eliminar/{codigo_producto}")
	public String deleteProduct(@PathVariable Long codigo_producto) {
		
		productServ.deleteProduct(codigo_producto);
		return "Producto Eliminado correctamente";
		
	}
	
	@PutMapping("productos/editar/{codigo_producto}")
	public Producto editProduct(@PathVariable Long codigo_producto, @RequestBody Producto product){
		
		return productServ.editProduct(codigo_producto, product);
		
	}
	
	@GetMapping("productos/falta_stock")
	@ResponseBody
	public List<Producto> obtenerPocoStock(){
		
		return productServ.obtenerPocoStock();
	}
	
	
}
