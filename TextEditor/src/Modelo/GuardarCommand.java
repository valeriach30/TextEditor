/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author vchin
 */
public class GuardarCommand extends BaseCommand {
    public static final String COMMAND_NAME = "guardar";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override
    public ArrayList<String> execute(ArrayList<String> args, OutputStream out) {
        ArrayList<String> array = new ArrayList<String>();
        
        File fnew = new File(args.get(1));
        //System.out.println(args.get(0));
        try {
            FileWriter f2 = new FileWriter(fnew, false);
            f2.write(args.get(0));
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }   
        
        return array;
    }
}
