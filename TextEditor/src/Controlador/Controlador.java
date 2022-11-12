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
        String contenido = arrayArchivo.get(0);
        String direccion = arrayArchivo.get(1);
        String nombre = arrayArchivo.get(2);
        this.archivo = new Archivo(contenido, nombre, direccion);
        System.out.println(archivo.toString());
        return contenido;      
    }
    
    public void guardarArchivo() {
        
    }
    
    public void guardarComoArchivo() {
        
    }
    
    public void resaltarArchivo() {
        
    }
    
    public void undo() {
        
    }
    
    public void redo() {
        
    }
    
    
}
