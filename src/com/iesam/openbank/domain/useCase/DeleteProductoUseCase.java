package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ProductoRepository;

public class DeleteProductoUseCase {

    private ProductoRepository clienteRepository;

    public DeleteProductoUseCase(ProductoRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(String codigoCliente){
        clienteRepository.delete(codigoCliente);
    }

}
