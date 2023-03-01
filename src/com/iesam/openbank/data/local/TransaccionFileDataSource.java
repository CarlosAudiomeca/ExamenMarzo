package com.iesam.openbank.data.local;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

public class TransaccionFileDataSource {

    private static TransaccionFileDataSource instance=null;

    private String nameFile = "transaccion.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Transaccion>>() {
    }.getType();

    public void save(Transaccion transaccion) {
        List<Transaccion> transaccions = findAll();
        transaccions.add(transaccion);
        saveToFile(transaccions);
    }

    public void saveList(List<Transaccion> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Transaccion> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Transaccion findById(String codigo) {
        List<Transaccion> transaccions = findAll();
        for (Transaccion transaccion : transaccions) {
            if (Objects.equals(transaccion.getCodigo(), codigo)) {
                return transaccion;
            }
        }
        return null;
    }

    public List<Transaccion> findAll() {
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
        List<Transaccion> newList = new ArrayList<>();
        List<Transaccion> transaccions = findAll();
        for (Transaccion model : transaccions) {
            if (model.getCodigo() != codigoTransaccion) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    public static TransaccionFileDataSource getInstance(){
        if(instance==null){
            instance=new TransaccionFileDataSource();
        }
        return instance;
    }
}
