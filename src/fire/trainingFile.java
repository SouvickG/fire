/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fire;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import java.util.*;
import java.io.*;

public class trainingFile {
    
    int n;
    String annotations[] = new String[2500];
    String words[] = new String[2500];
    int cap1[] = new int[2500];
    int cap2[] = new int[2500];
    int cap3[] = new int[2500];
    
    String next3Wrd[] = new String[2500];
    String prev3Wrd[] = new String[2500];
    String currentWrd[] = new String[2500];
    int length[] = new int[2500];
    
    int hashPres[] = new int[2500];
    int atPres[] = new int[2500];
    int linkPres[] = new int[2500];
    int isPunc[] = new int[2500];
    int isSmiley[] = new int[2500];
    
    int wrdHasSym[] = new int[2500];
    int wrdHasDig[] = new int[2500];
    int isNum[] = new int[2500];
    
    int isEnglish[] = new int[2500];
    int isBengali[] = new int[2500];
    int isGujrati[] = new int[2500];
    int isHindi[] = new int[2500];
    int isKanada[] = new int[2500];
    int isMalayalam[] = new int[2500];
    int isMarathi[] = new int[2500];
    int isTamil[] = new int[2500];
    int isTelegu[] = new int[2500];
    int isNE[] = new int[2500];
    int isNEStan[] = new int[2500];
    
    public static void main(String args[]) throws IOException, FileNotFoundException, Exception{
        
        trainingFile ob = new trainingFile();
        
        File text = new File("Input1.txt");
        File annot = new File("Annotation1.txt");
        Scanner scr = new Scanner(text);
        Scanner scnr1 = new Scanner(annot);
        String fLine = "";
        String fLine1 = "";
        int lineNumber = 1;
        while(scr.hasNextLine()){
            
            
            for(int i=0; i<3; i++ ){
                fLine = scr.nextLine();
                
                fLine1 = scnr1.nextLine();
            }
            
            /*for(int i=0;i<500;i++){
              
                ob.cap1[i]=0;
                ob.cap2[i]=0;
                ob.cap3[i]=0;
                ob.hashPres[i]=0;
                ob.atPres[i]=0;
                ob.linkPres[i]=0;
                
                ob.isEnglish[i]=0;
                ob.isBengali[i]=0;
                ob.isHindi[i]=0;
                ob.isGujrati[i]=0;
                ob.isMalayalam[i]=0;
                ob.isTamil[i]=0;
                ob.isTelegu[i]=0;
                ob.isMarathi[i]=0;
                ob.isKanada[i]=0;
                ob.isNE[i]=0;
                ob.isNEStan[i]=0;
                
            }*/
            if(lineNumber>2146){
            ob.lProc(fLine,fLine1);
            ob.feat1();
            ob.feat2();
            ob.feat3();
            ob.feat4();
            ob.feat5();
            ob.feat6();
            ob.feat7();
            ob.feat8();
            ob.feat9();
            ob.feat10();
            ob.feat11();
            ob.feat12();
            ob.feat13();
            ob.feat14();
            ob.feat15();
            ob.feat16();
            ob.feat17();
            ob.feat18();
            ob.feat19();
            ob.feat20();
            ob.feat21();
            ob.feat22();
            ob.feat23();
            ob.feat24();
            ob.feat25();
            ob.NEdetection();
            
            /*for(int i=0;i<ob.n;i++){
                System.out.println(ob.hashPres[i]);
            }*/
            ob.writeFile();
            }
            lineNumber++;
        }
    }
    
    
    
    public void lProc(String line, String tags){
        
                 
         StringTokenizer st = new StringTokenizer(line);
         StringTokenizer st1 = new StringTokenizer(tags);
         n = st.countTokens();
         //System.out.println(n);
         int i=0;
         while(st.hasMoreTokens()){
            
             words[i] = st.nextToken();
             annotations[i] = st1.nextToken();
             i++;
             
         }
    
    }
    
    
    public void feat1(){
        
        for(int i=0;i<n;i++){
            
            char c = words[i].charAt(0);
            //System.out.println(c);
            if(c>64 && c<91){
                cap1[i] = 1;
            }
            else
                cap1[i]=0;
        }
    }
    
