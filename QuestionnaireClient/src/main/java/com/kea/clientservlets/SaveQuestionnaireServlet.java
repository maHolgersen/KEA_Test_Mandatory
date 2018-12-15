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
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import com.mycompany.questionnaire.Questionnaire;
import com.mycompany.questionnaire.Question;
import java.util.ArrayList;

/**
 *
 * @author carst
 */
@WebServlet(name = "SaveQuestionnaireServlet", urlPatterns = {"/SaveQuestionnaireServlet"})
public class SaveQuestionnaireServlet extends HttpServlet {
    
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
            
            Questionnaire q = new Questionnaire();
            Enumeration<String> parameterNames = request.getParameterNames();
            ArrayList questions = new ArrayList();
            Question quest = new Question();
            String title = "";
            
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String[] paramValues = request.getParameterValues(paramName);
                for (int i = 0; i < paramValues.length; i++) {
                    String paramValue = paramValues[i];
                    
                    if (paramName.startsWith("quest") && !paramName.contains("tionnaire")) {
                        if (paramName.endsWith("1")) {
                           quest.setDescription(paramValue);
                        }else {
                            questions.add(quest);
                            quest = new Question();
                            quest.setDescription(paramValue);
                        }
                        System.out.println("ParamName: " + paramName + " paramValue: " + paramValue);
                        
                    } else if(paramName.contains("answer") && paramName.endsWith("1")){
                        quest.addAnswer(paramValue, true);
                    } else if(paramName.contains("answer")){
                        quest.addAnswer(paramValue, false);
                    } else if(paramName.contains("Title")){
                        title = paramValue;
                    }
                    
                    if (!parameterNames.hasMoreElements()) {
                        questions.add(quest);
                    }
                }
            }
            q.setQuestions(questions);
            
            Gson builder = new GsonBuilder().create();
            String qList = builder.toJson(q);
            
            com.kea.services.QuestionnaireService port = service.getQuestionnaireServicePort();
            port.saveQuestionnaire(qList, title);
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Questionnaire saved</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Questionnaire saved!</h1>");
            out.println("<form type='post' action=' '>");
            out.println("<input type='submit' value='Main menu'>");
            out.println("</form>");
            out.println("<form type='post' action='CreateQuestionnaireServlet'>");
            out.println("<input type='submit' value='Create Questionnaire'>");
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
