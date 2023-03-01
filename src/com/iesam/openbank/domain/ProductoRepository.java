package com.iesam.openbank.domain;

import com.iesam.openbank.domain.models.Producto;

public interface ProductoRepository {


    public void save(Producto producto);

    public Producto findById(String codigoProducto);

    public void delete(String codigoProducto);
}
