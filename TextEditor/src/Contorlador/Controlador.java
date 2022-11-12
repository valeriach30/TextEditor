/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contorlador;

import Modelo.Archivo;
import Modelo.ArchivoCaretaker;
import Modelo.CommandManager;
import Modelo.ICommand;
import java.util.ArrayList;

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

    private void crearArchivo(String nombre) {
        ArrayList<String> commandArgs = new ArrayList<String>();
        commandArgs.add(nombre);
        ICommand command = manager.getCommand("crear");   
        command.execute(commandArgs, System.out);        
    }
    
    private void abrirArchivo() {
        
    }
    
    private void guardarArchivo() {
        
    }
    
    private void guardarComoArchivo() {
        
    }
    
    private void resaltarArchivo() {
        
    }
    
    private void undo() {
        
    }
    
    private void redo() {
        
    }
    
    
}
