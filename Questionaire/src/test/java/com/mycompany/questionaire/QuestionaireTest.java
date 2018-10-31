/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import java.util.List;
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
public class QuestionaireTest {
    
    public QuestionaireTest() {
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
     * Test of getTotalPoints method, of class Questionaire.
     */
    @Test
    public void testGetTotalPoints() {
        System.out.println("getTotalPoints");
        Questionaire instance = new Questionaire();
        int expResult = 0;
        int result = instance.getTotalPoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuestions method, of class Questionaire.
     */
    @Test
    public void testSetQuestions() {
        System.out.println("setQuestions");
        List questions = null;
        Questionaire instance = new Questionaire();
        instance.setQuestions(questions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestions method, of class Questionaire.
     */
    @Test
    public void testGetQuestions() {
        System.out.println("getQuestions");
        Questionaire instance = new Questionaire();
        List expResult = null;
        List result = instance.getQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
