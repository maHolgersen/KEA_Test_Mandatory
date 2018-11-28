/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.questionaire;

import com.mycompany.questionnaire.Question;
import com.mycompany.questionnaire.Questionnaire;
import java.util.ArrayList;
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
public class QuestionnaireTest {
    private Questionnaire questionnaire;
    public QuestionnaireTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String ans1 = "ans1";
        String ans2 = "ans2";
        String ans3 = "ans3";
        String ans4 = "ans4";
        ArrayList answers = new ArrayList();
        
        answers.add(ans1);
        answers.add(ans2);
        answers.add(ans3);
        answers.add(ans4);
        
        Question q1 = new Question(answers, "q1", 1, 150);
        Question q2 = new Question(answers, "q2", 1, 100);
        Question q3 = new Question(answers, "q3", 1, 200);
        Question q4 = new Question(answers, "q4", 1, 100);
        
        ArrayList questions = new ArrayList();
        
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);

        questionnaire = new Questionnaire(questions);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalPoints method, of class Questionnaire.
     */
    @Test
    public void testGetTotalPoints() {
        System.out.println("getTotalPoints");
        Questionnaire instance = questionnaire;
        int expResult = 550;
        int result = instance.getTotalPoints();
        assertEquals(expResult, result);
        
    }
    
}
