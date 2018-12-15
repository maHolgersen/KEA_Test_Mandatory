/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kea.clientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carst
 */
@WebServlet(name = "CreateQuestionnaireServlet", urlPatterns = {"/CreateQuestionnaireServlet"})
public class CreateQuestionnaireServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String js = "<script>\n"
                    + "var x = 0;\n"
                    + "function addAnswer(i){\n"
                    + "var hiddenName = 'q\'+i+\'Answers';"
                    + "console.log(hiddenName);"
                    + "x = parseInt(document.getElementById(hiddenName.toString()).value) + 1;\n"
                    + "document.getElementById('q'+ i +'Answers').value = x;\n"
                    + "var lastQ = 'lastAnswer' + i;\n"
                    + "console.log(lastQ);"
                    + "$(lastQ).append('Answer '+ x +' :<br/>"
                    + "<input type=\"text\" name=\"answer '+ x +'\"><br/>'"
                    + ")}\n"
                    + "</script>";
            
                    
            String jsAddQuestion = "<script>\n"
                    + "var questions = 1;\n"
                    + "function addQuestion(){\n"
                    + "var numQuest = parseInt(questions)+1;\n"
                    + "questions = questions + 1;\n"
                    + "console.log(numQuest);"
                    + "var hiddenName = 'q\'+numQuest+\'Answers';"
                    + "console.log(hiddenName);"
                    + "$('lastAnswer1').append('"
                    + "-----------------------------<br/>"
                    + "<input type=\"hidden\" value=\"1\" id=\"'+hiddenName+'\">"
                    + "Question ' +numQuest+ ':<br/>"
                    + "<input type=\"textarea\" name=\"questionX\">"
                    + "<input type=\"button\" value=\"add Answer\" name\"addAbutt\" onclick=\"addAnswer('+numQuest+')\"><br/>"
                    + "Answer 1:<br/>"
                    + "<input type=\"text\" name\"qXaX\"><br/>"
                    + "<lastAnswer'+numQuest+'></lastAnswer'+numQuest+'>"
                    + "')}\n"
                    + "</script>";
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Create a Questionnaire</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Create a questionnaire!</h1>");
            
            out.println("<p> Here you can create a questionnaire. Give it a name, add questions and answers</p>");
            out.println("<p> When done click on the save questionnaire button</p>");
            out.println("<p>OBS!!! be aware that as of right now, the first answer should be the correct one OBS!!!</p><br/><br/>");
            
            out.println("<form name='questionnaire' type='post' action=' '>");
            out.println("<input id='q1Answers' type='hidden' value='3'>");
            out.println("<p>Questionnaire Title:<br/>");
            out.println("<input type='text' name='questionnaireTitle'><br/>");
            out.println("Question 1:<br/>");
            out.println("<input type='textarea' name='question1'>");
            out.println("<input type='button' value='add Answer' name='addAbut' onclick=\"addAnswer(1)\"><br/>");
            out.println("Answer 1:<br/>");
            out.println("<input type='text' name='answer1'><br/>");
            out.println("Answer 2:<br/>");
            out.println("<input type='text' name='answer2'><br/>");
            out.println("Answer 3:<br/>");
            out.println("<input type='text' name='answer3'><br/>");
            
            out.println("<lastAnswer1></lastAnswer1><br/>");
            
            out.println("<input type='button' value='add Question'  name='addQbut' onclick='addQuestion()'>");
            
            out.println("<input type='submit' value='save' name='saveQuestionnaire'>--");
            out.println("</form><br/>");
           
            
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
            out.println(js);
            out.println(jsAddQuestion);
            
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
