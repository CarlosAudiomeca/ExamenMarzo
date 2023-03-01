package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;

public class GetClienteUseCase {

    private ClienteRepository clienteRepository;

    public GetClienteUseCase(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(String codigoCliente){
        clienteRepository.findById(codigoCliente);
    }

}
