package com.mycompany.campominado;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Tabuleiro {

    private static final int COLUNAS = 9;
    private static final int LINHAS = 9;
    private int quantMinas;
    private int countTab;
    private boolean status;

    private final Blocos[][] matrizBlocos;
    private ArrayList<Blocos> minas;
    private final ArrayList<Blocos> bandeiras;

    public Tabuleiro(Janela janela) {
        this.quantMinas = 10;
        this.countTab = 81;
        this.status = false;
        this.matrizBlocos = new Blocos[LINHAS][COLUNAS];
        this.bandeiras = new ArrayList<>();
        janela.quantMinas.setText(String.valueOf(quantMinas));
         //quantidade de minas no tabuleiro

        preencheTabuleiro(janela);
        espalhaMinas();
    }

    private void preencheTabuleiro(Janela janela) {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                Blocos bloco = new Blocos(i, j);
                configurarBloco(bloco, janela);
                this.matrizBlocos[i][j] = bloco;
                janela.Campo.add(matrizBlocos[i][j]);
            }
        }
    }

   private void configurarBloco(Blocos bloco, Janela janela) {
        bloco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!status){
                    facaMouseClick(bloco, e, janela); 
                }
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bloco.requestFocus();
            }
        });

        bloco.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!status){
                     facaTeclaPressiona(bloco, e, janela);
                }
               
            }
        });

        bloco.setFocusable(true);
        bloco.requestFocusInWindow();

        bloco.setSize(40, 40);
        bloco.setLocation(40 * bloco.getCoordenada().getY(), 40 * bloco.getCoordenada().getX());
        bloco.setForeground(Color.WHITE);
        bloco.setBackground(new Color(41, 41, 41));
        bloco.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    private void facaMouseClick(Blocos bloco, MouseEvent e, Janela janela) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            facaClickEsquerdo(bloco, janela);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            facaClickDireito(bloco, janela);
        }
    }

    private void facaTeclaPressiona(Blocos bloco, KeyEvent e, Janela janela) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            facaClickEsquerdo(bloco, janela);
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
            facaClickDireito(bloco, janela);
        }
    }

    private void facaClickEsquerdo(Blocos bloco, Janela janela) {
        if (verificaClicouMina(bloco)) {
            perdeuJogo(janela);

        } else {
            mostraBlocosAoRedor(bloco, janela);
            if (countTab == quantMinas) {
                ganhouJogo(janela);
            }
        }
    }

    private void facaClickDireito(Blocos bloco, Janela janela) {
        if (bloco.isEnabled() && !"🏴".equals(bloco.getText())) {
            bloco.setBackground(new Color(202, 62, 71));
            bloco.setText("🏴");
            colocaBandeira(bloco, janela);
        } else if (bloco.isEnabled() && "🏴".equals(bloco.getText())) {
            bloco.setBackground(new Color(41, 41, 41));
            bloco.setText("X");
            quantMinas++;
            janela.quantMinas.setText(String.valueOf(quantMinas));
        }
    }

    private boolean verificaClicouMina(Blocos blocoClicado) {
        return blocoClicado.getText().equals("X") && minas.contains(blocoClicado);
    }

    private void mostraBlocosAoRedor(Blocos blocoClicado, Janela janela) {
        if (blocoClicado.getCoordenada().getX() < 0 || blocoClicado.getCoordenada().getX() >= LINHAS
                || blocoClicado.getCoordenada().getY() < 0 || blocoClicado.getCoordenada().getY() >= COLUNAS) {
            return;
        }

        blocoClicado = matrizBlocos[blocoClicado.getCoordenada().getX()][blocoClicado.getCoordenada().getY()];
        
    
        if (!blocoClicado.isEnabled()) {
            
            return;
        }

        blocoClicado.setEnabled(false);
        short numMinasAoRedor = numeroMinasProximas(blocoClicado);
        
        this.countTab --;
 
        String textInBlock = (numMinasAoRedor > 0) ? String.valueOf(numMinasAoRedor) : "";
        blocoClicado.setText(textInBlock);

        if (numMinasAoRedor == 0) {
            mostraBlocosAoRedor(somaCoordenadasBloco(0, -1, blocoClicado),janela);
            mostraBlocosAoRedor(somaCoordenadasBloco(0, 1, blocoClicado),janela);
            mostraBlocosAoRedor(somaCoordenadasBloco(-1, 0, blocoClicado),janela);
            mostraBlocosAoRedor(somaCoordenadasBloco(1, 0, blocoClicado),janela);
            mostraBlocosAoRedor(somaCoordenadasBloco(1, 1, blocoClicado),janela);
            mostraBlocosAoRedor(somaCoordenadasBloco(1, -1, blocoClicado),janela);
            mostraBlocosAoRedor(somaCoordenadasBloco(-1, 1, blocoClicado),janela);
            mostraBlocosAoRedor(somaCoordenadasBloco(-1, -1, blocoClicado),janela);
        }
        
        
    }

    private short numeroMinasProximas(Blocos blocoClicado) {
        short n = 0;

        int lBloco = blocoClicado.getCoordenada().getX();
        int cBloco = blocoClicado.getCoordenada().getY();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int linhaAdjacente = lBloco + i;
                int colunaAdjacente = cBloco + j;

                if (linhaAdjacente >= 0 && linhaAdjacente < LINHAS
                        && colunaAdjacente >= 0 && colunaAdjacente < COLUNAS) {

                    Blocos blocoAoRedor = matrizBlocos[linhaAdjacente][colunaAdjacente];

                    if (coordenadaJaExisteMina(blocoAoRedor.getCoordenada().getX(), blocoAoRedor.getCoordenada().getY())) {
                        n++;
                    }
                }
            }
        }
        return n;
    }

    private Blocos somaCoordenadasBloco(int acrescimoX, int acrescimoY, Blocos blocoAtual) {
        return new Blocos((blocoAtual.getCoordenada().getX() + acrescimoX), (blocoAtual.getCoordenada().getY() + acrescimoY));
    }

    private boolean coordenadaJaExisteMina(int x, int y) {
        return minas.stream().anyMatch(mina -> mina.getCoordenada().getX() == x && mina.getCoordenada().getY() == y);
    }

    private void espalhaMinas() {
        this.minas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantMinas; i++) {
            int randX, randY;

            do {
                randX = random.nextInt(LINHAS);
                randY = random.nextInt(COLUNAS);
            } while (coordenadaJaExisteMina(randX, randY));

            Blocos novaMina = matrizBlocos[randX][randY];
            System.out.println(" i  | j  " + novaMina.getCoordenada().getX() + "| " + novaMina.getCoordenada().getY());
            this.minas.add(novaMina);
        }
    }

    private void colocaBandeira(Blocos blocoSelecionado, Janela janela) {
        this.bandeiras.add(matrizBlocos[blocoSelecionado.getCoordenada().getX()][blocoSelecionado.getCoordenada().getY()]);
        quantMinas--;
        janela.quantMinas.setText(String.valueOf(quantMinas));

        if (quantMinas == 0) {
            if (verificaSeGanhou()) {
                ganhouJogo(janela);
            } else {
                perdeuJogo(janela);
            }
        }
    }

    private boolean verificaSeGanhou() {
        return bandeiras.stream().allMatch(blocoBandeira -> minas.contains(blocoBandeira));
    }

    private void perdeuJogo(Janela janela) {
        janela.mudarRostoResetar(false);
        finalizaJogo(janela);
        janela.Resetar.setIcon(new ImageIcon(getClass().getResource("/triste.png")));
        JOptionPane.showMessageDialog(null, "Opa! Você  perdeu o jogo 😞", "Perdeu", JOptionPane.INFORMATION_MESSAGE);
        status = true;
    }

    private void ganhouJogo(Janela janela) {
        janela.mudarRostoResetar(true);
        finalizaJogo(janela);
        JOptionPane.showMessageDialog(null, "Parabéns! Você venceu o jogo 😊", "Venceu", JOptionPane.INFORMATION_MESSAGE);
        status = true;
    }


    private void finalizaJogo(Janela janela) {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                mostraBlocosAoRedor(matrizBlocos[i][j],janela);
            }
        }

        revelaMinas();
    }

    private void revelaMinas() {
        for (Blocos mina : minas) {
            
            ImageIcon icone = new ImageIcon(getClass().getResource("/pngwing.com.png"));
            Image imagemOriginal = icone.getImage();
            Image imagemRedimensionada = imagemOriginal.getScaledInstance(20, 20, java.awt.Image.SCALE_DEFAULT); // Ajuste os valores conforme necessário
            icone = new ImageIcon(imagemRedimensionada);
            matrizBlocos[mina.getCoordenada().getX()][mina.getCoordenada().getY()].setIcon(icone);
            matrizBlocos[mina.getCoordenada().getX()][mina.getCoordenada().getY()].setText("");
           
        }
    }
}
