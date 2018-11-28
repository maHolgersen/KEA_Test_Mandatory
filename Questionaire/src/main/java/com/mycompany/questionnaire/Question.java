/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionnaire;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carst
 */
public class Question implements Serializable{
    private List answers;
    private String description;
    private int correctAnswer;
    private int points;
    
    public Question(List answers, String description, int correctAnswer, int points){
        this.answers = answers;
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }
    
    public Question(){
        answers = new ArrayList();
        points  = 10;
    }
    
    public void removeAnswer(String answer){
        answers.remove(answer);
    }
    
    public void removeAnswer(int index){
        answers.remove(index);
    }
    
    public void addAnswer(String answer, boolean isCorrectAnswer){
        answers.add(answer);
        if (isCorrectAnswer) {
            answers.lastIndexOf(answer);
        }
    }
    
    public int getPoints(){
        return points;
    }
    
    public int getCorrectAnswer(){
        return correctAnswer;
    }
    
    public List getAnswers(){
        return answers;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setCorrectAnswer(int correctAnswer){
        this.correctAnswer = correctAnswer;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setAnswers(List answers){
        this.answers = answers;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
}
