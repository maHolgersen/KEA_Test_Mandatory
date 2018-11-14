/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author carst
 */
public class AdminView extends JPanel{
    private JButton createQuestionaire;
    
    public AdminView(int x, int y){
        createQuestionaire = new JButton("Create Questionaire");
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(x, y));
        add(createQuestionaire);
        setVisible(true);
    }
    
}
