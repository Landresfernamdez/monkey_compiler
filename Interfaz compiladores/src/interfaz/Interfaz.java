/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import generated.Scanner;
import linea.TextLineNumber;
import clasesCompiladores.Editor;
import listeners.ThrowingErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import javax.swing.*;

/**
 *
 * @author Jurguen
 */
public class Interfaz extends javax.swing.JFrame {

    private Editor editor;
    Scanner inst = null;
    generated.MonkeyParser parser=null;
    ANTLRInputStream input=null;
    CommonTokenStream tokens = null;
    ParseTree tree=null;
    public static LinkedList<String> msjsError;
    /**
     * Creates new form Interfaz
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        PanelEdicion = new javax.swing.JTextPane();
        scroll = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuOpen = new javax.swing.JMenuItem();
        menuSave = new javax.swing.JMenuItem();
        menuCreate = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jScrollPane3.setViewportView(PanelEdicion);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        menuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder_open_document_text.png"))); // NOI18N
        menuOpen.setText("Open");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuOpen);

        menuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        menuSave.setText("Save");
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuSave);

        menuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stock_new.png"))); // NOI18N
        menuCreate.setText("Create");
        menuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCreateActionPerformed(evt);
            }
        });
        jMenu1.add(menuCreate);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compile");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setLabel("Compile");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilePerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleName("compile");

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tree");

        jMenuItem2.setText("Show tree");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    Showtree(evt);
                }
                catch(Exception exc ){
                    JFrame parent = new JFrame();
                    String multiLineMsg[] = { "Error,", " debe compilar para cargar el arbol"} ;
                    JOptionPane.showMessageDialog(parent, multiLineMsg);
                }
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);
        jMenu3.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	public Interfaz(){
                initComponents();
                msjsError=new LinkedList<String>();
                editor=new Editor();
                scroll.setViewportView(PanelEdicion);
                TextLineNumber lineNumber = new TextLineNumber(PanelEdicion);
                scroll.setRowHeaderView(lineNumber);
	}
    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            String contenido= "";
            try{
                contenido = editor.OpenArchivo(f.getAbsolutePath());
                refrescar(contenido);
            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(this, exc.getMessage(),"Editor",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_menuOpenActionPerformed

    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveActionPerformed
            // TODO add your handling code here:
        String ruta=null;
        if(editor.esNueva()){
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
                ruta = fc.getSelectedFile().getAbsolutePath();
            }
        }
        String contenido = PanelEdicion.getText();
        try {
            editor.saveArchivo(contenido, ruta);
            JOptionPane.showMessageDialog(this, "Archivo guardado con exito","Editor",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception exc){
            JOptionPane.showMessageDialog(this, exc.getMessage(),"Editor",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuSaveActionPerformed

    private void menuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCreateActionPerformed
        // TODO add your handling code here:
        editor.createArchivo();
        refrescar("");

    }//GEN-LAST:event_menuCreateActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void compilePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilePerformed
        // TODO add your handling code here:
        try {
            msjsError.clear();
            jTextArea1.setText("");
            input = new ANTLRInputStream(new FileReader(editor.archivo.nombre));
            inst = new Scanner(input);
            tokens=new CommonTokenStream(inst);
            parser=new generated.MonkeyParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        }
        catch(Exception e){System.out.println("No hay archivo");}
        try{
            tree =parser.program();
            for (String i : this.msjsError)
                jTextArea1.setText(jTextArea1.getText()+i+'\n');
           //System.out.print(tree.getText());
            jTextArea1.setText(jTextArea1.getText()+"Compilacion exitosa!!\n");
        }
        catch (RecognitionException e){
            jTextArea1.setText("Compilacion fallida!!\n");
        }
    }//GEN-LAST:event_compilePerformed
        private void Showtree(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Showtree
        // TODO add your handling code here:
        try{
            java.util.concurrent.Future <JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree,parser);
        }catch (Exception e){
            //System.out.println("Error debe compilar para cargar el arbol");
            JFrame parent = new JFrame();
            String multiLineMsg[] = { "Error,", " debe compilar para cargar el arbol"} ;
            JOptionPane.showMessageDialog(parent, multiLineMsg);

        }
    }//GEN-LAST:event_Showtree

    public String getContenido(){
        return PanelEdicion.getText();
    }
    public void refrescar(String contenido){
        PanelEdicion.setText(contenido);
    } 
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interfaz i=new Interfaz();
                i.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane PanelEdicion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuCreate;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
