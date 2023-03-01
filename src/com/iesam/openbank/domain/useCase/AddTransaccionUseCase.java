package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.TransaccionRepository;
import com.iesam.openbank.domain.models.Cliente;
import com.iesam.openbank.domain.models.Transaccion;

public class AddTransaccionUseCase {

    private TransaccionRepository clienteRepository;

    public AddTransaccionUseCase(TransaccionRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(Transaccion cliente){
        clienteRepository.save(cliente);
    }

}
