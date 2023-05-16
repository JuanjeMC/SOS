package com.politecnicomalaga.clinicadentista;

import java.util.ArrayList;


public class Clinica {
	public enum AtributosClinica {NOMBRE,DESCRIPCION,TELEFONO,EMAIL,CIF};

	//Estados
	protected String sNombre;
	protected String sDireccion;
	protected String sTelefono;
	protected String sEmail;
	protected String sCIF;
	
	protected ArrayList<Paciente> misPacientes;
	
	
	//Comportamiento
	
	//Constructor
	public Clinica(String sNombre, String sDireccion, String sTelefono, String sEmail, String sCIF) {
		this.sNombre = sNombre;
		this.sDireccion = sDireccion;
		this.sTelefono = sTelefono;
		this.sEmail = sEmail;
		this.sCIF = sCIF;
		this.misPacientes = new ArrayList<>();
	}


	public String getsNombre() {
		return sNombre;
	}


	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}


	public String getsDireccion() {
		return sDireccion;
	}


	public void setsDireccion(String sDireccion) {
		this.sDireccion = sDireccion;
	}


	public String getsTelefono() {
		return sTelefono;
	}


	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}


	public String getsEmail() {
		return sEmail;
	}


	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsCIF() {
		return sCIF;
	}

	public void setsCIF(String sCIF) {
		this.sCIF = sCIF;
	}
	
	//CRUD de Pacientes
	public boolean nuevoPaciente(String nombre, String apellidos, String dni, String fNac, String email, String tfno) {

		if (this.buscaPacientes(dni, Paciente.AtributosPaciente.DNI) == null) {
			misPacientes.add(new Paciente(nombre, apellidos, tfno, email, dni, fNac));
			return true;
		}
		return false;
		
	}
	
	public boolean eliminaPaciente(String dni) {
		Paciente[] p = this.buscaPacientes(dni, Paciente.AtributosPaciente.DNI);
		if (p != null && p.length == 1) {
			if (!p[0].tratamientosPendienteCobro()) {
				return (misPacientes.remove(p[0]));
			}
		}
		return false;
	}

	
	public Paciente[] buscaPacientes(String campoBusqueda, Paciente.AtributosPaciente atributoBusqueda) {
        ArrayList<Paciente> resultado = new ArrayList<>();
		
		for(Paciente p: misPacientes) {
			if (p.compara(campoBusqueda,atributoBusqueda)) {
				resultado.add(p);
			}
		}
		
		if (resultado.size()>0) {
			Paciente[] listaP = new Paciente[resultado.size()]; 
			return resultado.toArray(listaP);
		}
		return null;
	}
	
	public Paciente buscaUnPaciente(String dni) {
        
		for(Paciente p: misPacientes) {
			if (p.compara(dni,Paciente.AtributosPaciente.DNI)) {
				return p;
			}
		}
		
		return null;
	}
	
	
	public Paciente[] todosPacientes() {
		if (misPacientes.size()==0) return null;
		Paciente[] listaP = new Paciente[misPacientes.size()]; 
		return misPacientes.toArray(listaP);
	}
	
	public boolean actualizaPaciente(String dni, String campo, Paciente.AtributosPaciente atrActualizar) {
		Paciente p = this.buscaUnPaciente(dni);
		if (p != null) {
			p.setValor(campo, atrActualizar);
			return true;
		}
		return false;
	}
	
	

}