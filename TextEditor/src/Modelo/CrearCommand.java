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
public class CrearCommand extends BaseCommand {
    public static final String COMMAND_NAME = "crear";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override
    public String execute(ArrayList<String> args, OutputStream out) {
       return "Documento en blanco habilitado para el archivo";
    }
}
