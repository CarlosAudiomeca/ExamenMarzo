package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.models.Cliente;

public class GetClienteUseCase {

    private ClienteRepository clienteRepository;

    public GetClienteUseCase(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public Cliente execute(String codigoCliente){
        return clienteRepository.findById(codigoCliente);
    }

}
