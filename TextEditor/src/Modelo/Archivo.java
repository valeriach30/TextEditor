/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author vchin
 */
public class Archivo {
    private String contenido;       
    private String nombre;
    private String direccion;
    private ArrayList<String> palabrasSubrayadas = new ArrayList<String>();

    public Archivo(String contenido) {
        this.contenido = contenido;
    }
    
    public Archivo(){
        
    }

    public Archivo(String contenido, String nombre, String direccion) {
        this.contenido = contenido;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    
    // crea un memento a partir del estado, clonandolo
    public ArchivoMemento createMemento(){           
        try {               
            return new ArchivoMemento((Archivo)this.clone());           
        } catch (Exception e) {               
            throw new RuntimeException("Error al clonar el empleado");           
        }       
    }              
    
    // obtiene el memento y lo restaura en su estado
    // uno a uno los valores del estado
    public void restoreMemento(ArchivoMemento memento){           
        Archivo archivo = memento.getMemento();           
        this.contenido = archivo.contenido;     
        this.nombre = archivo.nombre;       
        this.direccion = archivo.direccion;       
    }   

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<String> getPalabrasSubrayadas() {
        return palabrasSubrayadas;
    }

    public void setPalabrasSubrayadas(ArrayList<String> palabrasSubrayadas) {
        this.palabrasSubrayadas = palabrasSubrayadas;
    }
    
    public void agregarPalabraSubrayada(String palabra){
        this.palabrasSubrayadas.add(palabra);
    }
}
