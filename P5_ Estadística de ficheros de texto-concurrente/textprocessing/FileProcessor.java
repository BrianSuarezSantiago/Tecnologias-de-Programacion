package textprocessing;
import java.util.*;
public class FileProcessor extends Thread{
    private FileContents fc;
    private WordFrequencies wf;
    
    public FileProcessor(FileContents fc, WordFrequencies wf){
        this.fc = fc;
        this.wf = wf;
    }
    
    //Empleamos el pattern para hacer una búsqueda en concreto de caracteres
    @Override
    public void run(){
        Map<String,Integer> frecuencies = new HashMap<String,Integer>();
        String contents = "";
        String pattern = "[^a-zA-Z0-9ñÑÀ-ÿ]+";
        String[] words;
        while((contents = fc.getContents()) != null){
            words = contents.split(pattern);
            for(String word : words) {
                if(frecuencies.containsKey(word)){
                    frecuencies.put(word, frecuencies.get(word) + 1);
                }else{
                    frecuencies.put(word, 1);
                }
            }
            this.wf.addFrequencies(frecuencies);
            frecuencies.clear();
        }
    }
}
