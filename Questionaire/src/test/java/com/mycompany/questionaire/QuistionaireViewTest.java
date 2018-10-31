/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.awt.Panel;
import java.util.List;
import javax.swing.ButtonGroup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carst
 */
public class QuistionaireViewTest {
    
    public QuistionaireViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createQuesion method, of class QuistionaireView.
     */
    @Test
    public void testCreateQuesion() {
        System.out.println("createQuesion");
        Question question = null;
        Panel questionPnl = null;
        QuistionaireView instance = null;
        Panel expResult = null;
        Panel result = instance.createQuesion(question, questionPnl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedButton method, of class QuistionaireView.
     */
    @Test
    public void testGetSelectedButton() {
        System.out.println("getSelectedButton");
        ButtonGroup bg = null;
        QuistionaireView instance = null;
        String expResult = "";
        String result = instance.getSelectedButton(bg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAllAnswers method, of class QuistionaireView.
     */
    @Test
    public void testCheckAllAnswers() {
        System.out.println("checkAllAnswers");
        QuistionaireView instance = null;
        boolean expResult = false;
        boolean result = instance.checkAllAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnansweredQuestion method, of class QuistionaireView.
     */
    @Test
    public void testGetUnansweredQuestion() {
        System.out.println("getUnansweredQuestion");
        QuistionaireView instance = null;
        List expResult = null;
        List result = instance.getUnansweredQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of highLightUnansweredQuestions method, of class QuistionaireView.
     */
    @Test
    public void testHighLightUnansweredQuestions() {
        System.out.println("highLightUnansweredQuestions");
        List<ButtonGroup> bg = null;
        QuistionaireView instance = null;
        instance.highLightUnansweredQuestions(bg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
