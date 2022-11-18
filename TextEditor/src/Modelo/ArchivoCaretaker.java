/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.LinkedList;

/**
 *
 * @author vchin
 */
public class ArchivoCaretaker {
    // indice de memento actual
    private int currentIndex = -1;     
    // lista de mementos para los estados
    private final LinkedList<ArchivoMemento> states = new LinkedList<>();          
    
    public void addNewMemento(ArchivoMemento m) {
        states.add(m);           
        currentIndex++;       
    }       
    
    //get current, next and previous mementos
    public ArchivoMemento getCurrentMemento() {           
        return states.get(currentIndex);       
    }
    
    public ArchivoMemento getNextMemento() {           
        int newIndex = currentIndex +1;           
        if( newIndex >= states.size()){               
            return null;           
        }
        
        currentIndex = newIndex;           
        return states.get(currentIndex);       
    }              
    
    public ArchivoMemento getPreviousMemento() {           
        int newIndex = currentIndex-1;                      
        
        if(newIndex  <= -1 || newIndex >= states.size()-1){               
            return null;           
        }
        currentIndex= newIndex;           
        
        return states.get(currentIndex);       
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
        
}
