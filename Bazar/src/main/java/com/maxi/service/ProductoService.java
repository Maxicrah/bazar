package com.maxi.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.dao.IProductoDAO;
import com.maxi.model.Producto;

@Service
public class ProductoService implements IProductoService{

	
	@Autowired
	private IProductoDAO productDAO;
	
	@Override
	public void saveProduct(Producto product) {
		
		productDAO.save(product);
		
	}

	@Override
	public List<Producto> findProducts() {
		List<Producto> listaDeProductos = productDAO.findAll();
		
		return listaDeProductos;
	}

	@Override
	public Producto findProduct(Long id) {
	
		return productDAO.findById(id).orElse(null);
	}

	@Override
	public void deleteProduct(Long id) {
		this.productDAO.deleteById(id);
		
	}

	@Override
	public Producto editProduct(Long id, Producto productoModificado) {
		
		this.findProduct(id);
		
		Producto product = findProduct(id);
		
		if(product != null) {
			product.setNombre(productoModificado.getNombre());
			product.setMarca(productoModificado.getMarca());
			//product.setCodigo_producto(productoModificado.getCodigo_producto());
			product.setCosto(productoModificado.getCosto());
			product.setCantidad_disponible(productoModificado.getCantidad_disponible());
			//product.setVenta(productoModificado.getVenta());
		
			productDAO.save(product);
		}
		
		//productEdit.setNombre(product.getNombre());
		//productEdit.setMarca(product.getMarca());
		//productEdit.setCodigo_producto(product.getCodigo_producto());
		//productEdit.setCantidad_disponible(product.getCantidad_disponible());
		//productEdit.setCosto(product.getCosto());
		//productEdit.setVenta(product.getVenta());
			
			
		
		return product;
	}

	@Override
	public List<Producto> obtenerPocoStock() {
		List<Producto> listaProductos = this.findProducts();
		List<Producto> listaPocoStock = new LinkedList<>();
		
		for(Producto prod : listaProductos) {
			
			if(prod.getCantidad_disponible()<5) {
				listaPocoStock.add(prod);
			}
			
		}
		
		return listaPocoStock;
	}

}
