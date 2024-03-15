package com.backend.rinhajava.service;

import com.backend.rinhajava.model.ClienteModel;
import com.backend.rinhajava.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Log4j2
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Optional<ClienteModel> validaCliente (int idCliente) {
        return Optional.ofNullable((ClienteModel) clienteRepository.findByidCliente(idCliente));
    }

    public ResponseEntity<ClienteModel> criarCliente(ClienteModel clienteModel){
        if(validaCliente(clienteModel.getIdCliente()).isPresent()){
            log.warn("Cliente já cadastrado, id: " + clienteModel.getId());
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        } else {
            ClienteModel _clientModel = clienteRepository.save(
                    new ClienteModel(
                            clienteModel.getIdCliente(),
                            clienteModel.getLimite(),
                            clienteModel.getSaldoInicial(),
                            null
                    )

            );
            log.debug(clienteModel.getId() +
                clienteModel.getLimite() +
                clienteModel.getSaldoInicial());
            log.info("Cliente "+ clienteModel.getId() +" cadastrado com sucesso");
            return new ResponseEntity<>(_clientModel, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<List<ClienteModel>> listarClientes() {
        List<ClienteModel> clientes = new ArrayList<>(clienteRepository.findAll());
        if (clientes.isEmpty()) {
            log.warn("nenhum cliente cadastrado");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("retornando todos os clientes");
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }
    }

    public ResponseEntity<ClienteModel> buscarCliente(int id) {
        Optional<ClienteModel> clienteData = validaCliente(id);
        if(clienteData.isPresent()){
            log.info("Cliente id: " + clienteData.get().getId() + "encontrado");
            return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
        } else {
            log.warn("Cliente não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
