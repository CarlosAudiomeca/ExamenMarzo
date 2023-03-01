package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.models.Cliente;

public class AddClienteUseCase {

    private ClienteRepository clienteRepository;

    public AddClienteUseCase(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(Cliente cliente){
        clienteRepository.save(cliente);
    }

}
