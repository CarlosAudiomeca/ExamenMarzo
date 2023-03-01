package com.iesam.openbank.data;

import com.iesam.openbank.data.local.TransaccionFileDataSource;
import com.iesam.openbank.domain.TransaccionRepository;
import com.iesam.openbank.domain.models.Transaccion;

public class TransaccionDataRepository implements TransaccionRepository{

    private TransaccionFileDataSource dataSource;

    public TransaccionDataRepository(TransaccionFileDataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public void save(Transaccion transaccion) {
        dataSource.save(transaccion);
    }

    @Override
    public void findAll() {
        dataSource.findAll();
    }
}
