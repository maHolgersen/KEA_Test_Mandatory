/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author carst
 */
public class MainPage extends JFrame{
    private JPanel cards;
    private JPanel mainCard;
    private JButton admin;
    private JButton guest;
    private JPanel buttonPanel;
    
    private CardLayout cl;
    
    public MainPage(int width, int height){
        setSize(width, height);
        setLayout(new FlowLayout());
                
        cards = new JPanel(new CardLayout());
        
        mainCard = new JPanel(new FlowLayout());
        mainCard.setPreferredSize(new Dimension(width, height));
                
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setPreferredSize(new Dimension(width, height * 80 / 100));
        
        cl = (CardLayout)cards.getLayout();
        
        JTextPane welcomeLabel;
        welcomeLabel = new JTextPane();
        welcomeLabel.setText("Welcome to questionaire.TEST please choose admin if you're to create or configure a questionaire"
                + "\nOtherwise choose guest if you are here to answer some questionaires!");
        welcomeLabel.setEditable(false);
        welcomeLabel.setBackground(getBackground());
        welcomeLabel.setPreferredSize(new Dimension(width / 2, height * 80 / 100));
        
        mainCard.add(welcomeLabel);
        mainCard.add(buttonPanel);       
        
        admin = createAdminButton();
        admin.setVisible(true);
        
        guest = createGuestButton();
        guest.setVisible(true);
        
        buttonPanel.add(guest);
        buttonPanel.add(admin);
        
        createCards();
        
        add(cards);
        buttonPanel.setVisible(true);
        setVisible(true);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    private void createCards(){
        cards.add(mainCard, "maincard");
        JPanel adView = new AdminView(getWidth(), getHeight(), this);
        JPanel createQuestionnaireView = new CreateQuestionnaireView(this);
        
        cards.add(adView, "admin");
        cards.add(createQuestionnaireView, "createquestionnaireview");
    }
    
    private JButton createAdminButton(){
        JButton button = new JButton("Admin");
        button.addActionListener((ActionEvent e) -> {
           //add action to change to AdminView 
            cl.show(cards, "admin");
            setVisible(true);
       
        });
        return button;
    }
    
    private JButton createGuestButton(){
        JButton button = new JButton("Guest");
        button.addActionListener((ActionEvent e) -> {
           //add action to change to guestView 
                    
        });
        
        return button;
    }

    public JPanel getCards(){
        return cards;
    }
    
    public CardLayout getCardLayout(){
        return cl;
    }
    
        
    
}
