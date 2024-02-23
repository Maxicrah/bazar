package com.maxi.service;

import java.util.List;

import com.maxi.model.Cliente;

public interface IClienteService {

	
	//ALTA CLIENTE
	public void saveCliente(Cliente cli);
	
	//LISTA CLIENTES
	public List<Cliente> findClientes();
	
	//TRAER UN CLIENTE EN PARTICULAR
	public Cliente findCliente(Long id);
	
	//ELIMINAR CLIENTE
	public void deleteCliente(Long id);
	
	//EDITAR CLIENTE
	public Cliente editCliente(Long id_cliente, Cliente clienteModificado);
}
