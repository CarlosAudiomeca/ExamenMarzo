package com.iesam.openbank.domain;

import com.iesam.openbank.domain.models.Cliente;
import com.iesam.openbank.domain.models.CuentaBancaria;

public interface CuentaBancariaRepository {

    public void save(CuentaBancaria cuentaBancaria);

    public void findById(String codigoCuenta);

    public void delete(String codigoCuenta);


}
