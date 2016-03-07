package fire;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.*;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.sequences.DocumentReaderAndWriter;
import edu.stanford.nlp.util.Triple;

import java.util.List;

public class NER{

    public void NEdetection(int[] isNEStan) throws Exception {
        
        String serializedClassifier = "C:\\Users\\DIPANAKR\\Desktop\\Satanu\\fire\\stanford-ner-2015-04-20\\stanford-ner-2015-04-20\\classifiers\\english.all.3class.distsim.crf.ser.gz";
        AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serializedClassifier);
        
        
        
        String line="";
        int n=10;
        for(int i =0;i<n;i++){
            String[] words = null;
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
}
