package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.ProductoRepository;

public class GetProductoUseCase {

    private ProductoRepository clienteRepository;

    public GetProductoUseCase(ProductoRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(String codigoCliente){
        clienteRepository.findById(codigoCliente);
    }

}
