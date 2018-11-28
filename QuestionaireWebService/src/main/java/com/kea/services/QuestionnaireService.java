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
import com.google.gson.*;

/**
 *
 * @author carst
 */
@WebService(serviceName = "QuestionnaireService")
public class QuestionnaireService {


    @WebMethod
    public String getQuestionnaire(@WebParam(name = "name") String txt) {
        Questionnaire q = FileController.getQuestionnaire(txt);
        Gson builder = new GsonBuilder().create();
        String questionnaire = builder.toJson(q);
        return questionnaire;
    }
    
    @WebMethod
    public void saveQuestionnaire (String jsonQestionnaire, String qName){
       Gson builder = new GsonBuilder().create();
       Questionnaire q = builder.fromJson(jsonQestionnaire, Questionnaire.class);
       FileController.saveQuestionnaire(q, qName);
    }
}
