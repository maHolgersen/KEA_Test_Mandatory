/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author carst
 */
public class Questionnaire implements Serializable{
    private List<Question> questions;
    private static final long serialVersionUID = 1L;
    
    public Questionnaire(){
        
    }
    
    public Questionnaire(List questions){
        this.questions = questions;
    }
    
    public int getTotalPoints(){
        int totalPoints = 0;
        for (int i = 0; i < questions.size(); i++) {
            totalPoints += questions.get(i).getPoints();
        }
        return totalPoints;
    }
    
    public void setQuestions(List questions){
        this.questions = questions;
    }
    
    public List getQuestions(){
        return questions;
    }
    
    @Override
    public String toString(){
       return questions.toString();
    }
}
