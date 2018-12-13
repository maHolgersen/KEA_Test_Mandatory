/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kea.clientservlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kea.services.QuestionnaireService_Service;
import com.mycompany.questionnaire.Questionnaire;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Magnus Holgersen
 */
@WebServlet(name = "LoadQuestionnaireServlet", urlPatterns = {"/LoadQuestionnaireServlet"})
public class LoadQuestionnaireServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/QuestionaireWebService/QuestionnaireService.wsdl")
    private QuestionnaireService_Service service;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            com.kea.services.QuestionnaireService port = service.getQuestionnaireServicePort();
            java.lang.String result = port.getAllQuestionnaires();
            
            Gson builder = new GsonBuilder().create();
            ArrayList l = builder.fromJson(result, ArrayList.class);
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l.size(); i++) {
                sb.append("<option value='" + l.get(i) + "'>" + l.get(i) + "</option>");
            }
            
            System.out.println(sb.toString());
            String select = sb.toString();
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadQuestionnaireServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadQuestionnaireServlet at " + request.getContextPath() + "</h1>");
            out.println("<form name='selectQuestionnaire' method='post' action='QuestionnaireServlet'>");
            out.println("<select name='Selected'>");
            out.println(select);
            out.println("</select>");
            out.println("<input type='submit' value='Load Questionaire' name='getQuestionaire'> ");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
        return "Short description";
    }// </editor-fold>

}
