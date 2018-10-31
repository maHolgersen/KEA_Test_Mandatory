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
public class QuestionTest {
    
    public QuestionTest() {
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
     * Test of removeAnswer method, of class Question.
     */
    @Test
    public void testRemoveAnswer_String() {
        System.out.println("removeAnswer");
        String answer = "";
        Question instance = new Question();
        instance.removeAnswer(answer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAnswer method, of class Question.
     */
    @Test
    public void testRemoveAnswer_int() {
        System.out.println("removeAnswer");
        int index = 0;
        Question instance = new Question();
        instance.removeAnswer(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAnswer method, of class Question.
     */
    @Test
    public void testAddAnswer() {
        System.out.println("addAnswer");
        String answer = "";
        boolean isCorrectAnswer = false;
        Question instance = new Question();
        instance.addAnswer(answer, isCorrectAnswer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoints method, of class Question.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        Question instance = new Question();
        int expResult = 0;
        int result = instance.getPoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCorrectAnswer method, of class Question.
     */
    @Test
    public void testGetCorrectAnswer() {
        System.out.println("getCorrectAnswer");
        Question instance = new Question();
        int expResult = 0;
        int result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswers method, of class Question.
     */
    @Test
    public void testGetAnswers() {
        System.out.println("getAnswers");
        Question instance = new Question();
        List expResult = null;
        List result = instance.getAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Question.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Question instance = new Question();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCorrectAnswer method, of class Question.
     */
    @Test
    public void testSetCorrectAnswer() {
        System.out.println("setCorrectAnswer");
        int correctAnswer = 0;
        Question instance = new Question();
        instance.setCorrectAnswer(correctAnswer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Question.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Question instance = new Question();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnswers method, of class Question.
     */
    @Test
    public void testSetAnswers() {
        System.out.println("setAnswers");
        List answers = null;
        Question instance = new Question();
        instance.setAnswers(answers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPoints method, of class Question.
     */
    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        int points = 0;
        Question instance = new Question();
        instance.setPoints(points);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
