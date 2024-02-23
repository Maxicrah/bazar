package com.maxi.service;

import java.time.LocalDate;
//import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.dao.IVentaDAO;
import com.maxi.model.Producto;
import com.maxi.model.Venta;

@Service
public class VentaService implements IVentaService{

	
	@Autowired
	private IVentaDAO ventaDAO;
	//private ProductoService prodServ;
	
	@Override
	public Venta saveVenta(Venta venta) {
		
	Venta vent =ventaDAO.save(venta);
	
	return vent;	
	
	}

	@Override
	public List<Venta> findVentas() {
		
		List<Venta> listaVentas = ventaDAO.findAll();
		return listaVentas;
	}

	@Override
	public Venta findVenta(Long id) {
		
		Venta venta = ventaDAO.findById(id).orElse(null);
		
		return venta;
	}

	@Override
	public void deleteVenta(Long id) {
		ventaDAO.deleteById(id);
	}

	@Override
	public Venta editVenta(Long id, Venta ventaModificado) {
		
		Venta venta = findVenta(id);
		venta.setFecha_venta(ventaModificado.getFecha_venta());
		venta.setListaProductos(ventaModificado.getListaProductos());
		venta.setTotal(ventaModificado.getTotal());
		venta.setUnCliente(ventaModificado.getUnCliente());
		
		this.saveVenta(venta);
		
		
		return venta;
	}

	@Override
	public List<Producto> ventaProducts(Long codigo_venta) {

		Venta vent = this.findVenta(codigo_venta);
	
		//List<Producto> listaProductos =  prodServ.findProducts();
		
		//List<Producto> listaNueva = new LinkedList<>();		
		
		return vent.getListaProductos();
	}

	@Override
	public void totalVentas(LocalDate fecha_venta) {
		
		List<Venta> listaDeVentas = this.findVentas();
		
		Long numeroDeVentas = 0L;
		Double totalDeVentas = 0.0;
		for(Venta ven : listaDeVentas) {
			if(ven.getFecha_venta().equals(fecha_venta)) {
				totalDeVentas+=ven.getTotal();
				numeroDeVentas++;
			}
		//Double monto = ven.getTotal() + ven.getTotal();
		//totalDeVentas = ven.getCodigo_venta() + ven.getCodigo_venta(); 	
		
		}
		 System.out.println("Número de ventas para la fecha " + fecha_venta + ": " + numeroDeVentas);
		 System.out.println("Total de ventas para la fecha " + fecha_venta + ": " + totalDeVentas);
	}

}
