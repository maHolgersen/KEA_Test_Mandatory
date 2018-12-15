/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kea.control;

import com.mycompany.questionnaire.Questionnaire;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author carst
 */
public class FileController {
    
    private final static String FILE_PATH =  "E:Git\\KEA_Test_Mandatory\\QuestionaireWebService";
    
    public static Questionnaire getQuestionnaire(String questionnaireName){
        Questionnaire q = null;
        try {
                System.out.println(FILE_PATH + "\\questionnaires\\" + questionnaireName);
                FileInputStream fis = new FileInputStream(FILE_PATH + "\\questionnaires\\" + questionnaireName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                q = (Questionnaire) ois.readObject();
                ois.close();
                fis.close();
            } catch(IOException | ClassNotFoundException ex){
                System.out.println("well shit dident load! " + ex );
            }
        return q;
    }
    
    public static void saveQuestionnaire(Questionnaire q, String qName){
        try {
                FileOutputStream fileOut = new FileOutputStream(FILE_PATH + "\\questionnaires\\" + qName);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(q);
                objectOut.close();
                System.out.println("Great succes in saving");
            } catch (Exception ex){
                System.out.println("well shit dident save" + ex);
            }
    }
    
    public static List getALlQuestionnaires(){
        List qList = new ArrayList();
        try {
            for (File listFile : new File(FILE_PATH + "\\questionnaires").listFiles()) {
                System.out.println(listFile.getCanonicalPath());
                System.out.println(listFile.getAbsolutePath());
                System.out.println(listFile.getPath());
                qList.add(listFile.getName());
            }
        
        } catch(Exception ex){
            System.out.println("well shit dident load! " + ex);
        }
        
        return qList;
    }
}
