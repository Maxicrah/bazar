package com.maxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.dao.IClienteDAO;
import com.maxi.model.Cliente;

//import ch.qos.logback.core.net.server.Client;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteDAO clienteDAO;
	
	
	@Override
	public void saveCliente(Cliente cli) {
		
		clienteDAO.save(cli);
	}


	@Override
	public List<Cliente> findClientes() {
		
		List<Cliente> listaClientes = clienteDAO.findAll();
		
		return listaClientes;
	}


	@Override
	public Cliente findCliente(Long id) {
		
		return clienteDAO.findById(id).orElse(null);
		
	}


	@Override
	public void deleteCliente(Long id) {
		clienteDAO.deleteById(id);
		
	}


	@Override
	public Cliente editCliente(Long id_cliente, Cliente clienteModificado) {
		
		Cliente cliente = this.findCliente(id_cliente);
		
		cliente.setNombre(clienteModificado.getNombre());
		cliente.setApellido(clienteModificado.getApellido());
		cliente.setDni(clienteModificado.getDni());
		cliente.setVenta(clienteModificado.getVenta());
		
		this.saveCliente(cliente);
		
		return cliente;
	}
	

}
