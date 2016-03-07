/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class countNumber {
    public int numOfLines(File f) throws IOException{
        
        //File f1 = new File("citationScore1.txt");
        //File f2 = new File("citationScore2.txt");
        
        Scanner scnr1 = new Scanner(f);
        //Scanner scnr2 = new Scanner(f2);
        int lineNumber1=0;
        //int lineNumber2=0;
        //double bucket=0;
        //System.out.println("hello");
        String fLine="";
        while(scnr1.hasNextLine()){
            fLine=scnr1.nextLine();
            lineNumber1++;
        }
        return lineNumber1;
        /*while(scnr2.hasNextLine()){
            fLine=scnr2.nextLine();
            lineNumber2++;
        }*/
        
    }
}
