package com.connection.controller;

import com.connection.model.ClientModel;
import com.connection.service.ClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
	
    @GetMapping("/all")
	public ResponseEntity<?> getAllClients() throws Exception {
		return clientService.getAllClientsService();
	}
	
    @GetMapping("/byId/{cid}")
	public ResponseEntity<?> getclientsByIdController(@PathVariable Long cid) throws Exception {
		return clientService.getClientById(cid);
	}

    @PostMapping("/create")
    public ResponseEntity<?> createClientsController(@RequestBody ClientModel clientModel) throws Exception {
    	return clientService.createClient(clientModel);
	}
    
    @PutMapping("/update/{cid}")
    public ResponseEntity<?> updateClientsController(@PathVariable Long cid, 
    		@RequestBody ClientModel clientModel) throws Exception {
		
    	return clientService.updateClient(cid, clientModel);
	}
    
    @DeleteMapping("/delete/{cid}")
    public ResponseEntity<?> deleteClientController(@PathVariable Long cid) throws Exception {
    	return clientService.deleteClient(cid);
	}
    
}
