package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.ProductoRepository;

public class DeleteCuentaUseCase {

    private ProductoRepository clienteRepository;

    public DeleteCuentaUseCase(ProductoRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(String codigoCliente){
        clienteRepository.delete(codigoCliente);
    }

}
