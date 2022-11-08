package textprocessing;
public class FileReader extends Thread{
    private FileNames fn;
    private FileContents fc;
    
    public FileReader(FileNames fn, FileContents fc){
        this.fn = fn;
        this.fc = fc;
    }
    
    /*Activamos y desactivamos el registro llamada registerWriter
     y emplemos la variable ruta para usar la función addContents*/
    @Override
    public void run(){
        String ruta = "";
        
        fc.registerWriter();
        
        while((ruta = fn.getName()) != null ){
            fc.addContents(Tools.getContents(ruta));
//            System.out.println(ruta);
        }
        fc.unregisterWriter();
    }
    
}
