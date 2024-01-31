/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.campominado;

import java.awt.Point;
import javax.swing.JFrame;

/**
 *
 * @author jpcar
 */
public class Panico extends javax.swing.JFrame {

    /**
     * Creates new form Panico
     */
    
 
    
    public Panico(JFrame f) {
        initComponents();
         setTitle("Painel de Pânico");
             Point frameLocation = f.getLocationOnScreen();

        // Configura a localização do painel de pânico com base nas coordenadas do frame
        setLocation(frameLocation);
        setSize(f.getWidth(), f.getHeight());

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
           
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanicoPainel = new javax.swing.JPanel();
        PanicClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        PanicoPainel.setBackground(new java.awt.Color(255, 102, 102));

        PanicClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanicClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DD.png"))); // NOI18N
        PanicClose.setText("Clique aqui...");
        PanicClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanicClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanicCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanicoPainelLayout = new javax.swing.GroupLayout(PanicoPainel);
        PanicoPainel.setLayout(PanicoPainelLayout);
        PanicoPainelLayout.setHorizontalGroup(
            PanicoPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanicoPainelLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(PanicClose, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        PanicoPainelLayout.setVerticalGroup(
            PanicoPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanicoPainelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(PanicClose, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanicoPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanicoPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanicCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanicCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_PanicCloseMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PanicClose;
    private javax.swing.JPanel PanicoPainel;
    // End of variables declaration//GEN-END:variables
}