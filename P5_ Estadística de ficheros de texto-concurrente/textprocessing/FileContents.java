package textprocessing;
import java.util.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public class FileContents {
    private Queue<String> queue = new ConcurrentLinkedQueue<String>();
    private int registerCount = 0;
    private boolean closed = false;
    private int maxFiles;
    private int maxChars;
    private int charLength = 0;
    
    public FileContents(int maxFiles, int maxChars) {
        this.maxFiles = maxFiles;
        this.maxChars = maxChars;
    }
    
    //Creamos las funciones para registrar la escritura
    public synchronized void registerWriter() {
        registerCount += 1;
    }
    
    public synchronized void unregisterWriter() {
        registerCount -= 1;
        if(registerCount == 0){
            closed = true;
            notifyAll();
        }
    }
    
    //Añadimos contenido mientras se cumplan las condiciones
    public synchronized void addContents(String contents) {
        if(closed == false){
            while((maxFiles <= queue.size() || maxChars <= charLength + 
            contents.length()) && queue.isEmpty() == false){
                try{
                    wait();
                    
                }catch(Exception e){
                    System.out.println("Error sobrepasado.");
                }
            }   
            queue.add(contents);
            charLength += contents.length();
        }
        notifyAll();
    }
    
    /*Comprobamos que la cola no está vacía y extraemos el primero de la cola de 
    texto de los documentos*/
    public synchronized String getContents() {
        while(queue.isEmpty()){
            if(closed == true){
                return null;
            }
            try{
                wait();
            }catch(Exception e){
                System.out.println("Content not found");
            }
        }
        String fileSelected = queue.poll();
        charLength-= fileSelected.length();
        notifyAll();
        return fileSelected;
        
        
    }
}
