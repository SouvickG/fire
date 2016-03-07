/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire;

import java.io.*; 

public class doscmd 
{ 
public static void main(String args[]) throws IOException 
{ 
try 
{ 
Process p=Runtime.getRuntime().exec("cmd /c dir"); 
Process p1=Runtime.getRuntime().exec("cmd /c cd C:\\Users\\DIPANAKR\\Desktop\\Satanu\\ && dir");
Process p2=Runtime.getRuntime().exec("/c dir");
p.waitFor();
p1.waitFor();
BufferedReader reader=new BufferedReader(new InputStreamReader(p1.getInputStream())); 
String line=reader.readLine(); 
while(line!=null) 
{ 
System.out.println(line); 
line=reader.readLine(); 
} 

} 
catch(IOException e1) { System.out.println("error1");} 
catch(InterruptedException e2) {System.out.println("error2");} 

System.out.println("Done"); 
} 
} 
