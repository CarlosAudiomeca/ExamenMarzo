package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;

public class DeleteClienteUseCase {

    private ClienteRepository clienteRepository;

    public DeleteClienteUseCase (ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(String codigoCliente){
        clienteRepository.delete(codigoCliente);
    }

}
