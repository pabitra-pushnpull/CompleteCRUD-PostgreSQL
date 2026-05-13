package com.connection.service;


import java.util.List;
import com.connection.repository.ClientRepository;
import com.connection.responseWrapper.ClientResponseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.connection.model.ClientModel;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

	
	public ResponseEntity<?> getAllClientsService() throws Exception{
		List<ClientModel> allClients = clientRepository.findAll();
		
		ClientResponseWrapper rw = new ClientResponseWrapper();
		rw.setData(allClients);
		rw.setMessage("All Data of Clients.");

		
		return new ResponseEntity<>(rw, HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<?> getClientById(Long requestedClientId) throws Exception{
		
		ClientModel foundedClient = clientRepository.findById(requestedClientId)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found !"));
		
		ClientResponseWrapper rw = new ClientResponseWrapper();
		rw.setData(foundedClient);
		rw.setMessage("Client Found.");
		
		return new ResponseEntity<>(rw, HttpStatus.FOUND);
	}
	
	public ResponseEntity<?> createClient(ClientModel client) throws Exception{

		clientRepository.save(client);
		
		ClientResponseWrapper rw = new ClientResponseWrapper();
		rw.setMessage("Client created !");
		
		return new ResponseEntity<>(rw, HttpStatus.OK);
	}
	
	public ResponseEntity<?> updateClient(Long inputClientId ,ClientModel updatedClient) throws Exception{
		
		ClientModel foundedClient = clientRepository.findById(inputClientId).get();
		foundedClient.setClient_name(updatedClient.getClient_name());
		foundedClient.setLocation(updatedClient.getLocation());
		foundedClient.setMobile(updatedClient.getMobile());
		
		ClientResponseWrapper rw = new ClientResponseWrapper();
		rw.setData(foundedClient);
		rw.setMessage("Client updated !");
		
		return new ResponseEntity<>(rw, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<?> deleteClient(Long clientId) throws Exception{
		
		clientRepository.findById(clientId)
			.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found !"));
		clientRepository.deleteById(clientId);
		
		ClientResponseWrapper rw = new ClientResponseWrapper();
		rw.setMessage("Client Deleted !");
		
		return new ResponseEntity<>(rw, HttpStatus.OK);
		
	}
	
}
