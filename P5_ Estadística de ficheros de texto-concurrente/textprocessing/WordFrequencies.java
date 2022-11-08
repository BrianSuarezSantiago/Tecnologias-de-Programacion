package textprocessing;
import java.util.Map;
import java.util.HashMap;

public class WordFrequencies {
    private HashMap<String,Integer> archivador = new HashMap<String, Integer>();
    
    /*Hacemos la búsqueda de las claves(palabras) y valores(apariciones de las 
    mismas), además de un for each para recorrer cada palabra*/
    public synchronized void addFrequencies(Map<String,Integer> f){
        for(String word: f.keySet()){
            if(archivador.get(word) != null){
                archivador.put(word, f.get(word) + archivador.get(word));
            }else{
                archivador.put(word, f.get(word));
            }
        }
    }
    
    public Map<String,Integer> getFrequencies(){
        return new HashMap<String,Integer>(archivador);
    }
}
