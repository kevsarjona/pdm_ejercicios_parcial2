package com.example.pdm_ejercicios_parcial2.poo;

public class Bicicleta {

    private String name;
    private String color;
    public Bicicleta(String name,String color){
        this.name = name;
        this.color = color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
