package com.iesam.openbank.domain.useCase;

import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.ProductoRepository;
import com.iesam.openbank.domain.models.Cliente;
import com.iesam.openbank.domain.models.Producto;

public class AddProductoUseCase {

    private ProductoRepository clienteRepository;

    public AddProductoUseCase(ProductoRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public void execute(Producto cliente){
        clienteRepository.save(cliente);
    }

}
