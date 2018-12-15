/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kea.clientservlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kea.services.QuestionnaireService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author carst
 */
@WebServlet(name = "SubmitAnswersServlet", urlPatterns = {"/SubmitAnswersServlet"})
public class SubmitAnswersServlet extends HttpServlet {
 
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
            
            java.lang.String name = request.getParameter("qName");
            java.lang.String q = request.getParameter("question0");
            
            ArrayList answers = new ArrayList();
            Enumeration<String> parameterNames = request.getParameterNames();
            
            while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
                for (int i = 0; i < paramValues.length; i++) {
                    String paramValue = paramValues[i];
                    if (paramName.startsWith("question")) {
                        answers.add(paramValue);
                    }
                }
            }
            
            Gson builder = new GsonBuilder().create();
            String g = builder.toJson(answers, ArrayList.class);
            
            String r = port.submitAnswers(g, name);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Results</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + name + "</h1>");
            out.println("<p> " + r);
            out.println("<form name='mainMenu' type='post' action=' '>");
            out.println("<input type='submit' value='Main menu' name='mainMenu'>");
            out.println("</form");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            // TODO handle custom exceptions here
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
