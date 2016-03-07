/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire;

import java.io.*;
import java.util.*;

public class accuracyChk {
    
    static int n,m;
    static double matchCount=0;
    static double misMatchCount=0;
    static double totalWord=0;
    String annotations[] = new String[2500];
    String groundTruth[] = new String[2500];
    public static void main(String args[]) throws IOException, Exception{
        
        File file1=new File("AnnotationsNew.txt");
        File file2=new File("givenAnnot.txt");
        
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File("Annotations2.txt")))));
        //BufferedReader reader1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File("givenAnnot.txt")))));
        Scanner scnr2 = new Scanner(file2);
        Scanner scnr1 = new Scanner(file1);
        String fLine = "";
        String fLine1 = "";
        int lineNumber = 1;
        accuracyChk ob = new accuracyChk();
        while (scnr1.hasNextLine() && lineNumber<873) {            
            
            if(lineNumber<874){
                for(int i=0; i<3; i++){
                    fLine = scnr1.nextLine();
                    fLine1 = scnr2.nextLine();
                }
            }
            
            fLine = fLine.trim();
            //System.out.println(fLine+(fLine.length()-1));
        
            fLine1 = fLine1.trim();
            //System.out.println(lineNumber);
            ob.lProc(fLine,fLine1,lineNumber);
            ob.match(lineNumber);
            lineNumber++;
            //System.out.println();
        }
            
        double accu = 0;
        accu = ((matchCount/totalWord)*100);
        System.out.println("Total number of words : "+totalWord);
        System.out.println("Matched tags number: "+matchCount);
        System.out.println("Non-matching number of tags : "+misMatchCount);
        System.out.println("Accuracy : "+accu);
        scnr1.close();
        //reader1.close();
    }
    
    public void lProc(String annot,String gt, int x){
        
        String s1[]=annot.split(" ");
        String s2[]=gt.split(" ");
        
        n=s1.length;
        totalWord+=s1.length;

        //System.out.println(n+" "+s2.length);
        if(s1.length==s2.length){
            for(int i=0;i<s1.length;i++){
                annotations[i]=s1[i];
                groundTruth[i]=s2[i];
            }
        
        }
        else
            System.out.println(x);
    
    }
    
    
    public void match(int x){
        
        //System.out.println(x+"\n");
        
        
            for(int i=0;i<n;i++){
                if(annotations[i].equals(groundTruth[i])){
                    matchCount++;
                    //System.out.println("Match");
                    //System.out.print(i+"\t"+annotations[i]+"\t"+groundTruth[i]+"\tMatch\t");
               }
                
                else{
                    misMatchCount++;
                    //System.out.println("Mis-match");
                    //System.out.print(i+"\t"+annotations[i]+"\t"+groundTruth[i]+"\tMis-Match\t");
                }
            }
                
             
            //System.out.println();
                    
        
    }
    
    
}
