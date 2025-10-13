package Modelos;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private int id;
    private String modelo;
    private String marca;
    private int ano;
    private String descripcion;

    public Vehiculo() {
    }

    public Vehiculo(int id, String modelo, String marca, int ano, String descripcion) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmodelo() {
        return modelo;
    }

    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getano() {
        return ano;
    }

    public void setano(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", modelo=" + modelo +
                ", marca=" + marca +
                ", ano=" + ano +
                ", descripcion= " + descripcion +
                '}';
    }
}
