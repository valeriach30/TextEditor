/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author vchin
 */
public class ArchivoMemento {
    // objeto memento del empleado
    public Archivo archivo;              
    
    public ArchivoMemento(Archivo archivo){           
        this.archivo = archivo;       
    }
    
    public Archivo getMemento(){           
        return archivo;       
    }  
}