    public void feat2(){
        
        for(int i=0;i<n;i++){
            
            String s = words[i];
            //System.out.println(s);
            int count = s.length();
            
            for(int j=0;j<count;j++){
                
                char c = s.charAt(j);
                if(c>64 && c<91){
                    cap2[i]=1;
                    break;
                }
                else
                    cap2[i]=0;
            }
        }
        
    }
    
    public void feat3(){
        
        for(int i=0;i<n;i++){
            
            String s = words[i];
            //System.out.println(s);
            int count = s.length();
            
            for(int j=0;j<count;j++){
                
                char c = s.charAt(j);
                if(c>96 && c<123){
                    cap3[i]=0;
                    break;
                }
                else
                    cap3[i]=1;
            }
        }
    }
    
    public void feat4(){
        
        for(int i=0;i<n;i++){
            
            if(i<n-3){
                next3Wrd[i] = words[i+1]+"\t"+words[i+2]+"\t"+words[i+3];
            }
            else if(i==n-3){
                next3Wrd[i] = words[i+1]+"\t"+words[i+2]+"\t"+null;
            }
            else if(i==n-2){
                next3Wrd[i] = words[i+1]+"\t"+null+"\t"+null;
            }
            else if(i==n-1){
                next3Wrd[i]=null+"\t"+null+"\t"+null+"\t";
            }
        }
    }
    
    public void feat5(){
        
        for(int i=0;i<n;i++){
            
            if(i==0){
                prev3Wrd[i]=null+"\t"+null+"\t"+null;
            }
            else if(i==1){
                prev3Wrd[i]=null+"\t"+null+"\t"+words[i-1];
            }
            else if(i==2){
                prev3Wrd[i]=null+"\t"+words[i-2]+"\t"+words[i-1];
            }
            else
                prev3Wrd[i]=words[i-3]+"\t"+words[i-2]+"\t"+words[i-1];
        }
    }
    
    public void feat6(){
        
        for(int i=0;i<n;i++){
            currentWrd[i]=words[i];
        }
        
    }
    
    public void feat7(){
        for(int i=0;i<n;i++){
            length[i]=words[i].length();
        }
    }
    
    public void feat8(){
        
        for(int i=0;i<n;i++){
            String s = words[i];
            if(s.startsWith("#"))
                hashPres[i]=1;
            else
                hashPres[i]=0;
        }
    }
    
    public void feat9(){
        
        for(int i=0;i<n;i++){
            String s = words[i];
            if(s.startsWith("@"))
                atPres[i]=1;
            else
                atPres[i]=0;
        }
    }
    
    public void feat10(){
        
        for(int i=0;i<n;i++){
            String s = words[i];
            if(s.startsWith("http"))
                linkPres[i]=1;
            else
                linkPres[i]=0;
        }
    }
    
    public void feat11(){
        for(int i=0;i<n;i++){
            String s = words[i];
            int len = s.length();
            if(len==1 &&(s.equals(".") || s.equals(",") || s.equals(";") || s.equals(":") || s.equals("?") || s.equals("!") || s.equals("'") || s.equals("/") || s.equals("\\") || s.equals("-"))) {
                
                isPunc[i]=1;
            }
            else
                isPunc[i]=0;
        }
    }
    
    public void feat12() throws FileNotFoundException{
        
        File list = new File("smileyList.txt");
        Scanner scnr = new Scanner(list);
        //int i=0;
        String smiley;
        for(int i=0;i<n;i++){
            
            while(scnr.hasNextLine()){
                smiley = scnr.nextLine();
                if(words[i].equals(smiley)){
                    isSmiley[i]=1;
                }
                else
                    isSmiley[i]=0;
            }
        }
        
    }
    
    public void feat13(){
        
        for(int i=0;i<n;i++){
            
            String s = words[i];
            int len = s.length();
            if(len>1){
                for(int j = 0;j<len;j++){
                    char c = s.charAt(j);
                
                    if((c=='.' || c==',' || c==';' || c==':' || c=='?' || c=='!' || c=='\'' || c=='/' || c=='\\' || c=='-')){
                    
                        wrdHasSym[i]=1;
                        break;
                    }
                    else
                        wrdHasSym[i]=0;
                }
            }
            else wrdHasSym[i]=0;
        }
    }
    
