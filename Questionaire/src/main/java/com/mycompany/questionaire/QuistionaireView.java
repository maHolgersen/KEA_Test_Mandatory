/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
/**
 *
 * @author carst
 */
public final class QuistionaireView extends Frame{
    private JFrame pnl;
    private Questionaire questionaire;
    private JButton submit = new JButton("Submit");
    private List radioGrps;
    
    
    
    public QuistionaireView(Questionaire questionaire){
        this.questionaire = questionaire;
        pnl = new JFrame();
        pnl.setLayout(new FlowLayout());
        radioGrps = new ArrayList();
        
        for (int i = 0; i < questionaire.getQuestions().size(); i++) {
            Panel questionPnl = new Panel(new FlowLayout());
            questionPnl.setSize(200, 200);
            createQuesion((Question)questionaire.getQuestions().get(i), questionPnl);
        }
        pnl.setVisible(true);
        
        submit.addActionListener((ActionEvent e) -> {
            for (int i = 0; i < pnl.getComponents().length; i++) {
                
                ButtonGroup btngrp = (ButtonGroup) radioGrps.get(i);
            }
            //for (Object question : questionaire.getQuestions()) {
            //    int score = 0;
                
            //}    
        });
        
        pnl.add(submit);
    }
    
    
    
    public void createQuesion(Question question, Panel questionPnl){
        
        //Panel questionpnl = new Panel(new FlowLayout());
        pnl.add(questionPnl);
        Label questionDes = new Label(question.getDescription());
        
        questionPnl.add(questionDes);
        
        JRadioButton[] radioGrp = new JRadioButton[question.getAnswers().size()];
        ButtonGroup btnGrp = new ButtonGroup();
        
        for (int i = 0; i < radioGrp.length; i++) {
           radioGrp[i] = new JRadioButton((String)question.getAnswers().get(i));
           btnGrp.add(radioGrp[i]);
           questionPnl.add(radioGrp[i]);
            System.out.println(radioGrp[i]);
        }
        
        radioGrps.add(btnGrp);
        questionPnl.setVisible(true);
        
    }
}
