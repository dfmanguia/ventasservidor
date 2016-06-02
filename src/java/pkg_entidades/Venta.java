/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paúl
 */
public class Venta {
    
    String ven_id,clie_id,usu_id,ven_lugar,ven_nombre;
    List<Venta> lista;
    ArrayList<Venta> listas;

    public Venta(String ven_id, String clie_id, String usu_id, String ven_lugar, String ven_nombre) {
        this.ven_id = ven_id;
        this.clie_id = clie_id;
        this.usu_id = usu_id;
        this.ven_lugar = ven_lugar;
        this.ven_nombre = ven_nombre;
    }

    public String getVen_id() {
        return ven_id;
    }

    public void setVen_id(String ven_id) {
        this.ven_id = ven_id;
    }

    public String getClie_id() {
        return clie_id;
    }

    public void setClie_id(String clie_id) {
        this.clie_id = clie_id;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }

    public String getVen_lugar() {
        return ven_lugar;
    }

    public void setVen_lugar(String ven_lugar) {
        this.ven_lugar = ven_lugar;
    }

    public String getVen_nombre() {
        return ven_nombre;
    }

    public void setVen_nombre(String ven_nombre) {
        this.ven_nombre = ven_nombre;
    }

    public List<Venta> getLista() {
        return lista;
    }

    public void setLista(List<Venta> lista) {
        this.lista = lista;
    }

    public ArrayList<Venta> getListas() {
        return listas;
    }

    public void setListas(ArrayList<Venta> listas) {
        this.listas = listas;
    }
    
    
    
}
