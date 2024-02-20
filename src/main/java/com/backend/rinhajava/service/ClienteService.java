package com.backend.rinhajava.service;

import com.backend.rinhajava.model.ClienteModel;
import com.backend.rinhajava.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Log4j2
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Optional<ClienteModel> validaCliente (int id) {
        return Optional.ofNullable((ClienteModel) clienteRepository.findById(id));
    }

    public ResponseEntity<ClienteModel> criarCliente(int id, double limite, double saldoInicial){
        if(validaCliente(id).isPresent()){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        } else {
            ClienteModel _clientModel = clienteRepository.save(new ClienteModel(id, limite, saldoInicial));
            return new ResponseEntity<>(_clientModel, HttpStatus.OK);
        }
    }

}
