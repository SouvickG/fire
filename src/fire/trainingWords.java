/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fire;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Satanu
 */
public class trainingWords {
    
    String words[] = new String[2500];
    String tags[] = new String[2500];
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File text = new File("Input1.txt");
        Scanner scnr = new Scanner(text);
        File text1 = new File("Annotation1.txt");
        Scanner scnr1 = new Scanner(text1);
        trainingWords ob = new trainingWords();
        int lineNumber = 1;
        while(scnr.hasNextLine()){
            
            for(int i= 0; i<500;i++){
                ob.words[i]=null;
                ob.tags[i]=null;
            }
            String fLine="";
            String fLine1="";
            for(int i=0; i<3; i++ ){
                fLine = scnr.nextLine();
                fLine=fLine.trim();
                fLine1 = scnr1.nextLine();
                fLine1=fLine1.trim();
            }
            String wrd[] = fLine.split(" ");
            String wrd1[] = fLine1.split(" ");
            //System.out.println(wrd1.length);
            
            //System.out.println();
            
            System.out.println(lineNumber);
            System.out.println(wrd1.length+" "+wrd.length);
            lineNumber++;
            for(int i=0; i<wrd.length;i++){
                //System.out.print(wrd[i]);
                //System.out.println();
                //System.out.println(wrd1[i]);
                
                ob.words[i]=wrd[i];
                ob.tags[i]=wrd1[i];
            }
            
            ob.langDet();
        }
        
     
    }
    
    public void langDet() throws IOException{
        
        for(int i=0;i<500;i++){
            if(words[i]!=null){
                

                words[i]=words[i].trim();
                tags[i]=tags[i].trim();
                //System.out.println(words[i]+" "+tags[i]);
                if(tags[i].equals("en")){
                    
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"eng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"eng_training_words")==false){
                        System.out.println(words[i]+"\tnot found");
                        File file = new File("eng_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                    
                }
                if(tags[i].equals("bn")){
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"beng_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("beng_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                else if(tags[i].equals("hi")){
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"hindi_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("hindi_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                else if(tags[i].equals("gu")){
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"guj_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("guj_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                else if(tags[i].equals("kn")){
                    words[i]=words[i].toLowerCase();
                    System.out.println(words[i]);
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"kan_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("kan_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                        System.out.println(words[i]);
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                else if(tags[i].equals("ml")){
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"mala_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("mala_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                else if(tags[i].equals("mr")){
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"mara_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("mara_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                else if(tags[i].equals("ta")){
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"tam_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("tam_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                else if(tags[i].equals("te")){
                    words[i]=words[i].toLowerCase();
                    //if(foundWord(words[i],"beng_training_words")==true)
                        //System.out.println(words[i]+"\tFound");
                    if(foundWord(words[i],"tel_training_words")==false){
                        //System.out.println(words[i]+"\tnot found");
                        File file = new File("tel_training_words.txt");
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    }
                }
                
                else if(tags[i].equals("NE")){
                    words[i]=words[i].toLowerCase();
                    if(foundWord(words[i],"NE_list")==false){
                        File file = new File("NE_list.txt");
                        
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                    
                        bufferWritter.write(words[i]);
                        bufferWritter.write("\n");
                        bufferWritter.close();
                    
                    }
                }
            }
        }
    }
    
    public boolean foundWord(String word, String file) throws FileNotFoundException, IOException{
        
        File srchF = new File(file+".txt");
        Scanner srch = new Scanner(srchF);
        int flag=-1;
        while(srch.hasNextLine()){
            String line = srch.nextLine();
            if(word.equals(line)){
                flag = 1;
                break;
            }
            else
                flag = 0;
        }
        if(flag == 1)
            return true;
        else
            return false;
        //return false;
        
    }
}
