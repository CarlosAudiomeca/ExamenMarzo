package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.CuentaBancariaRepository;

public class GetCuentaUseCase {

    private CuentaBancariaRepository clienteRepository;

    public GetCuentaUseCase(CuentaBancariaRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(String codigoCliente){
        clienteRepository.findById(codigoCliente);
    }

}
