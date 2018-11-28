/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionnaire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 *
 * @author carst
 */
public final class QuestionnaireView extends JPanel{
    private Questionnaire questionnaire;
    private JButton submit;
    private JButton mainMenu;
    private List<ButtonGroup> radioGrps;
    private Label score;
    private JButton loadQuestionnaire;
    private JComboBox questionnaireList;
    
    private final static String FILE_PATH = System.getProperty("user.dir");
    
    
    public QuestionnaireView(MainPage mf){
        setupPanel(mf);
    }
    
    private void setupPanel(MainPage mf){
        radioGrps = new ArrayList();
        score = new Label();
        questionnaireList = new JComboBox();
        setLayout(new FlowLayout());
        
        createSubmitButton();
        mainMenuButton(mf);
        loadQuestionnaireButton(mf);
        loadQuestionnaires();
        
        add(this.score);
        add(questionnaireList);
        
        setVisible(true);
    }
    
    public void loadQuestionnaires(){
        try {
            for (File listFile : new File(FILE_PATH + "\\questionnaires").listFiles()) {
                questionnaireList.addItem(listFile.getName());
            }
        
        } catch(Exception ex){
            System.out.println("well shit dident load: " + ex);
        }
    }
    
    private void createSubmitButton(){
        submit = new JButton("Submit");
        submit.addActionListener((ActionEvent e) -> {
            int points = 0;
            
            for (int i = 0; i < questionnaire.getQuestions().size(); i++) {
                Question q = (Question)questionnaire.getQuestions().get(i);
                ButtonGroup bg = (ButtonGroup)radioGrps.get(i);
                if (q.getAnswers().get(q.getCorrectAnswer()) == getSelectedButton(bg)) {
                    points += q.getPoints();
                }
            }
            if (checkAllAnswers()) {
                int totalScore = this.questionnaire.getTotalPoints();
                int pointPerc = points*100/this.questionnaire.getTotalPoints();
                
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
        });
        add(submit);
    }
    
    private void loadQuestionnaireButton(MainPage mf){
        loadQuestionnaire = new JButton("Load questionnaire");
        loadQuestionnaire.addActionListener((ActionEvent e) -> {
            //TODO load a questionnaire
            try {
                System.out.println("" + questionnaireList.getSelectedItem());
                FileInputStream fis = new FileInputStream(FILE_PATH + "\\questionnaires\\" + questionnaireList.getSelectedItem());
                ObjectInputStream ois = new ObjectInputStream(fis);
                questionnaire = (Questionnaire) ois.readObject();
                ois.close();
                fis.close();
            } catch(Exception ex){
                System.out.println("well shit dident load! " + ex);
            }
            
            for (int i = 0; i < questionnaire.getQuestions().size(); i++) {
                Panel questionPnl = new Panel(new FlowLayout());
                questionPnl.setPreferredSize(new Dimension(200, 200));
                add(createQuesion((Question)questionnaire.getQuestions().get(i), questionPnl));
                mf.setVisible(true);
            }
        });
        
        add(loadQuestionnaire);
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
    
    private void mainMenuButton(MainPage mf){
        mainMenu = new JButton("Main menu");
        
        mainMenu.addActionListener((ActionEvent e) -> {
           //action to show the main menu card
            mf.getCardLayout().show(mf.getCards(), "maincard");
        });
        add(mainMenu);
    }
}
