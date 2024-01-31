package com.mycompany.campominado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CampoMinado {
    private Janela janela;
    private Tabuleiro tabuleiro;

    public CampoMinado() {
        initializeGame();
    }

    private void initializeGame() {
        janela = new Janela();
        createNewGame(janela);

        // Adiciona ação de clique no botão Resetar
        janela.Resetar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }

    private void createNewGame(Janela janela) {
        // Cria um novo tabuleiro passando o painel Campo para receber os blocos
        tabuleiro = new Tabuleiro(janela);
        configureJanelaVisibility();
    }

    private void configureJanelaVisibility() {
        janela.setVisible(true);
        janela.Campo.setVisible(true);
    }

    private void resetGame() {
        hideCampo();
        removeOldBlocks();
        resetTabuleiro();
        createNewGame(janela);
    }

    private void hideCampo() {
        janela.Campo.setVisible(false);
    }

    private void removeOldBlocks() {
        janela.Campo.removeAll();
    }

    private void resetTabuleiro() {
        tabuleiro = null;
    }

    public static void main(String[] args) {
       
        CampoMinado game = new CampoMinado();
    }
}
