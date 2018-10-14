package com.umg.programacion2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.repository.ClienteRepostory;
import com.umg.programacion2.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired ClienteRepostory clienteRepository;
	private static Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	@Override
	public List<Cliente> getAllClient() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes = clienteRepository.findAll();			
			
		}catch(Exception e) {
			logger.info("ERRO getAllClient "+e);
		}
		
		
		return clientes;
	}

}
