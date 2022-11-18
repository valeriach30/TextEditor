/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileFilter;
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
    public ArrayList<String>  execute(ArrayList<String> args, OutputStream out) {
        ArrayList<String> array = new ArrayList<String>();
        String contenido = "";

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt", "txt", "tsv");
        chooser.addChoosableFileFilter(filter);
        
        FileNameExtensionFilter filterTab = new FileNameExtensionFilter("Txt por tabulaciones", "txt", "tsv");
        chooser.addChoosableFileFilter(filterTab);
        
        filter = new FileNameExtensionFilter("Json", "json", "tsv");
        chooser.addChoosableFileFilter(filter);
        //chooser.setFileFilter(filter);
        

        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            // Crear el archivo con el directorio
            File archivo = new File(chooser.getSelectedFile().toString());
            try{
                
               Scanner scanner = new Scanner(archivo);
                if(filterTab == chooser.getFileFilter()){
                    String temp;
                    String temp2 = "";
                    String chars="";
                    while(scanner.hasNextLine()){
                        chars = "";
                        temp = scanner.nextLine();
                        System.out.println(temp); 
                        System.out.println("1"); 
                        for (int i = 0 ; i<temp.length() ; i++) {
                            chars = chars + temp.charAt(i);
                            if(i%10==0 && i != 0){
                                chars += "&emsp;&emsp;";
                                System.out.println("kk");
                                System.out.println(chars);
                            }                
                        }
                        temp2 += "<p>" + chars + "</p>";
                    }
                    System.out.println(chars);
                    System.out.println("aca");
                    contenido = temp2;
                }
                else{
                    while(scanner.hasNextLine()){
                     contenido += "<p>" + scanner.nextLine() + "</p>";
                    }
                }
                
                array.add(contenido);
                array.add(chooser.getSelectedFile().getPath());
                array.add(chooser.getSelectedFile().getName());
                return array;
            }
            catch(FileNotFoundException e){
                array.add(e.toString());
                return array;
            }
        } 
        return null;
    }
    
}
 