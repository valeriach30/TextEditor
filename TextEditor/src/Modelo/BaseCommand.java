/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.OutputStream;
import java.util.ArrayList;

public abstract class BaseCommand implements ICommand {       
    
    @Override       
    public abstract String getCommandName();       
    
    @Override       
    public abstract String execute(ArrayList<String> args, OutputStream out);       
    
    public void write(OutputStream out, String message) {           
        try {   out.write(message.getBytes());   
                out.flush();           
        } 
        catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
}

