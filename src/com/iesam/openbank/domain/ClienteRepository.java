package com.iesam.openbank.domain;

import com.iesam.openbank.domain.models.Cliente;

public interface ClienteRepository {


    public void save(Cliente cliente);

    public void findById(String codigoCliente);

    public void delete(String codigoCliente);
}
