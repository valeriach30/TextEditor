/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.TextEditor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vchin
 */
public class ResaltarCommand extends BaseCommand {
    public static final String COMMAND_NAME = "resaltar";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override
    public ArrayList<String> execute(ArrayList<String> args, OutputStream out) {
        
        String contenidoFinal = "";
        ArrayList<String> PalabrasSubrayadas = new ArrayList<String>();
        ArrayList<String> resultados = new ArrayList<String>();
        
        File archivo = new File(args.get(0));
        String seleccionado = args.get(1);
        
        // Obtener array con las palabras subrayadas
        for (int i = 2; i < args.size(); i++) {
            PalabrasSubrayadas.add(args.get(i));
        }
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(args.get(0)));
            String line = reader.readLine();
            while(line != null){
                if(line.contains(seleccionado)){
                    String[] palabras = line.split(" ");
                    
                    String temp = "";
                    for (int i = 0; i < palabras.length; i++) {
                        
                        if(palabras[i].contains(seleccionado)){
                            
                            if(palabras[i].equals(seleccionado)){
                                temp += "<font color=\"red\"> "+seleccionado+" </font>";
                                resultados.add(seleccionado);
                            }
                            else{
                                // Determinar si la palabra fue subrayada anteriormente
                                if(estaSubrayada(palabras[i], PalabrasSubrayadas)){
                                    temp += "<font color=\"red\"> "+palabras[i]+" </font>";
                                }
                                else{
                                    temp += " " + palabras[i] + " ";
                                }
                            }
                        }
                        else{
                            // Determinar si la palabra fue subrayada anteriormente
                            if(estaSubrayada(palabras[i], PalabrasSubrayadas)){
                                temp += "<font color=\"red\"> "+palabras[i]+" </font>";
                            }
                            else{
                                temp += " " + palabras[i] + " ";
                            }
                        }
                    }
                    contenidoFinal += "<p> " + temp + " </p>";
                }
                else{
                    String[] palabras2 = line.split(" ");
                    
                    String temp2 = "";
                    for (int i = 0; i < palabras2.length; i++) {
                        if(estaSubrayada(palabras2[i], PalabrasSubrayadas)){
                            temp2 += "<font color=\"red\"> "+palabras2[i]+" </font>";
                        }
                        else{
                            temp2 += " " + palabras2[i] + " ";
                        }
                    }
                    contenidoFinal += "<p> " + temp2 + " </p>";
                }
                
                // read next line
                line = reader.readLine();
            }
            
        }catch(FileNotFoundException e){
        } catch (IOException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultados.add(contenidoFinal);
        return resultados;
    }
    
    public Boolean estaSubrayada(String palabra, ArrayList<String> PalabrasSubrayadas){
        if(PalabrasSubrayadas.contains(palabra)){
            return true;
        }
        return false;
    }
}
