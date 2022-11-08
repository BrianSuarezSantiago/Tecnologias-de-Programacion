package textprocessing;
import java.util.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FileNames {
    //Inicializamos el valor
    private Queue<String> queue = new ConcurrentLinkedQueue<String>();
    private boolean noMoreOn = false;
    
    public synchronized void addName(String fileName) {
        queue.add(fileName);
        notifyAll();
    }
    
    /*Cogemos el nombre de los archivos, en caso de existir dichos archivos y 
    no estar activo el noMoreOn, espera a recibir nuevos*/
    public synchronized String getName(){
        
        while(queue.isEmpty()){
            if(noMoreOn == true){
                return null;
            }
            try{
                
                wait();
            }catch(Exception e){
                System.out.println("Espera sobrepasada.");
            }
        }
        
        return queue.poll();
        
    }
    
    public synchronized void noMoreNames() {
        noMoreOn = true;

        notifyAll();
    }
}