package com.iesam.openbank.data.local;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.openbank.domain.models.Cliente;
import com.iesam.openbank.domain.models.Producto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ClienteFileDataSource {

    private static ClienteFileDataSource instance=null;

    private String nameFile = "cliente.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Cliente>>() {
    }.getType();

    public void save(Cliente cliente) {
        List<Cliente> clientes = findAll();
        clientes.add(cliente);
        saveToFile(clientes);
    }

    public void saveList(List<Cliente> clientes) {
        saveToFile(clientes);
    }

    private void saveToFile(List<Cliente> productos) {
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


    public Cliente findById(String codigo) {
        List<Cliente> clientes = findAll();
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.getDni(), codigo)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> findAll() {
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
        List<Cliente> newList = new ArrayList<>();
        List<Cliente> clientes = findAll();
        for (Cliente cliente : clientes) {
            if (cliente.getDni() != codigoCliente) {
                newList.add(cliente);
            }
        }
        saveList(newList);
    }

    public static ClienteFileDataSource getInstance(){
        if(instance==null){
            instance=new ClienteFileDataSource();
        }
        return instance;
    }
}
