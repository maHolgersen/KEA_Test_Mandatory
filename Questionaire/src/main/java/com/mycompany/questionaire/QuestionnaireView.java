/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 *
 * @author carst
 */
public final class QuestionnaireView extends JPanel{
    private Questionnaire questionaire;
    private JButton submit;
    private JButton mainMenu;
    private List<ButtonGroup> radioGrps;
    private Label score;   
    
    
    public QuestionnaireView(Questionnaire questionaire, MainPage frame){
        this.questionaire = questionaire;
        
        submit = new JButton("Submit");
        submit.setAlignmentY(LEFT_ALIGNMENT);
        radioGrps = new ArrayList();
        
        score = new Label();
        
        for (int i = 0; i < questionaire.getQuestions().size(); i++) {
            Panel questionPnl = new Panel();
            questionPnl.setSize(200, 200);
            frame.add(createQuesion((Question)questionaire.getQuestions().get(i), questionPnl));
        }
        
        frame.add(submit);
        
        submit.addActionListener((ActionEvent e) -> {
            int points = 0;
            
            for (int i = 0; i < questionaire.getQuestions().size(); i++) {
                Question q = (Question)questionaire.getQuestions().get(i);
                ButtonGroup bg = (ButtonGroup)radioGrps.get(i);
                if (q.getAnswers().get(q.getCorrectAnswer()) == getSelectedButton(bg)) {
                    points += q.getPoints();
                }
            }
            if (checkAllAnswers()) {
                int totalScore = this.questionaire.getTotalPoints();
                int pointPerc = points*100/this.questionaire.getTotalPoints();
                
                if (pointPerc < 80) {
                    this.score.setForeground(Color.RED);
                }else{
                    this.score.setForeground(Color.GREEN);
                }
                
                score.setText("Score: " + points + "/" + totalScore + ": " + pointPerc + "%");
                
            } else {
                score.setForeground(Color.BLACK);
                score.setText("Please answer all questions!");
            }
            
            frame.setVisible(true);
            
        });
        
        frame.add(this.score);
        frame.repaint();
    }
    
    public Panel createQuesion(Question question, Panel questionPnl){
        
        Label questionDes = new Label(question.getDescription());
        
        questionPnl.add(questionDes);
        
        JRadioButton[] radioGrp = new JRadioButton[question.getAnswers().size()];
        ButtonGroup btnGrp = new ButtonGroup();
        
        for (int i = 0; i < radioGrp.length; i++) {
           radioGrp[i] = new JRadioButton((String)question.getAnswers().get(i));
           btnGrp.add(radioGrp[i]);
           questionPnl.add(radioGrp[i]);
        }
        
        radioGrps.add(btnGrp);
        questionPnl.setVisible(true);
        
        return questionPnl;
    }
    
    public String getSelectedButton(ButtonGroup bg){
        String selectedButton = "";
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                selectedButton = button.getText();
            }
        }
        
        return selectedButton;
    }
    
    public boolean checkAllAnswers(){
        boolean isAnswered = true;
        
        for (int i = 0; i < radioGrps.size(); i++) {
            ButtonGroup bg = radioGrps.get(i);
            if(bg.getSelection() == null){
                isAnswered = false;
            }
        }
        return isAnswered;
    }
    
    public List getUnansweredQuestion(){
        List<ButtonGroup> unansweredQ = null;
        for (int i = 0; i < radioGrps.size(); i++) {
            ButtonGroup bg = radioGrps.get(i);
            if (bg.getSelection() == null) {
                unansweredQ.add(bg);
            }
        }
        
        return unansweredQ;
    }
    
    public void highLightUnansweredQuestions(List<ButtonGroup> bg){
        for (int i = 0; i < bg.size(); i++) {
            System.out.print("unanswered questions: " + bg.get(i));
        }
    }
}
