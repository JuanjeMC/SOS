/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.TrabajoTallerServidor;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author andres
 */

public class Paciente implements Comparable<Paciente>{
    //estado
    protected String sNombre;
    protected String sApellidos;
    protected String sTelefono;
    protected String sEmail;
    protected String sDni;
    protected String sFnac;
    ArrayList<Tratamiento> misTratamientos;

    //Comportamiento
    public Paciente(String sNombre, String sApellidos, String sTelefono, String sEmail, String sDni, String sFnac) {
        this.sNombre = sNombre;
        this.sApellidos = sApellidos;
        this.sTelefono = sTelefono;
        this.sEmail = sEmail;
        this.sDni = sDni;
        this.sFnac = sFnac;
        misTratamientos=new ArrayList<>();

    }
    public boolean nuevoTratamiento(String codigo, String descripcion, String fecha, float precio, String dniPaciente) {

        if (this.buscaUnTratamiento(codigo) == null && precio >= 0f) {
            misTratamientos.add(new Tratamiento(codigo,descripcion,fecha,precio,dniPaciente));
            return true;
        }
        return false;

    }

    public boolean eliminaTratamiento(String codigo) {
        Tratamiento t = this.buscaUnTratamiento(codigo);
        if (t != null) {
            if (t.estaCobrado()) {
                return (misTratamientos.remove(t));
            }
        }
        return false;
    }

    public Tratamiento[] buscaTratamientos(String campoBusqueda, Tratamiento.AtributosTratamiento atributoBusqueda) {
        ArrayList<Tratamiento> resultado = new ArrayList<>();

        for(Tratamiento t:misTratamientos) {
            if (t.compara(campoBusqueda,atributoBusqueda)) {
                resultado.add(t);
            }
        }

        if (resultado.size()>0) {
            Tratamiento[] listaT = new Tratamiento[resultado.size()];
            return resultado.toArray(listaT);
        }
        return null;
    }

    public Tratamiento buscaUnTratamiento(String codigo) {

        for(Tratamiento t:misTratamientos) {
            if (t.getsCodigo().equals(codigo)) {
                return t;
            }
        }

        return null;
    }

    public Tratamiento[] todosTratamientos() {
        if (misTratamientos.size()==0) return null;
        Tratamiento[] listaT = new Tratamiento[misTratamientos.size()];
        return misTratamientos.toArray(listaT);
    }
    public String getsNombre() { return sNombre; }
    public String getsApellidos() { return sApellidos; }
    public String getsTelefono() { return sTelefono; }
    public String getsEmail() { return sEmail; }
    public String getsDni() { return sDni; }
    public String getsFnac() { return sFnac; }
    public void setsNombre(String sNombre) { this.sNombre = sNombre; }
    public void setsApellidos(String sApellidos) { this.sApellidos = sApellidos; }
    public void setsTelefono(String sTelefono) { this.sTelefono = sTelefono; }
    public void setsEmail(String sEmail) { this.sEmail = sEmail; }
    public void setsDni(String sDni) { this.sDni = sDni; }
    public void setsFnac(String sFnac) { this.sFnac = sFnac; }
    public Paciente(String sCSV) {
        String[] listaParametros = sCSV.split(";");
        this.sNombre = listaParametros[0];
        this.sApellidos = listaParametros[1];
        this.sTelefono = listaParametros[2];
        this.sEmail= listaParametros[3];
        this.sDni= listaParametros[4];
        this.sFnac= listaParametros[5];

    }
    @Override
    public String toString() {
        return sNombre + ';' +
                sApellidos +  ';' +
                sTelefono + ';' +
                sEmail + ';' +
                sDni + ';' +
                sFnac + ';';
    }
    /*public String toJson(Paciente miPaciente){
        String json = Gson.toJson(miPaciente);
        return json;
    }*/
    @Override
    public int compareTo(Paciente miPaciente) {
        return (miPaciente.sNombre+miPaciente.sDni).compareTo(this.sNombre+this.sDni);
    }
}
