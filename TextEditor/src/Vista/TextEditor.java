/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import java.awt.Color;
import Controlador.Controlador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author vchin
 */
public class TextEditor extends javax.swing.JFrame {

    Controlador control;
    String resaltadorColor = "red";//se setea por default el color rojo
    
    /**
     * Creates new form TextEditor
     */
    public TextEditor() {
        //super(parent, modal);
        initComponents();
        jEditorPane1.setContentType("text/html");
        this.control = new Controlador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        redo = new javax.swing.JButton();
        undo = new javax.swing.JButton();
        ButtonColorSelect = new javax.swing.JButton();
        resaltar = new javax.swing.JButton();
        guardarcomo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        abrir = new javax.swing.JButton();
        crear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(774, 512));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        redo.setBackground(new java.awt.Color(255, 255, 255));
        redo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/redo.jpeg"))); // NOI18N
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });
        jPanel1.add(redo);
        redo.setBounds(560, 10, 75, 60);

        undo.setBackground(new java.awt.Color(255, 255, 255));
        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/undo.jpeg"))); // NOI18N
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        jPanel1.add(undo);
        undo.setBounds(470, 10, 75, 60);

        ButtonColorSelect.setBackground(new java.awt.Color(255, 0, 0));
        ButtonColorSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonColorSelectActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonColorSelect);
        ButtonColorSelect.setBounds(430, 60, 30, 20);

        resaltar.setBackground(new java.awt.Color(255, 255, 255));
        resaltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/highlight.png"))); // NOI18N
        resaltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resaltarActionPerformed(evt);
            }
        });
        jPanel1.add(resaltar);
        resaltar.setBounds(380, 10, 75, 60);

        guardarcomo.setBackground(new java.awt.Color(255, 255, 255));
        guardarcomo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/saveasfile.png"))); // NOI18N
        guardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarcomoActionPerformed(evt);
            }
        });
        jPanel1.add(guardarcomo);
        guardarcomo.setBounds(290, 10, 72, 60);

        guardar.setBackground(new java.awt.Color(255, 255, 255));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/savefile.jpeg"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar);
        guardar.setBounds(200, 10, 75, 60);

        abrir.setBackground(new java.awt.Color(255, 255, 255));
        abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/openfile.jpeg"))); // NOI18N
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jPanel1.add(abrir);
        abrir.setBounds(100, 10, 80, 60);

        crear.setBackground(new java.awt.Color(255, 255, 255));
        crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/newfile.png"))); // NOI18N
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        jPanel1.add(crear);
        crear.setBounds(10, 10, 70, 60);

        jEditorPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jEditorPane1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jEditorPane1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 80, 780, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        String contenido = ""; //= jEditorPane1.getText();
        try {
            contenido = jEditorPane1.getDocument().getText( 0 , jEditorPane1.getDocument().getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean seGuardo = control.guardarArchivo(contenido);
        if(seGuardo)
            JOptionPane.showMessageDialog(null, "Archivo Guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
                        
    }//GEN-LAST:event_guardarActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        
        jEditorPane1.setBackground(Color.white);
        jEditorPane1.setEnabled(true);
        control.crearArchivo("xd");
    }//GEN-LAST:event_crearActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        jEditorPane1.setBackground(Color.white);
        jEditorPane1.setEnabled(true);
        // Seleccionar el archivo
        String contenido = control.abrirArchivo();
        jEditorPane1.setText(contenido);
        
    }//GEN-LAST:event_abrirActionPerformed

    private void guardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarcomoActionPerformed
        String contenido = ""; //= jEditorPane1.getText();
        try {
            contenido = jEditorPane1.getDocument().getText( 0 , jEditorPane1.getDocument().getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean seCreo = control.guardarComoArchivo(contenido);
        if(seCreo)
            JOptionPane.showMessageDialog(null, "Archivo Guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_guardarcomoActionPerformed

    private void resaltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resaltarActionPerformed
        //jEditorPane1.replaceSelection("hola");
        //String seleccionado = jEditorPane1.getSelectedText();
        //jEditorPane1.replaceSelection("<font color=\"red\">hola</font>");
        try{ 
        String seleccionado = jEditorPane1.getSelectedText();
        String contenidoFinal = control.resaltarArchivo(seleccionado,resaltadorColor);
        System.out.println(contenidoFinal);
        jEditorPane1.setText(contenidoFinal);
        
        }catch(NullPointerException e){
            
        }
    }//GEN-LAST:event_resaltarActionPerformed

    private void jEditorPane1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditorPane1KeyTyped
        int keyInt = (int)evt.getKeyChar();
        //System.out.println(keyInt);
        
        //del es 8, intro 10, Ctrl V 22,  espacio 32 y suprimir 127
        //esto se hace para no hacer tantos undo inutiles
        
        if(keyInt == 8|| keyInt == 10 ||keyInt == 22 ||keyInt == 32 || keyInt == 127){
            
            control.resetRedo();
        
            String text = jEditorPane1.getText();
            control.addUndo(text);
            
        
        }else{ //cambia la ultima posicion
            control.resetRedo();
        }
        
    }//GEN-LAST:event_jEditorPane1KeyTyped

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed

            try {
                String text = control.undo();
                jEditorPane1.setText(text);
            
            } catch (NullPointerException e) {
        }
            
    }//GEN-LAST:event_undoActionPerformed

    public void setResaltadorColor(String resaltadorColor){
        this.resaltadorColor = resaltadorColor;
        if(resaltadorColor=="red")
            ButtonColorSelect.setBackground(Color.red);
        else if(resaltadorColor=="green")
            ButtonColorSelect.setBackground(Color.green);
        else if(resaltadorColor=="yellow")
            ButtonColorSelect.setBackground(Color.yellow);
        else if(resaltadorColor=="blue")
            ButtonColorSelect.setBackground(Color.blue);
    
    }
    
    private void ButtonColorSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonColorSelectActionPerformed
        Colores colores = new Colores(this,true);
        colores.setVisible(true);
    }//GEN-LAST:event_ButtonColorSelectActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
              
            try {
            String text = control.redo();
            jEditorPane1.setText(text);
        } catch (NullPointerException e) {
        }
   
    }//GEN-LAST:event_redoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TextEditor dialog = new TextEditor();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonColorSelect;
    private javax.swing.JButton abrir;
    private javax.swing.JButton crear;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarcomo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton redo;
    private javax.swing.JButton resaltar;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables
}
