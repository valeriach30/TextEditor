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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    public ArrayList<String> execute(ArrayList<String> args, OutputStream out) {
        ArrayList<String> array = new ArrayList<String>();
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt", "txt", "tsv");
        chooser.addChoosableFileFilter(filter);
        
        filter = new FileNameExtensionFilter("Txt por tabulaciones", "txt", "tsv");
        chooser.addChoosableFileFilter(filter);
        
        filter = new FileNameExtensionFilter("Json", "json", "tsv");
        chooser.addChoosableFileFilter(filter);
        
        //chooser.getSelectedFile();
        
        //System.out.println( chooser.getSelectedFile());
        
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            //selecciona la extension del archivo  
            String formato = "."+(((FileNameExtensionFilter) chooser.getFileFilter()).getExtensions()) [0];
            
            File archivo = chooser.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(archivo + formato);
                String contenido = args.get(0);
                writer.write(contenido);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(GuardarComoCommand.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }else
            array = null;
        return array;
    }
    
}
