
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kea.control.FileController;
import com.mycompany.questionnaire.Question;
import com.mycompany.questionnaire.Questionnaire;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carst
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        Questionnaire q = new Questionnaire(questions);

        Gson builder = new GsonBuilder().create();
        String questionnaire = builder.toJson(q);
        
        System.out.println("json string: " + q);
//        
        FileController.saveQuestionnaire(q, "test1234");
        FileController.saveQuestionnaire(q, "test12345");
        FileController.saveQuestionnaire(q, "test123456");

          
    }
    
}
