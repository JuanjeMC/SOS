/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.politecnicomalaga.TrabajoTallerServidor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andres
 */
public class Pacientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String peticionSolicitada = request.getParameter("peticion");
        String datos;
        //String datos = request.getParameter("datos");  //Datos enviados en JSON

        response.setContentType("text/html;charset=UTF-8");

        String resultado = "";
        BDAdaptador bd = new BDAdaptador();

        switch (peticionSolicitada) {
            case "listaPacientes":
                datos = request.getParameter("apellidos");  //Datos enviados en JSON
                resultado = bd.getPacientes(datos); //apellidos
                break;
            case "listaTratamientos":
                datos = request.getParameter("dniPaciente");
                resultado = bd.getTratamientos(datos); //dniPaciente
                break;
            case "insertPaciente":
                datos = request.getParameter("sCSVPaciente");
                resultado = bd.insertPaciente(datos); //JSON Paciente
                break;
            case "insertTratamiento":
                datos = request.getParameter("sCSVTratamiento");
                resultado = bd.insertTratamiento(datos); // JSON Tratamiento
                break;
            case "cobraTratamiento":

                String codTratamiento = request.getParameter("codTratamiento");
                String codPaciente =  request.getParameter("codPaciente");
                resultado = bd.cobraTratamiento(codTratamiento,codPaciente); //codTratamiento,codPaciente
                break;

            default: resultado = "<p>Parámetro desconocido</p>";
        }

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.print(resultado);
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<title>Proyecto Clinica</title>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "</head>\n" +
                    "<body><p>Resultado:</p>\n" +
                    resultado +
                    "</body>\n" +
                    "</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "BackEnd Clinica Servlet";
    }// </editor-fold>

}