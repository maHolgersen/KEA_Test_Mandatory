/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author carst
 */
public class CreateQuestionnaireView extends JPanel{
    private JButton mainMenu;
    private JButton saveQuestionnaire;
    private JLabel headder;
    private List questions;
    private JPanel buttonPanel;
    
    private JButton addQuestion;
    
    public CreateQuestionnaireView(MainPage mf){
        settupPanel(mf);
        
        questions = new ArrayList();
        addQuestion(mf);
        
    }
    
    public void addQuestion(MainPage mf){
        JPanel question = new JPanel();
        question.setLayout(new FlowLayout());
        question.setPreferredSize(new Dimension(getPreferredSize().width/3, getPreferredSize().height/10));
        JTextArea questionDesc = new JTextArea("Add your question here");
            questionDesc.setPreferredSize(new Dimension(question.getPreferredSize().width, 50));
            questionDesc.setName("question");
        JTextField optionOne = new JTextField("Add an answer");
            optionOne.setName("answer");
        JTextField optionTwo = new JTextField("Add an answer");
            optionTwo.setName("answer");
        JTextField optionThree = new JTextField("Add an answer");
            optionThree.setName("answer");
        
        question.add(questionDesc);
        question.add(optionOne);
        question.add(optionTwo);
        question.add(optionThree);
        
        question.setVisible(true);
        
        add(question);
        questions.add(question);
        mf.setVisible(true);
        setVisible(true);
    }
    
    private void addQuestionButton(MainPage mf){
        addQuestion = new JButton("Add question");
        
        addQuestion.addActionListener((ActionEvent e) -> {
            addQuestion(mf);
        });
        
        buttonPanel.add(addQuestion);
    }
    
    private void mainMenuButton(MainPage mf){
        mainMenu = new JButton("Main menu");
        
        mainMenu.addActionListener((ActionEvent e) -> {
           //action to show the main menu card
            mf.getCardLayout().show(mf.getCards(), "maincard");
        });
        buttonPanel.add(mainMenu);
    }
    
    private void saveQuestionnaireButton(){
        saveQuestionnaire = new JButton("Save Questionnaire");
        
        saveQuestionnaire.addActionListener((ActionEvent e) -> {
           //todo: Create action for saving questionnaire.
            Question q = new Question();
            ArrayList questionList = new ArrayList();
            for (int i = 0; i < questions.size(); i++) {
                JPanel question = (JPanel)questions.get(i);
                for (int j = 0; j < question.getComponentCount(); j++) {
                    
                    if (question.getComponent(j).getName() == "question") {
                        JTextArea ta = (JTextArea)question.getComponent(j);
                        q.setDescription(ta.getText());
                    } else if (question.getComponent(j).getName() == "answer") {
                        JTextField tf = (JTextField)question.getComponent(j);
                        q.addAnswer(tf.getText(), true);
                    }
                }
                questionList.add(q);
            }
            Questionnaire questionnaire = new Questionnaire(questionList);
            
            try {
                FileOutputStream fileOut = new FileOutputStream("\\questionnaires");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(questionnaire);
                objectOut.close();
                System.out.println("Great succes in saving");
            } catch (Exception ex){
                System.out.println("well shit dident save" + ex);
            }
           
        });
        buttonPanel.add(saveQuestionnaire);
    }
    
    private void settupPanel(MainPage mf){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(mf.getHeight(), mf.getWidth()));
        
        headder = new JLabel("<html><div style='text-align: center;'>Create a Questionnaire</div></html>");
        headder.setPreferredSize(new Dimension(mf.getWidth()-20, 50));
        headder.setFont(new Font("Serif", Font.BOLD, 20));
        add(headder);
        
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(mf.getWidth() - 20, 50));
        
        add(buttonPanel);
        
        saveQuestionnaireButton();
        addQuestionButton(mf);
        mainMenuButton(mf);
        
        setVisible(true);
    }
    
}
