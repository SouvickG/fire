/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire;

import java.io.*;
import java.util.*;

public class CRFtoAnnotation {
 
    String annot[] = new String[2500];
    
    public static void main(String args[]) throws IOException{
        
        CRFtoAnnotation ob = new CRFtoAnnotation();
        File text = new File("final op\\output.txt");
        Scanner scnr = new Scanner(text);
        String fLine="";
        int lineNumber=0;
        int sentenceCounter=1;
        ob.start();
        while(scnr.hasNextLine()){
        
            fLine=scnr.nextLine();
            if(!fLine.equals(".	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	O") && !fLine.equals(null)){
                String word[] = fLine.split("\\t");
                int len = word.length;
                ob.annot[lineNumber] = word[len-1];
                lineNumber++;
            }
            
            else if(fLine.equals(".	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	O")){
                
                ob.writeFile(sentenceCounter,lineNumber);
                lineNumber=0;
                sentenceCounter++;
            }
        }
        ob.end();
    }
    
    public void writeFile(int counter,int len) throws IOException{
        
        File file = new File("final op\\AnnotationTest.txt");
        
        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("\t<utterance id=\""+counter+"\">\n\t\t");
        for(int i=0;i<len;i++){
            if(annot[i]!=null){
                bufferWritter.write(annot[i].trim()+" ");
            }
        }
        bufferWritter.write("\n\t</utterance>\n");
        bufferWritter.close();
    }
    
    public void start() throws IOException{
        File file = new File("final op\\AnnotationTest.txt");
        
        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("<data>\n");
        bufferWritter.close();
    }
    
    public void end() throws IOException{
        File file = new File("final op\\AnnotationTest.txt");
        
        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("</data>");
        bufferWritter.close();
    }
}
