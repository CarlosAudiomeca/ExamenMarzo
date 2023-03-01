package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.TransaccionRepository;

public class GetTrasaccionUseCase {

    private TransaccionRepository clienteRepository;

    public GetTrasaccionUseCase(TransaccionRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(String codigoCliente){
        clienteRepository.findAll();
    }

}
