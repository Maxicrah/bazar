package com.maxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.model.Cliente;
import com.maxi.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	
	@Autowired
	private ClienteService cliServ;
	
	
	@PostMapping("crear")
	public String saveCliente(@RequestBody Cliente cli) {
		
		cliServ.saveCliente(cli);
		return "Cliente creado exitosamente";
		
	}
	
	@GetMapping
	@ResponseBody
	public List<Cliente> findClientes(){
		
		return cliServ.findClientes();
	}
	
	@GetMapping("{id_cliente}")
	public Cliente findCliente(@PathVariable Long id_cliente) {
		
		return cliServ.findCliente(id_cliente);
		
	}
	
	@DeleteMapping("eliminar/{id_cliente}")
	public String deleteCliente(@PathVariable Long id_cliente) {
		
		cliServ.deleteCliente(id_cliente);
		return "Cliente eliminado correctamente";
	}
	
	@PutMapping("editar/{id_cliente}")
	public Cliente editCliente(@PathVariable Long id_cliente, @RequestBody Cliente cli) {
	
		return cliServ.editCliente(id_cliente, cli);
	}
	
}
