/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Archivo;
import Modelo.ArchivoCaretaker;
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
    
    //guarda los los undo
    ArrayList<String> undoes = new ArrayList<String>();
    
    //guarda los los redo
    ArrayList<String> redoes = new ArrayList<String>();
    
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
        
        ICommand command = manager.getCommand("resaltar");   
        ArrayList<String> arrayArchivo = command.execute(commandArgs, System.out); 
        
        // Obtener las nuevas palabras subrayadas
        for (int i = 0; i < arrayArchivo.size() -1; i++) {
            copia.agregarPalabraSubrayada(arrayArchivo.get(i));
        }
        
        // El contenido del archivo va a ser el ultimo string del array 
        // Se guarda para retornarlo despues
        String contenido = arrayArchivo.get(arrayArchivo.size() - 1);
        return contenido;
    }
    
    public String undo() {
        if(undoes.size() > 0){
            String actualUndo = undoes.get(undoes.size() - 1);
            addRedo(actualUndo); 

            ArrayList<String> commandArgs = undoes;
            ICommand command = manager.getCommand("undo");
            undoes = command.execute(commandArgs, System.out); 

            return actualUndo;
        }
        return "";
    }
    
    public String redo() {
        if(redoes.size() > 0){
            //System.out.println(undoes.toString());
            String actualRedo= redoes.get(redoes.size() - 1);
            addUndo(actualRedo); 

            ArrayList<String> commandArgs = redoes;
            ICommand command = manager.getCommand("redo");
            redoes = command.execute(commandArgs, System.out); 
            
            //.out.println(undoes.toString());
            return actualRedo;
        }
        return "";
        
    }
    public void resetRedo(){
        redoes = new ArrayList<String>();
        
    }
    
    public void resetUndo(){
        undoes = new ArrayList<String>();
        
    }
    
    public int redoesSize(){
        return redoes.size();
    }
    
    public int undoesSize(){
        return undoes.size();
    }
    
    public void addUndo(String text){
        if(undoes.size() >= 20){
            corrimiento(undoes);
            undoes.set(19, text);
        }else{
            undoes.add(text);
        }
        
    }
    
    public void addUndoLast(String text){
        if(undoes.size() == 0){
            undoes.add("");
            undoes.add(text);
        }else{
            undoes.set(undoesSize() - 1, text);
        }
    }
    
    public void addRedo(String text){
        if(redoes.size() >= 20){
            corrimiento(redoes);
            redoes.set(19, text);
        }else{
            redoes.add(text);
        }
    }
    
    //srive para cuando el array de undoes y redoes este full elimine la ultima posicion
    public void corrimiento(ArrayList<String> array){
        String text;
        for (int i = 0; i < array.size()-1; i++) {
            text = array.get(i+1);
            array.set(i, text);
        }

    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    
}
