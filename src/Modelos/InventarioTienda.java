package Modelos;

import java.io.Serializable;

public class InventarioTienda implements Serializable {
    private int id;
    private int id_vehiculo;
    private int prezo_mayorista;
    private int prezo_venta;
    private int porcentaxe_oferta;

    public InventarioTienda() {
    }

    public InventarioTienda(int id, int id_vehiculo, int prezo_mayorista, int prezo_venta, int porcentaxe_oferta) {
        this.id = id;
        this.id_vehiculo = id_vehiculo;
        this.prezo_mayorista = prezo_mayorista;
        this.prezo_venta = prezo_venta;
        this.porcentaxe_oferta = porcentaxe_oferta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getid_vehiculo() {
        return id_vehiculo;
    }

    public void setid_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getprezo_mayorista() {
        return prezo_mayorista;
    }

    public void setprezo_mayorista(int prezo_mayorista) {
        this.prezo_mayorista = prezo_mayorista;
    }

    public int getPorcentaxe_oferta() {
        return porcentaxe_oferta;
    }

    public void setPorcentaxe_oferta(int porcentaxe_oferta) {
        this.porcentaxe_oferta = porcentaxe_oferta;
    }

    public int getprezo_venta() {
        return prezo_venta;
    }

    public void setprezo_venta(int prezo_venta) {
        this.prezo_venta = prezo_venta;
    }

    @Override
    public String toString() {
        return "InventarioTienda{" +
                "id=" + id +
                ", id_vehiculo=" + id_vehiculo +
                ", prezo_mayorista=" + prezo_mayorista +
                ", prezo_venta=" + prezo_venta +
                '}';
    }
}
