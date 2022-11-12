/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.OutputStream;
import java.util.ArrayList;

public class NotFoundCommand extends BaseCommand {       
    private static final String COMMAND_NAME = "NOT FOUND";       
    
    @Override       public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override       
    public String execute(ArrayList<String> args, OutputStream out) {           
       return "Comando no encontrado";   
    }   
}