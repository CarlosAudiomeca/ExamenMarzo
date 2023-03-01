package com.iesam.openbank.data;

import com.iesam.openbank.data.local.ProductoFileDataSource;
import com.iesam.openbank.domain.ProductoRepository;
import com.iesam.openbank.domain.models.Producto;


public class ProductoDataRepository implements ProductoRepository {

    private ProductoFileDataSource dataSource;

    public ProductoDataRepository(ProductoFileDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Producto producto) {
        dataSource.save(producto);
    }

    @Override
    public void findById(String codigoProducto) {
        dataSource.findById(codigoProducto);
    }

    @Override
    public void delete(String codigoProducto) {
        dataSource.delete(codigoProducto);
    }


}


