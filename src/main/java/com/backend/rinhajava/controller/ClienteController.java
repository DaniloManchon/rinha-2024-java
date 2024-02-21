package com.backend.rinhajava.controller;

import com.backend.rinhajava.model.ClienteModel;
import com.backend.rinhajava.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/new")
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){
        try{
            return clienteService.criarCliente(clienteModel);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<ClienteModel>> listarClientes(){
        try{
            return clienteService.listarClientes();
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarCliente(@RequestParam int id){
        try{
            return clienteService.buscarCliente(id);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
