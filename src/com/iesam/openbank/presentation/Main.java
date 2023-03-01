package com.iesam.openbank.presentation;

import com.iesam.openbank.data.ClienteDataRepository;
import com.iesam.openbank.data.CuentaBancariaDataRepository;
import com.iesam.openbank.data.ProductoDataRepository;
import com.iesam.openbank.data.TransaccionDataRepository;
import com.iesam.openbank.data.local.ClienteFileDataSource;
import com.iesam.openbank.data.local.CuentaBacariaFileDataSource;
import com.iesam.openbank.data.local.ProductoFileDataSource;
import com.iesam.openbank.data.local.TransaccionFileDataSource;
import com.iesam.openbank.domain.ClienteRepository;
import com.iesam.openbank.domain.CuentaBancariaRepository;
import com.iesam.openbank.domain.ProductoRepository;
import com.iesam.openbank.domain.TransaccionRepository;
import com.iesam.openbank.domain.models.*;
import com.iesam.openbank.domain.useCase.*;

import java.util.List;

public class Main {

    public static void main(String[]Args){

        ClienteRepository clienteRepository = new ClienteDataRepository(ClienteFileDataSource.getInstance());
        CuentaBancariaRepository cuentaBancariaRepository = new CuentaBancariaDataRepository(CuentaBacariaFileDataSource.getInstance());
        ProductoRepository productoRepository = new ProductoDataRepository(ProductoFileDataSource.getInstance());
        TransaccionRepository transaccionRepository = new TransaccionDataRepository(TransaccionFileDataSource.getInstance());

        Transaccion transaccion1 = new Transaccion();
        transaccion1.setCodigo("1");
        transaccion1.setDescripcion("Cosas");
        transaccion1.setImporte(200);
        transaccion1.setTipo("cobro");

        Transaccion transaccion2 = new Transaccion();
        transaccion2.setCodigo("2");
        transaccion2.setDescripcion("Cosssas");
        transaccion2.setImporte(250);
        transaccion2.setTipo("pago");

        AddTransaccionUseCase addTransaccionUseCase = new AddTransaccionUseCase(transaccionRepository);
        addTransaccionUseCase.execute(transaccion1);
        addTransaccionUseCase.execute(transaccion2);


        Producto hipoteca = new Hipoteca();
        hipoteca.setCodigo("1");
        hipoteca.setDescripcion("endeudao");
        hipoteca.setNombre("Lorron");


        AddProductoUseCase addProductoUseCase = new AddProductoUseCase(productoRepository);
        addProductoUseCase.execute(hipoteca);
        GetProductoUseCase getProductoUseCase = new GetProductoUseCase(productoRepository);

        Cliente cliente = new Cliente();
        cliente.setDni("4566145648");
        cliente.setNombre("Carlos");
        cliente.setApellidos("Jimenez");
        cliente.setDireccion("uhsdjhf");
        cliente.setPoblacion("jsjsjiosdjios");
        cliente.setCodigoPostal("jhsgjios");


        AddClienteUseCase addClienteUseCase = new AddClienteUseCase(clienteRepository);
        addClienteUseCase.execute(cliente);
        GetClienteUseCase getClienteUseCase = new GetClienteUseCase(clienteRepository);

        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        cuentaBancaria.setNumeroCuenta("56565623");
        cuentaBancaria.setTitular(getClienteUseCase.execute("2"));
        cuentaBancaria.setSaldo(300);

        AddCuentaUseCase addCuentaUseCase = new AddCuentaUseCase(cuentaBancariaRepository);
        addCuentaUseCase.execute(cuentaBancaria);

    }

}
