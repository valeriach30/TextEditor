/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteditor;

import java.io.OutputStream;

/**
 *
 * @author vchin
 */
public class GuardarComoCommand extends BaseCommand {
    public static final String COMMAND_NAME = "guardar como";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override       
    public void execute(String[] args, OutputStream out) {           
        // falta implementar
    }
}
