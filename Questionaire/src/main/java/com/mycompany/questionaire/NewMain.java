/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.util.ArrayList;

/**
 *
 * @author carst
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ans1 = "ans1";
        String ans2 = "ans2";
        String ans3 = "ans3";
        String ans4 = "ans4";
        ArrayList answers = new ArrayList();
        
        answers.add(ans1);
        answers.add(ans2);
        answers.add(ans3);
        answers.add(ans4);
        
        Question q1 = new Question(answers, "q1", 1, 10);
        Question q2 = new Question(answers, "q2", 1, 10);
        Question q3 = new Question(answers, "q3", 1, 10);
        Question q4 = new Question(answers, "q4", 1, 10);
        
        ArrayList questions = new ArrayList();
        
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        questions.add(q4);
        
        Questionaire questionaire = new Questionaire(questions);
        
        QuistionaireView qView = new QuistionaireView(questionaire);
        
        System.out.println(questionaire.getQuestions().size());
    }
    
}
