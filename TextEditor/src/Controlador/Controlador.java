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
        String seleccion = command.execute(commandArgs, System.out); 
        return seleccion;      
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
