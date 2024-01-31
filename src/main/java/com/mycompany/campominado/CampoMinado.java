package com.mycompany.campominado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CampoMinado {
    private Janela janela;
    private Tabuleiro tabuleiro;

    public CampoMinado() {
       
    }

    private void initializeGame(int cMinas) {
        janela = new Janela();
        createNewGame(janela, cMinas);

        // Adiciona ação de clique no botão Resetar
        janela.Resetar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame(cMinas);
            }
        });
    }

    private void createNewGame(Janela janela, int cMinas) {
        // Cria um novo tabuleiro passando o painel Campo para receber os blocos
        tabuleiro = new Tabuleiro(10,false);
        tabuleiro.iniciaTabuleiro(janela);
        configureJanelaVisibility();
    }

    private void configureJanelaVisibility() {
        janela.setVisible(true);
        janela.Campo.setVisible(true);
    }

    private void resetGame(int cMinas) {
        hideCampo();
        removeOldBlocks();
        resetTabuleiro();
        createNewGame(janela,cMinas);
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
        
        game.initializeGame(10);
    }
}
