/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Controlador;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author vchin
 */
public class RedoCommand extends BaseCommand{
    public static final String COMMAND_NAME = "redo";       
    public Controlador control;
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override
    public ArrayList<String> execute(ArrayList<String> args, OutputStream out) {
        ArrayList<String> array = new ArrayList<String>();
        String resultado = control.archivosRedos.getNextMemento().getMemento().getContenido();
        array.add(resultado);
        return array;
    }
    
    public void setControlador(Controlador control){
        this.control = control;
    }
}
