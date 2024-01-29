package com.mycompany.campominado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Janela extends javax.swing.JFrame {

    public void mudarRostoResetar(boolean venceuJogo) {
        if (venceuJogo) {
            Resetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feliz.png")));
        } else {
            Resetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/triste.png")));
        }

    }

    public void iniciaModoPanico(JPanel Panico) {
    }

    public Janela() {
        /* Cria janelas */
        super("Campo Minado");                           //Titulo da janela
        initComponents();                                   //Estabelece tamanho
        iniciaModoPanico(Panico);
        Campo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Menu.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setLocationRelativeTo(null);                   //Centraliza na tela
        this.setResizable(false);                           //Bloqueia redimensionar a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra programa ao fechar janela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        MinasBox = new javax.swing.JPanel();
        quantMinas = new javax.swing.JLabel();
        Resetar = new javax.swing.JButton();
        Campo = new javax.swing.JPanel();
        Panico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setResizable(false);

        Menu.setBackground(new java.awt.Color(65, 65, 65));
        Menu.setForeground(new java.awt.Color(255, 255, 255));
        Menu.setAlignmentX(0.0F);
        Menu.setAlignmentY(0.0F);
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Menu.setPreferredSize(new java.awt.Dimension(720, 100));

        MinasBox.setBackground(new java.awt.Color(49, 49, 49));

        quantMinas.setBackground(new java.awt.Color(202, 62, 71));
        quantMinas.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        quantMinas.setForeground(new java.awt.Color(202, 62, 71));
        quantMinas.setText("0");

        javax.swing.GroupLayout MinasBoxLayout = new javax.swing.GroupLayout(MinasBox);
        MinasBox.setLayout(MinasBoxLayout);
        MinasBoxLayout.setHorizontalGroup(
            MinasBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MinasBoxLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(quantMinas)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        MinasBoxLayout.setVerticalGroup(
            MinasBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MinasBoxLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(quantMinas)
                .addGap(16, 16, 16))
        );

        quantMinas.getAccessibleContext().setAccessibleName("quantMinas");

        Resetar.setBackground(new java.awt.Color(73, 73, 73));
        Resetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feliz.png"))); // NOI18N
        Resetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(MinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206)
                .addComponent(Resetar)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Resetar)
                    .addComponent(MinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Campo.setBackground(new java.awt.Color(49, 49, 49));
        Campo.setAlignmentX(0.0F);
        Campo.setAlignmentY(0.0F);
        Campo.setPreferredSize(new java.awt.Dimension(357, 720));

        javax.swing.GroupLayout CampoLayout = new javax.swing.GroupLayout(Campo);
        Campo.setLayout(CampoLayout);
        CampoLayout.setHorizontalGroup(
            CampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        CampoLayout.setVerticalGroup(
            CampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        Panico.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PanicoLayout = new javax.swing.GroupLayout(Panico);
        Panico.setLayout(PanicoLayout);
        PanicoLayout.setHorizontalGroup(
            PanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        PanicoLayout.setVerticalGroup(
            PanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Campo, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Panico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ResetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Campo;
    public javax.swing.JPanel Menu;
    public javax.swing.JPanel MinasBox;
    private javax.swing.JPanel Panico;
    public javax.swing.JButton Resetar;
    public javax.swing.JLabel quantMinas;
    // End of variables declaration//GEN-END:variables
}
