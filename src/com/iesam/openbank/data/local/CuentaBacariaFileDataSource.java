package com.iesam.openbank.data.local;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.openbank.domain.models.Cliente;
import com.iesam.openbank.domain.models.CuentaBancaria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CuentaBacariaFileDataSource {

    private static CuentaBacariaFileDataSource instance=null;

    private String nameFile = "cuenta.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<CuentaBancaria>>() {
    }.getType();

    public void save(CuentaBancaria cliente) {
        List<CuentaBancaria> clientes = findAll();
        clientes.add(cliente);
        saveToFile(clientes);
    }

    public void saveList(List<CuentaBancaria> clientes) {
        saveToFile(clientes);
    }

    private void saveToFile(List<CuentaBancaria> productos) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(productos));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public CuentaBancaria findById(String codigo) {
        List<CuentaBancaria> clientes = findAll();
        for (CuentaBancaria cliente : clientes) {
            if (Objects.equals(cliente.getNumeroCuenta(), codigo)) {
                return cliente;
            }
        }
        return null;
    }

    public List<CuentaBancaria> findAll() {
        try {
            File myObj = new File(nameFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void delete(String codigoCliente) {
        List<CuentaBancaria> newList = new ArrayList<>();
        List<CuentaBancaria> clientes = findAll();
        for (CuentaBancaria cliente : clientes) {
            if (cliente.getNumeroCuenta() != codigoCliente) {
                newList.add(cliente);
            }
        }
        saveList(newList);
    }

    public static CuentaBacariaFileDataSource getInstance(){
        if(instance==null){
            instance=new CuentaBacariaFileDataSource();
        }
        return instance;
    }
}
