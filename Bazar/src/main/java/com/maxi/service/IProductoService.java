package com.maxi.service;

import java.util.List;

import com.maxi.model.Producto;

public interface IProductoService {

	//alta de producto
	public void saveProduct(Producto product);
	
	//traer todos los productos
	public List<Producto> findProducts();
	
	//traer un producto en particular
	public Producto findProduct(Long id);
	
	//eliminar un producto
	public void deleteProduct(Long id);
	
	//editar producto
	public Producto editProduct(Long id,Producto productoModificado);
	
	//obtener los productos cuya cantidad disp sea menor a 5
	public List<Producto> obtenerPocoStock();
}
