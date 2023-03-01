package com.iesam.openbank.domain;

import com.iesam.openbank.domain.models.Transaccion;

public interface TransaccionRepository {


    public void save(Transaccion transaccion);

    public void findAll();
}
