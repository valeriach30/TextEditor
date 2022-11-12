/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteditor;

import java.util.HashMap;

/**
 *
 * @author vchin
 */
public class CommandManager {
    private static CommandManager commandManager;       
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =          
            new HashMap<String, Class<? extends ICommand>>();       
    
    private CommandManager() {           
        registCommand(AbrirCommand.COMMAND_NAME, AbrirCommand.class);           
        registCommand(CrearCommand.COMMAND_NAME, CrearCommand.class);           
        registCommand(GuardarCommand.COMMAND_NAME, GuardarCommand.class);           
        registCommand(GuardarComoCommand.COMMAND_NAME, GuardarComoCommand.class);           
        registCommand(RedoCommand.COMMAND_NAME, RedoCommand.class);           
        registCommand(ResaltarCommand.COMMAND_NAME, ResaltarCommand.class);           
        registCommand(UndoCommand.COMMAND_NAME, UndoCommand.class);
    }       
    
    public static synchronized CommandManager getIntance() {           
        if (commandManager == null) {               
            commandManager = new CommandManager();   
        }
        return commandManager;   
    }       
    
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toUpperCase())) {               
            try {                   
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {   e.printStackTrace();                   
            return new ErrorCommand();   
            }           
        } 
        else {
            return new NotFoundCommand();   
        }   
    }       
    
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    }   
}
