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
    
    // objeto con lista de mementos y métodos para obtenerlos
    private ArchivoCaretaker caretaker = new ArchivoCaretaker();
    
    CommandManager manager = CommandManager.getIntance(); 
    
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
        
        // Obtener la informacion del archivo abierto
        String contenido = arrayArchivo.get(0);
        String direccion = arrayArchivo.get(1);
        String nombre = arrayArchivo.get(2);
        
        // Guardar archivo como el actual
        this.copia = new Archivo(contenido, nombre, direccion);
        return contenido;      
    }
    
    public void guardarArchivo(String nuevoContenido) {
        
        ArrayList<String> commandArgs = new ArrayList<String>();
        commandArgs.add(nuevoContenido);
        commandArgs.add(copia.getDireccion());
        
        ICommand command = manager.getCommand("guardar");   
        ArrayList<String> arrayArchivo = command.execute(commandArgs, System.out); 
        
    }
    
    public void guardarComoArchivo(String nuevoContenido) {
        ArrayList<String> commandArgs = new ArrayList<String>();
        commandArgs.add(nuevoContenido);
        ICommand command = manager.getCommand("guardar como");   
        ArrayList<String> arrayArchivo = command.execute(commandArgs, System.out); 
    }
    
    public String resaltarArchivo(String seleccion) {
        ArrayList<String> commandArgs = new ArrayList<String>();
        commandArgs.add(copia.getDireccion());
        commandArgs.add(seleccion);
        
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
    
    public void undo() {
        
    }
    
    public void redo() {
        
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    
}
