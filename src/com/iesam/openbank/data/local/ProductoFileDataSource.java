package com.iesam.openbank.data.local;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.openbank.domain.models.Producto;
import com.iesam.openbank.domain.models.Transaccion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductoFileDataSource {

    private static ProductoFileDataSource instance=null;

    private String nameFile = "producto.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Producto>>() {
    }.getType();

    public void save(Producto producto) {
        List<Producto> productos = findAll();
        productos.add(producto);
        saveToFile(productos);
    }

    public void saveList(List<Producto> productos) {
        saveToFile(productos);
    }

    private void saveToFile(List<Producto> productos) {
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


    public Producto findById(String codigo) {
        List<Producto> productos = findAll();
        for (Producto producto : productos) {
            if (Objects.equals(producto.getCodigo(), codigo)) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> findAll() {
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

    public void delete(String codigoTransaccion) {
        List<Producto> newList = new ArrayList<>();
        List<Producto> productos = findAll();
        for (Producto producto : productos) {
            if (producto.getCodigo() != codigoTransaccion) {
                newList.add(producto);
            }
        }
        saveList(newList);
    }

    public static ProductoFileDataSource getInstance(){
        if(instance==null){
            instance=new ProductoFileDataSource();
        }
        return instance;
    }
}
