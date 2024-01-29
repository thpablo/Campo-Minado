package com.mycompany.campominado;

import java.awt.event.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CampoMinado {

    Janela janela;
    Tabuleiro tabuleiro;

    void criarJogo(Janela janela) {
        /* Cria tabuleiro passando Painel Campo para receber os blocos */
        tabuleiro = new Tabuleiro(janela);
        janela.setVisible(true);
        janela.Campo.setVisible(true);
        /* Coloca acao de clique em Resetar */
        janela.Resetar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /* Esconde campo onde sera removido itens */
                janela.Campo.setVisible(false);
                /* Remove todos blocos antigos */
                janela.Campo.removeAll();
                /* Muda Cara para feliz */
                janela.Resetar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feliz.png")));
                /* Anula referencia ao jogo anterior */
                tabuleiro = null;
                /* Cria novo jogo */
                criarJogo(janela);
            }
        });
    }

    CampoMinado() {
        /* Cria janela com os componentes visuais */
        janela = new Janela();
        /* Cria Tabuleiro que contem o jogo */
        criarJogo(janela);
    }

    public static void main(String[] args) {
        CampoMinado game = new CampoMinado();
    }
}
