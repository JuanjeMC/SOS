package com.politecnicomalaga.TrabajoTallerServidor;


import java.text.Format;

public class Tratamiento {
public enum AtributosTratamiento {CODIGO,DESCRIPCION,FECHA,PRECIO,COBRADO,DNIPACIENTE};

protected String sCodigo;
protected String sDescripcion;
protected String sFecha;
protected float fPrecio;
protected boolean bCobrado;
protected String sDniPaciente;

//Constructor
public Tratamiento(String sCodigo, String sDescripcion, String sFecha, float fPrecio, String sDniPaciente) {
this.sCodigo = sCodigo;
this.sDescripcion = sDescripcion;
this.sFecha = sFecha;
this.fPrecio = fPrecio;

bCobrado = (fPrecio==0f);
this.sDniPaciente = sDniPaciente;
}

/* 
{
    "Codigo":"12345142",
    "Descripcion":"CRC",
    "Fecha":"01-01-01",
    "Precio":1.01,
    "Cobrado": true,
    "DniPaciente": "25778858W"
}
*/
public Tratamiento(String sJSON) {
    JSONObject json = new JSONObject(sJSON);
    
    this.sCodigo  = json.getString("Codigo");
    this.sDescripcion = json.getString("Descripcion");
    this.sFecha = json.getString("Fecha");
    this.fPrecio = json.getFloat("Precio");
    this.bCobrado = json.getBoolean("Cobrado");
    this.sDniPaciente = json.getString("DniPaciente");

}   

/*
public Tratamiento(String sCSV) {
    String[] columnas = sCSV.split(";");

    if (columnas[0].equals("Tratamiento")) {
        this.sCodigo = columnas[1];
        this.sDescripcion = columnas[2];
        this.sFecha = columnas[3];
        this.fPrecio = Float.valueOf(columnas[4]);
        this.bCobrado = Boolean.valueOf(columnas[5]);
    } else {
    this.sCodigo = "";
    this.sDescripcion = "";
    this.sFecha = "";
    this.fPrecio = 0f;

    bCobrado = true;
    }
}
*/
       
//Getters y Setters
public String getsCodigo() {
return sCodigo;
}

public void setsCodigo(String sCodigo) {
this.sCodigo = sCodigo;
}

public String getsDescripcion() {
return sDescripcion;
}

public void setsDescripcion(String sDescripcion) {
this.sDescripcion = sDescripcion;
}

public String getsFecha() {
return sFecha;
}

public void setsFecha(String sFecha) {
this.sFecha = sFecha;
}

public float getfPrecio() {
return fPrecio;
}

public void setfPrecio(float fPrecio) {
this.fPrecio = fPrecio;
}

public float cobrar() {
this.bCobrado = true;
return fPrecio;
}

public boolean estaCobrado() {
return bCobrado;
}

public String getsDniPaciente() {
    return sDniPaciente;
    }
    
    public void setsDniPaciente(String sDniPaciente) {
    this.sDniPaciente = sDniPaciente;
    }


public boolean compara(String campo, AtributosTratamiento at) {
char comparador;
String dato;
switch (at) {
case CODIGO: return this.sCodigo.contains(campo);
case DESCRIPCION: return this.sDescripcion.contains(campo);
case FECHA: return this.sFecha.contains(campo);
case COBRADO: if (campo.equals("true")) return bCobrado;
 else return !bCobrado;
case PRECIO: comparador = campo.charAt(0);
     if (comparador == '>') {
     dato = campo.substring(1);
     return Double.parseDouble(dato)<fPrecio;
     } else if (comparador == '<'){
     dato = campo.substring(1);
     return Double.parseDouble(dato)>fPrecio;
     } else {
     return Double.parseDouble(campo)==fPrecio;
     }

}

   return false;
}

@Override
public String toString() {
return String.format("%6s#%30s#%10s#%4.2f# Cobrado: %b# DniPaciente: %9s", sCodigo, sDescripcion, sFecha, fPrecio,
                     bCobrado, sDniPaciente);
}
/* 
public String toCSV() {
return String.format("Tratamiento;%s;%s;%s;%s;%b\n", sCodigo, sDescripcion, sFecha, fPrecio, bCobrado);
}
*/
public JSONObject toJSON(){

    JSONObject jo = new JSONObject();
    jo.put("Codigo", sCodigo);
    jo.put("Descripcion", sDescripcion);
    jo.put("Fecha", sFecha);
    jo.put("Precio", fPrecio);
    jo.put("Cobrado", bCobrado);
    jo.put("DniPaciente", sDniPaciente);
    }
}