    public void feat14(){
        
        for(int i=0;i<n;i++){
            
            String s = words[i];
            int len = s.length();
            
            for(int j = 0;j<len;j++){
                char c = s.charAt(j);
                
                if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                    
                    wrdHasDig[i]=1;
                    break;
                }
                else
                    wrdHasDig[i]=0;
            }
        }
    }
    
    public void feat15(){
        
        for(int i=0;i<n;i++){
            
            String s = words[i];
            int len = s.length();
            
            for(int j = 0;j<len;j++){
                char c = s.charAt(j);
                
                if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                    isNum[i]=1;
                    
                }
                else{
                    isNum[i]=0;
                    break;
                }
            }
        }
        
    }
    
    public void feat16() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("eng_training_words",words[i].toLowerCase())==true || isFound("english_words",words[i].toLowerCase())==true || isFound("engXtra",words[i].toLowerCase())==true)
                isEnglish[i]=1;
            else if(isFound("eng_training_words",words[i].toLowerCase())==false)
                isEnglish[i]=0;
            
            /*if(isFound("english_words",words[i].toLowerCase())==true)
                isEnglish[i]=1;
            else if(isFound("english_words",words[i].toLowerCase())==false)
                isEnglish[i]=0;*/
        }
    }
    
    public void feat17() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("beng_training_words",words[i].toLowerCase())==true || isFound("bengali_words",words[i].toLowerCase())==true || isFound("bengXtra",words[i].toLowerCase())==true )
                isBengali[i]=1;
            else if(isFound("beng_training_words",words[i].toLowerCase())==false)
                isBengali[i]=0;
            
            /*if(isFound("bengali_words",words[i].toLowerCase())==true)
                isBengali[i]=1;
            else if(isFound("bengali_words",words[i].toLowerCase())==false)
                isBengali[i]=0;*/
        }
    }
    
    public void feat18() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("guj_training_words",words[i].toLowerCase())==true || isFound("gujrati_words",words[i].toLowerCase())==true || isFound("gujXtra",words[i].toLowerCase())==true)
                isGujrati[i]=1;
            else if(isFound("guj_training_words",words[i].toLowerCase())==false)
                isGujrati[i]=0;
            
            /*if(isFound("gujrati_words",words[i].toLowerCase())==true)
                isGujrati[i]=1;
            else if(isFound("gujrati_words",words[i].toLowerCase())==false)
                isGujrati[i]=0;*/
        }
    }
    
    public void feat19() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("hindi_training_words",words[i].toLowerCase())==true || isFound("hindi_words",words[i].toLowerCase())==true || isFound("hindiXtra",words[i].toLowerCase())==true)
                isHindi[i]=1;
            else if(isFound("hindi_training_words",words[i].toLowerCase())==false)
                isHindi[i]=0;
            
            /*if(isFound("hindi_words",words[i].toLowerCase())==true)
                isHindi[i]=1;
            else if(isFound("hindi_words",words[i].toLowerCase())==false)
                isHindi[i]=0;*/
        }
    }
    
    public void feat20() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("kan_training_words",words[i].toLowerCase())==true || isFound("kanada_words",words[i].toLowerCase())==true)
                isKanada[i]=1;
            else if(isFound("kan_training_words",words[i].toLowerCase())==false)
                isKanada[i]=0;
            
            /*if(isFound("kanada_words",words[i].toLowerCase())==true)
                isKanada[i]=1;
            else if(isFound("kanada_words",words[i].toLowerCase())==false)
                isKanada[i]=0;*/
        }
    }
    
    public void feat21() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("mala_training_words",words[i].toLowerCase())==true || isFound("malayalam_words",words[i].toLowerCase())==true)
                isMalayalam[i]=1;
            else if(isFound("mala_training_words",words[i].toLowerCase())==false)
                isMalayalam[i]=0;
            
            /*if(isFound("malayalam_words",words[i].toLowerCase())==true)
                isMalayalam[i]=1;
            else if(isFound("malayalam_words",words[i].toLowerCase())==false)
                isMalayalam[i]=0;*/
        }
    }
    
    public void feat22() throws FileNotFoundException {
        
        
        for(int i=0;i<n;i++){
            if(isFound("mara_training_words",words[i].toLowerCase())==true || isFound("marathi_words",words[i].toLowerCase())==true)
                isMarathi[i]=1;
            else if(isFound("mara_training_words",words[i].toLowerCase())==false)
                isMarathi[i]=0;
            
            /*if(isFound("marathi_words",words[i].toLowerCase())==true)
                isMarathi[i]=1;
            else if(isFound("marathi_words",words[i].toLowerCase())==false)
                isMarathi[i]=0;*/
        }
    }
    
    public void feat23() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("tam_training_words",words[i].toLowerCase())==true || isFound("tamil_words",words[i].toLowerCase())==true)
                isTamil[i]=1;
            else if(isFound("tam_training_words",words[i].toLowerCase())==false)
                isTamil[i]=0;
            
            /*if(isFound("tamil_words",words[i].toLowerCase())==true)
                isTamil[i]=1;
            else if(isFound("tamil_words",words[i].toLowerCase())==false)
                isTamil[i]=0;*/
        }
        
    }
    
    public void feat24() throws FileNotFoundException{
        
        for(int i=0;i<n;i++){
            if(isFound("tel_training_words",words[i].toLowerCase())==true || isFound("telegu_words",words[i].toLowerCase())==true)
                isTelegu[i]=1;
            else if(isFound("tel_training_words",words[i].toLowerCase())==false)
                isTelegu[i]=0;
            
            /*if(isFound("telegu_words",words[i].toLowerCase())==true)
                isTelegu[i]=1;
            else if(isFound("telegu_words",words[i].toLowerCase())==false)
                isTelegu[i]=0;*/
        }
    }
    
    public void feat25() throws Exception{
        
         for(int i=0;i<n;i++){
            if(isFound("NE_list",words[i].toLowerCase())==true)
                isNE[i]=1;
            else if(isFound("NE_list",words[i].toLowerCase())==false)
                isNE[i]=0;
            
         }
        
    }
    
    public void NEdetection() throws Exception {
        
        String serializedClassifier = "C:\\Users\\DIPANAKR\\Desktop\\Satanu\\fire\\stanford-ner-2015-04-20\\stanford-ner-2015-04-20\\classifiers\\english.all.3class.distsim.crf.ser.gz";
        AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serializedClassifier);
        
        String line="";
        for(int i =0;i<n;i++){
            line=line+words[i]+" ";
        }
        
        String str = classifier.classifyToString(line);
        String wrd[] = str.split(" ");
        
        for(int i = 0;i<wrd.length;i++){
            
            if(wrd[i].endsWith("/O")){
                isNEStan[i]=0;
            }
            else if(!wrd[i].endsWith("/O")){
                System.out.println(wrd[i]);
                isNEStan[i]=1;
            }
        }
        
    }
    
    public boolean isFound(String fileName, String word) throws FileNotFoundException{
        
        File srch = new File(fileName+".txt");
        Scanner scnr = new Scanner(srch);
        String dicWord;
        while(scnr.hasNextLine()){
            dicWord = scnr.nextLine();
            if(word.equals(dicWord))
                return true;
        }
        return false;
    }
    
    public void writeFile() throws FileNotFoundException, IOException{
            
         File file = new File("CRF_Training_after2035.txt");
         
         FileWriter fileWritter = new FileWriter(file.getName(),true);
    	 BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
         
         for(int i=0;i<n;i++){
             bufferWritter.write(words[i]+"\t"+cap1[i]+"\t"+cap2[i]+"\t"+cap3[i]+"\t"+next3Wrd[i]+"\t"+prev3Wrd[i]+"\t"+currentWrd[i]+"\t"+length[i]+"\t"+hashPres[i]+"\t"+atPres[i]+"\t"+linkPres[i]+"\t"+isPunc[i]+"\t"+isSmiley[i]+"\t"+wrdHasSym[i]+"\t"+wrdHasDig[i]+"\t"+isNum[i]+"\t"+isEnglish[i]+"\t"+isBengali[i]+"\t"+isHindi[i]+"\t"+isGujrati[i]+"\t"+isMarathi[i]+"\t"+isMalayalam[i]+"\t"+isKanada[i]+"\t"+isTamil[i]+"\t"+isTelegu[i]+"\t"+isNE[i]+"\t"+isNEStan[i]+"\t"+annotations[i]+"\n");
             //bufferWritter.write(word[i]+"\t"+func1[i]+"\t"+func2[i]+"\t"+func3[i]+"\t"+func4[i]+"\t"+func5[i]+"\t"+prevWord[i]+"\t"+nextWord[i]+"\t"+"."+"\n" );
             }
            bufferWritter.write(".	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.   O\n" );
            bufferWritter.write("\n");
            bufferWritter.close();
           
     }
    
    
}
