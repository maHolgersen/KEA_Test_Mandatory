/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kea.services;

import com.kea.control.FileController;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.mycompany.questionnaire.Questionnaire;
import com.mycompany.questionnaire.Question;
import com.google.gson.*;
import java.util.ArrayList;

/**
 *
 * @author carst
 */
@WebService(serviceName = "QuestionnaireService")
public class QuestionnaireService {

    /**
     * 
     * @param txt name of the questionnaire
     * @return Returns the Questionnaire as a Json string
     */
    @WebMethod
    public String getQuestionnaire(@WebParam(name = "name") String txt) {
        Questionnaire q = FileController.getQuestionnaire(txt);
        Gson builder = new GsonBuilder().create();
        String questionnaire = builder.toJson(q);
        return questionnaire;
    }
    
    /**
     * Needs a Questionnaire as a Json and a name for the Questionnaire
     * @param jsonQestionnaire
     * @param qName 
     */
    @WebMethod
    public void saveQuestionnaire (String jsonQestionnaire, String qName){
       Gson builder = new GsonBuilder().create();
       Questionnaire q = builder.fromJson(jsonQestionnaire, Questionnaire.class);
       FileController.saveQuestionnaire(q, qName);
    }
    
    /**
     * returns a list(ArrayList) with all the names of avaivable Questionnaires
     * @return 
     */
    @WebMethod
    public String getAllQuestionnaires(){
        Gson builder = new GsonBuilder().create();
        ArrayList list = (ArrayList)FileController.getALlQuestionnaires();
        String qList = builder.toJson(list, ArrayList.class);
        System.out.println(qList);
        return qList;
    }
    /**
     * An arrayList with the int representation of the answers given.(jsonAnswers)
     * the name of the questionnaire answered as a string (qName)
     * @param jsonAnswers
     * @param qName
     * @return the result of the set, passed if the score is above 80% of the total score
     * and a fail if its below, will return a string with the score/totalpoints and %.
     */
    @WebMethod
    public String submitAnswers(String jsonAnswers, String qName){
        StringBuilder sb = new StringBuilder();
        int score = 0;
        
        Questionnaire q = FileController.getQuestionnaire(qName);
        Gson builder = new GsonBuilder().create();
        
        ArrayList answers = builder.fromJson(jsonAnswers, ArrayList.class);
        
        System.out.println("-------------------" + answers + "--------------------");
        
        for (int i = 0; i < answers.size(); i++) {
            Question question = (Question)q.getQuestions().get(i);
            int a = Integer.parseInt((String)answers.get(i));
            if (question.getCorrectAnswer() == a) {
                score = score + question.getPoints();
            }
        }
        if (score * 100 / q.getTotalPoints() >= 80) {
            sb.append("Passed! ");
        }else {
            sb.append("Failed! ");
        }
        sb.append(score);
        sb.append("/");
        sb.append(q.getTotalPoints());
        sb.append(" ");
        sb.append(score * 100 / q.getTotalPoints());
        sb.append("%");
        
        String result = sb.toString();
        System.out.println(result);
        return result;
    }
}
