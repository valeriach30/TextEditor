/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author vchin
 */
public class UndoCommand extends BaseCommand{
    public static final String COMMAND_NAME = "undo";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override
    public void execute(ArrayList<String> args, OutputStream out) {
        // falta implementar
    }
}
