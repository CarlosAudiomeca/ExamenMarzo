package com.iesam.openbank.data;

import com.iesam.openbank.data.local.ClienteFileDataSource;
import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.models.Cliente;


public class ClienteDataRepository implements ClienteRepository {

    private ClienteFileDataSource dataSource;

    public ClienteDataRepository(ClienteFileDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Cliente cliente) {
        dataSource.save(cliente);
    }

    @Override
    public void findById(String codigoCliente) {
        dataSource.findById(codigoCliente);
        return null;
    }

    @Override
    public void delete(String codigoCliente) {
        dataSource.delete(codigoCliente);
    }


}


