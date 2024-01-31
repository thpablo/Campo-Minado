 package com.mycompany.campominado;

import javax.swing.*;

import java.awt.event.*;

public class Janela extends javax.swing.JFrame {
   private Panico p;

    
    
    public void mudarRostoResetar(boolean venceuJogo) {
        //Resetar.setIcon(venceuJogo ? caraFeliz : caraTriste);
    }    
    public Janela() {
        /* Cria janelas */
        super("Campo Minado");                           //Titulo da janela
        initComponents();   
        
        

         // Adicione um WindowListener para monitorar o fechamento da janela principal
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (p != null && p.isVisible()) {
                    p.dispose();  // Fecha a janela Panico
                }
            }
        });
        
    
 
//Estabelece tamanho
        Campo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Menu.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setLocationRelativeTo(null);                   //Centraliza na tela
        this.setResizable(false);                           //Bloqueia redimensionar a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Encerra programa ao fechar janela
        
        
    }
    
      private void abrirOutroFrame() {
        // Crie um novo frame (você pode ajustar o código conforme necessário)
        JFrame outroFrame = new JFrame("Outro Frame");
        outroFrame.setSize(300, 200);
        outroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Adicione algum conteúdo ao novo frame (você pode ajustar o código conforme necessário)
        JLabel label = new JLabel("Este é outro frame!");
        outroFrame.add(label);

        // Tornar o novo frame visível
        outroFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        MinasBox = new javax.swing.JPanel();
        quantMinas = new javax.swing.JLabel();
        Resetar = new javax.swing.JButton();
        Campo = new javax.swing.JPanel();
        buttonPanic = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        MinasBox.setAlignmentX(0.0F);
        MinasBox.setAlignmentY(0.0F);
        MinasBox.setFocusCycleRoot(true);
        MinasBox.setPreferredSize(new java.awt.Dimension(119, 66));

        quantMinas.setBackground(new java.awt.Color(202, 62, 71));
        quantMinas.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        quantMinas.setForeground(new java.awt.Color(202, 62, 71));
        quantMinas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantMinas.setText("0");
        quantMinas.setToolTipText("");
        quantMinas.setAlignmentY(0.0F);

        javax.swing.GroupLayout MinasBoxLayout = new javax.swing.GroupLayout(MinasBox);
        MinasBox.setLayout(MinasBoxLayout);
        MinasBoxLayout.setHorizontalGroup(
            MinasBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(quantMinas, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );
        MinasBoxLayout.setVerticalGroup(
            MinasBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(quantMinas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        quantMinas.getAccessibleContext().setAccessibleName("quantMinas");

        Resetar.setBackground(new java.awt.Color(65, 65, 65));
        Resetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feliz.png"))); // NOI18N
        Resetar.setBorderPainted(false);
        Resetar.setContentAreaFilled(false);
        Resetar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Resetar.setFocusable(false);
        Resetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetarActionPerformed(evt);
            }
        });

        Campo.setBackground(new java.awt.Color(49, 49, 49));
        Campo.setAlignmentX(0.0F);
        Campo.setAlignmentY(0.0F);
        Campo.setPreferredSize(new java.awt.Dimension(360, 360));

        javax.swing.GroupLayout CampoLayout = new javax.swing.GroupLayout(Campo);
        Campo.setLayout(CampoLayout);
        CampoLayout.setHorizontalGroup(
            CampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        CampoLayout.setVerticalGroup(
            CampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        buttonPanic.setBackground(new java.awt.Color(255, 102, 102));
        buttonPanic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanic.setForeground(new java.awt.Color(255, 255, 255));
        buttonPanic.setText("Panico");
        buttonPanic.setBorder(null);
        buttonPanic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonPanicMouseEntered(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("1 - Marca Bandeira");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter - Explode Posicao");

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(MinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Resetar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonPanic, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(MenuLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addComponent(Resetar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanic, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    private void ResetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetarActionPerformed
        this.Resetar.setIcon(new ImageIcon(getClass().getResource("/feliz.png")));  
    }//GEN-LAST:event_ResetarActionPerformed

    private void buttonPanicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPanicMouseEntered
        // TODO add your handling code here:
          // Cria uma instância do painel Panico
        if (p == null || !p.isActive()) {
            p = new Panico(this);
            p.setVisible(true);
       
    }
        
          
    
    }//GEN-LAST:event_buttonPanicMouseEntered
  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Campo;
    public javax.swing.JPanel Menu;
    public javax.swing.JPanel MinasBox;
    public javax.swing.JButton Resetar;
    private javax.swing.JButton buttonPanic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel quantMinas;
    // End of variables declaration//GEN-END:variables
}
