/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.TrabajoTallerServidor;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andres
 */
public class BDAdaptador {

    private String sLastError;

    public BDAdaptador() {
        sLastError = "";
    }

    private Connection initDatabase() {
        Connection con = null;
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://bbdd:3306/";
        // Database name to access
        String dbName = "taller_db";
        String dbUsername = "mecanico";
        String dbPassword = "2secret2know";

        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error conectando a la BBDD: " + e.getMessage() + "</p>";
            e.printStackTrace();
        }
        return con;
    }

    //Cambiar por listaPacientes, se buscan por apellidos
    public String getPacientes(String apellidosPaciente) {
        String resultado = "";
        String dni, nombrePaciente, apellidos, fNac, telefono, email;
        Connection connection = null;
        Statement st = null;
        PreparedStatement ps = null;
        int iRows = 0;
        try {
            connection = this.initDatabase();

            //st = con.createStatement();
            ps = connection.prepareStatement("select * from paciente where apellido=?");
            ps.setString(1, apellidosPaciente);

            //ResultSet rs = st.executeQuery("select * from proveedores");
            ResultSet rs = ps.executeQuery();

            // iteración sobre el resultset
            while (rs.next()) //Mientras tengamos rows de salida...
            {
                iRows++;
                dni = (rs.getString("dni"));
                nombrePaciente = rs.getString("nombrePaciente");
                apellidos = rs.getString("apellidos");
                fNac = rs.getString("fnac");
                telefono = rs.getString("telefono");
                email = rs.getString("email");

                // save the results
                resultado += "<p>" + dni + ";"
                        + nombrePaciente + ";"
                        + apellidos + ";"
                        + fNac + ";"
                        + telefono + ";"
                        + email + "</p>\n";
            }
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la BBDD Select: " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos sentencia y conexión
            try {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la BBDD: " + e.getMessage() + "</p>";
                e.printStackTrace();
            }
        }
        resultado += "\n<p>Rows recogidas: " + iRows + "</p>\n";
        if (sLastError.isEmpty()) {
            return resultado;
        } else {
            return resultado + sLastError;
        }
    }            

    //Método de inserción en la tabla de proveedores de un nuevo valor.
    //Cambiar por insertar Paciente.
    public String insertPaciente(String json) {
        String resultado = "<p>Error al insertar</p>";
        String dni, nombrePaciente, apellidos, fNac, telefono, email;
        Connection connection = null;
        
        Paciente paciente = (Paciente) new Gson().fromJson(json, Paciente.class); 

        PreparedStatement ps = null;

        try {
            connection = this.initDatabase();

            //st = con.createStatement();
            ps = connection.prepareStatement("insert into paciente (dni, nombrePaciente, apellidos, fnac, telefono, email) values (?,?,?,?,?,?)");
            ps.setString(1, paciente.getsDni());
            ps.setString(2, paciente.getsNombre());
            ps.setString(3, paciente.getsApellidos());
            ps.setString(4, paciente.getsFNac());
            ps.setString(5, paciente.getsApellidos());
            ps.setString(6, paciente.getsEmail());

            if (ps.executeUpdate() != 0) {
                resultado = "<p>Proveedor insertado correctamente</p>";
            } else {
                resultado = "<p>Algo ha salido mal con la sentencia Insert Proveedores</p>";
            }
            //En este caso es una orden hacia la BBDD, y no tenemos
            //ResultSet para iterar, las cosas pueden ir bien, o mal, nada más
            //que hacer entonces aquí

        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la BBDD Select: " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos sentencia y conexión
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la BBDD: " + e.getMessage() + "</p>";
                e.printStackTrace();

            }
        }
        if (sLastError.isEmpty()) {
            return resultado;
        } else {
            return resultado + sLastError;
        }

    }

    //listaTratamientos (por DNI)
    //insertTratamiento (sCSV)
    //cobraTratamiento  setter (codTratamiento, codPaciente)
}
