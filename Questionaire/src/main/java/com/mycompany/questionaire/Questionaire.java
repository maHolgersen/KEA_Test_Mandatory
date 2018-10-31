/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.util.List;

/**
 *
 * @author carst
 */
public class Questionaire {
    private List<Question> questions;
    
    public Questionaire(){
        
    }
    
    public Questionaire(List questions){
        this.questions = questions;
    }
    
    public int getTotalPoints(){
        int totalPoints = 0;
        for (int i = 0; i < questions.size(); i++) {
            totalPoints =+ questions.get(i).getPoints();
        }
        return totalPoints;
    }
    
    public void setQuestions(List questions){
        this.questions = questions;
    }
    
    public List getQuestions(){
        return questions;
    }
}
