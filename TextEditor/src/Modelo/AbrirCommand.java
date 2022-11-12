/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vchin
 */
public class AbrirCommand extends BaseCommand{
    public static final String COMMAND_NAME = "abrir";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       

    @Override
    public String execute(ArrayList<String> args, OutputStream out) {
        String contenido = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Txt and Json Files", "txt", "json");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            // Crear el archivo con el directorio
            File archivo = new File(chooser.getSelectedFile().toString());
            try{
                Scanner scanner = new Scanner(archivo);
                while(scanner.hasNextLine()){
                    contenido += "\n" + scanner.nextLine();
                }
                return contenido;
            }
            catch(FileNotFoundException e){
                return e.toString();
            }
        } 
        return "";
    }
}
 