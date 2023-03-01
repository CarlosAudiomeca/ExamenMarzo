package com.iesam.openbank.data;

import com.iesam.openbank.data.local.CuentaBacariaFileDataSource;
import com.iesam.openbank.domain.CuentaBancariaRepository;
import com.iesam.openbank.domain.models.CuentaBancaria;

public class CuentaBancariaDataRepository implements CuentaBancariaRepository {

    private CuentaBacariaFileDataSource dataSource;

    public CuentaBancariaDataRepository(CuentaBacariaFileDataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public void save(CuentaBancaria cuentaBancaria) {
        dataSource.save(cuentaBancaria);
    }

    @Override
    public void findById(String codigoCuenta) {
        dataSource.findById(codigoCuenta);
    }

    @Override
    public void delete(String codigoCuenta) {
        dataSource.delete(codigoCuenta);
    }
}
