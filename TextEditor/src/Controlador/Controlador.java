/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Archivo;
import Modelo.ArchivoCaretaker;
import Modelo.ArchivoMemento;
import Modelo.CommandManager;
import Modelo.ICommand;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author vchin
 */
public class Controlador {
    
    // archivo que cambiara
    Archivo archivo = new Archivo();
    
    // archivo actual
    Archivo copia = new Archivo();
    
    // array de archivos que se han abierto
    ArrayList<Archivo> archivos = new ArrayList<Archivo>();
    
    // objeto con lista de mementos y métodos para obtenerlos
    private ArchivoCaretaker caretaker = new ArchivoCaretaker();
    
    CommandManager manager = CommandManager.getIntance(); 

    ArchivoCaretaker archivosRedos = new ArchivoCaretaker();
    
    public Controlador(){
    }

    public void crearArchivo(String nombre) {
        ArrayList<String> commandArgs = new ArrayList<String>();
        commandArgs.add(nombre);
        ICommand command = manager.getCommand("crear");   
        command.execute(commandArgs, System.out);        
    }
    
    public String abrirArchivo() {
        

        ArrayList<String> commandArgs = new ArrayList<String>();
        ICommand command = manager.getCommand("abrir");   
        ArrayList<String> arrayArchivo = command.execute(commandArgs, System.out);         
        
        if(arrayArchivo != null){
            // Obtener la informacion del archivo abierto
            String contenido = arrayArchivo.get(0);
            String direccion = arrayArchivo.get(1);
            String nombre = arrayArchivo.get(2);

            Boolean archivoAgregado = false;
            Archivo actual = null;
            // Determinar si el archivo ya fue abierto
            for (int i = 0; i < archivos.size(); i++) {
                if(archivos.get(i).getNombre().equals(nombre)){
                    archivoAgregado = true;
                    actual = archivos.get(i);
                    this.copia = actual;
                    // el archivo ya fue abierto, entonces pueden haber palabras resaltadas
                    contenido = resaltarArchivo("","blue"); //problemente haya que cambiar el segundo parametro(color)
                }
            }

            // Guardar archivo como el actual
            if(!archivoAgregado){
                // Es un archivo nuevo, entonces se agrega a la lista
                this.copia = new Archivo(contenido, nombre, direccion);
                archivos.add(copia);
            }
            else{
                this.copia = actual;
            }
            //resetea los undo
            archivosRedos =  new ArchivoCaretaker();
            copia.setContenido(contenido);
            archivosRedos.addNewMemento( copia.createMemento());
            
            return contenido;  
        }
       return "";
            
    }
    
    public boolean guardarArchivo(String nuevoContenido) {
        
        if(copia.getDireccion() == null){
            return guardarComoArchivo(nuevoContenido);
        }
        
        ArrayList<String> commandArgs = new ArrayList<String>();
        commandArgs.add(nuevoContenido);
        commandArgs.add(copia.getDireccion());
        
        
        ICommand command = manager.getCommand("guardar");   
        ArrayList<String> arrayArchivo = command.execute(commandArgs, System.out); 
        
        return true;
        
    }
    
    public boolean guardarComoArchivo(String nuevoContenido) {
        ArrayList<String> commandArgs = new ArrayList<String>();
        commandArgs.add(nuevoContenido);
        System.out.println(nuevoContenido);
        ICommand command = manager.getCommand("guardar como");   
        ArrayList<String> arrayArchivo = command.execute(commandArgs, System.out); 
        if(arrayArchivo == null)
            return false;//no se creo el archivo
        return true;
    }
    
    public String resaltarArchivo(String seleccion,String color) {
        ArrayList<String> commandArgs = new ArrayList<String>();
        
        commandArgs.add(copia.getDireccion());
        commandArgs.add(seleccion);
        commandArgs.add(color);
        
        // Agregar las palabras subrayadas del archivo
        for (int i = 0; i < copia.getPalabrasSubrayadas().size(); i++) {
             commandArgs.add(copia.getPalabrasSubrayadas().get(i));
        }
        
        // Agregar los colores
        for (int i = 0; i < copia.getColores().size(); i++) {
             commandArgs.add(copia.getColores().get(i));
        }
        ICommand command = manager.getCommand("resaltar");   
        ArrayList<String> arrayArchivo = command.execute(commandArgs, System.out); 
        
        // Obtener las nuevas palabras subrayadas
        for (int i = 0; i < arrayArchivo.size() - copia.getColores().size(); i++) {
            copia.agregarPalabraSubrayada(arrayArchivo.get(i));
            copia.agregarColor(color);
        }
        // El contenido del archivo va a ser el ultimo string del array 
        // Se guarda para retornarlo despues
        String contenido = arrayArchivo.get(arrayArchivo.size() - 1);
        return contenido;
    }
    
    public String undo() {

        String retornado = archivosRedos.getPreviousMemento().getMemento().getContenido();
        return retornado;

    }
    
    public String redo() {
 
        String retornado = archivosRedos.getNextMemento().getMemento().getContenido();
        return retornado;
    }
    public void resetRedo(){
        archivosRedos.deleteNextsMementos();
        
    }
    
    public void addUndo(String text){
        if(archivosRedos.getCurrentIndex()==-1){
            copia.setContenido("");
            archivosRedos.addNewMemento( copia.createMemento());
        }
            
        copia.setContenido(text);
        archivosRedos.addNewMemento( copia.createMemento());
    }
    

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    
}
