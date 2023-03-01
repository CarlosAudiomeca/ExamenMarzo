package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.CuentaBancariaRepository;
import com.iesam.openbank.domain.models.CuentaBancaria;

public class AddCuentaUseCase {

    private CuentaBancariaRepository clienteRepository;

    public AddCuentaUseCase(CuentaBancariaRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(CuentaBancaria cuentaBancaria){
        clienteRepository.save(cuentaBancaria);
    }

}
