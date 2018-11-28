/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionnaire;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author carst
 */
public class AdminView extends JPanel{
    private JButton createQuestionnaire;
    private JButton updateQuestionnaire;
    private JButton mainMenu;
    
    
    public AdminView(int x, int y, MainPage mf){
                
        settupPanel(x, y);
        
        createQuestionnaireButton(mf);
        updateQuestionnaireButton(mf);
        mainMenuButton(mf);
          
    }
    
    private void createQuestionnaireButton(MainPage mf){
        createQuestionnaire = new JButton("Create Questionnaire");
        
        createQuestionnaire.addActionListener((ActionEvent e) -> {
           //add action to change to AdminView 
           mf.getCardLayout().show(mf.getCards(), "createquestionnaireview");
        });
        add(createQuestionnaire);
    }
    
    private void updateQuestionnaireButton(MainPage mf){
        updateQuestionnaire = new JButton("Update questionnaire");
        
        updateQuestionnaire.addActionListener((ActionEvent e) -> {
           //add action to change to AdminView 
           mf.getCardLayout().show(mf.getCards(), "updatequestionnaireview");
        });
        add(updateQuestionnaire);
    }
    
    private void mainMenuButton(MainPage mf){
        mainMenu = new JButton("Main menu");
        
        mainMenu.addActionListener((ActionEvent e) -> {
           //action to show the main menu card
            mf.getCardLayout().show(mf.getCards(), "maincard");
        });
        add(mainMenu);
    }
    
    private void settupPanel(int x, int y){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(x, y));
        setVisible(true);
    }
    
    
    
}
