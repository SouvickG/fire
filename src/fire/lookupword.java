/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fire;

/**
 *
 * @author Satanu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class lookupword {
    
    public static void main(String args[]) throws IOException, FileNotFoundException{
        
        File text = new File("telegu.txt");
        Scanner scnr = new Scanner(text);
       lookupword ob = new lookupword();
        
        while(scnr.hasNextLine()){
            String fLine = scnr.nextLine();
            
            String eng_word="";
            //String eng_word="";
            
            if(!fLine.isEmpty()){
                
                int length = fLine.length();
                for(int i=0;i<length;i++){
                
                    if((fLine.charAt(i) > 96 && fLine.charAt(i) < 123))
                        eng_word+= fLine.charAt(i);
                    //else if((fLine.charAt(i) > 96) && (fLine.charAt(i) < 123))
                        //eng_word += fLine.charAt(i);
               
                }
                if(eng_word != "")
                    ob.writeToFile(eng_word);
            }
            
            
        }
        
    }
    
    public void writeToFile(String word1) throws IOException, FileNotFoundException{
        
        File file = new File("telegu_words.txt");
         
        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
         
        word1.trim();
         //word2.trim();
         
        bufferWritter.write(word1);
        bufferWritter.write("\n");
        bufferWritter.close();
    }
}
